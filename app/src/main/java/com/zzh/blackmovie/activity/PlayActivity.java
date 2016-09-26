package com.zzh.blackmovie.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.adapter.LikeAdapter;
import com.zzh.blackmovie.http.BaseCallback;
import com.zzh.blackmovie.http.Contants;
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.MovieLikeAll;
import com.zzh.blackmovie.model.MoviePlayAll;
import com.zzh.blackmovie.ui.selfview.OrientationDetector;
import com.zzh.blackmovie.utils.SysState;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;

public class PlayActivity extends AppCompatActivity implements
        LikeAdapter.OnItemClickListener,
        View.OnClickListener, OrientationDetector.OrientationChangeListener {
    private static final String TAG = "MainActivity";
    public static final String MOVIE_ID = "movieid";

    @BindView(R.id.layoutVideo)
    FrameLayout mVideoLayout;
    @BindView(R.id.recycler_like)
    RecyclerView recyclerLike;

    private TextView movienamePlay;


    private List<MovieLikeAll.LikeMovie> mData;
    private LikeAdapter mAdapter;
    private MoviePlayAll.MovieMessage mDadaMsg;
    private TextView movieareaPlay;
    private TextView movieyearPlay;
    private TextView movierankPlay;
    private TextView movieactorPlay;
    private TextView moviedirectorPlay;
    private TextView moviecontentPlay;
    private String playUrlBy480p;

    private String play_url;
    private String like_url;
    private VideoView mVideoView;
    private ImageView moviextendPlay;
    private LinearLayout movieExtend;

    private boolean isVISIBLE = true;

    private OrientationDetector mOrientationDetector;
    private boolean isFullscreen = false;
    private int cachedHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Vitamio.isInitialized(getApplicationContext());
        ButterKnife.bind(this);
        int movieid = getIntent().getIntExtra(MOVIE_ID, 120);
        play_url = Contants.PLAY_HEAD_URL + movieid + Contants.PLAY_FOOT_URL;
        like_url = Contants.LIKE_HEAD_URL + movieid + Contants.LIKE_FOOT_URL;

        initView();
        getLikeData();

    }


    private void initView() {
        cachedHeight = mVideoLayout.getHeight();
        ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
        cachedHeight = layoutParams.height;


        mOrientationDetector = new OrientationDetector(this);
        mOrientationDetector.enable();
        mOrientationDetector.setOrientationChangeListener(this);


        View inflate = LayoutInflater.from(this).inflate(R.layout.movie_view, null);
        movienamePlay = (TextView) inflate.findViewById(R.id.moviename_play);
        movieareaPlay = (TextView) inflate.findViewById(R.id.moviearea_play);
        movieyearPlay = (TextView) inflate.findViewById(R.id.movieyear_play);
        movierankPlay = (TextView) inflate.findViewById(R.id.movierank_play);
        movieactorPlay = (TextView) inflate.findViewById(R.id.movieactor_play);
        moviedirectorPlay = (TextView) inflate.findViewById(R.id.moviedirector_play);
        moviecontentPlay = (TextView) inflate.findViewById(R.id.moviecontent_play);
        movieExtend = ((LinearLayout) inflate.findViewById(R.id.paly_content));
        moviextendPlay = ((ImageView) inflate.findViewById(R.id.moviextend_play));
        moviextendPlay.setOnClickListener(this);
        getMessage();
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = 1;
                if (position == 0) {
                    type = 3;
                }
                return type;
            }
        });
        recyclerLike.setLayoutManager(layoutManager);
        mData = new ArrayList<>();
        mAdapter = new LikeAdapter(this, mData, R.layout.recycler_like_item);
        mAdapter.setOnItemClickListener(this);
        mAdapter.addHeadView(inflate);
        recyclerLike.setAdapter(mAdapter);
    }

    private void getMessage() {
        OkHttpUtils.get()
                .url(play_url)
                .build()
                .execute(new BaseCallback<MoviePlayAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(MoviePlayAll response, int id) {
                        mDadaMsg = response.getContent();
                        movienamePlay.setText(mDadaMsg.getName());
                        movieareaPlay.setText(mDadaMsg.getArea());
                        movieyearPlay.setText(mDadaMsg.getYear());
                        movierankPlay.setText("暗黑指数" + mDadaMsg.getTerrorismIndex());
                        movieactorPlay.setText("主演：" + mDadaMsg.getActor());
                        moviedirectorPlay.setText("导演：" + mDadaMsg.getDirector());
                        moviecontentPlay.setText(mDadaMsg.getContent());
                        playUrlBy480p = mDadaMsg.getPlayUrlBy480p();
                        playfunction();

                    }
                });


    }

    private void getLikeData() {
        OkHttpUtils.get()
                .url(like_url).build()
                .execute(new BaseCallback<MovieLikeAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(MovieLikeAll response, int id) {
                        List<MovieLikeAll.LikeMovie> content = response.getContent();
                        mAdapter.updataRes(content);
                    }
                });
    }

    private void playfunction() {
        mVideoView = (VideoView) findViewById(R.id.video);
        mVideoView.setVideoPath(playUrlBy480p);
        mVideoView.setMediaController(new MediaController(this));

        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
            }
        });
    }

    @Override
    public void OnItemClick(View view, int position) {
        ToastUtil.makeText(mData.get(position - 1).getName());
        int id = mData.get(position - 1).getId();
        like_url = Contants.LIKE_HEAD_URL + id + Contants.LIKE_FOOT_URL;
        mVideoView.stopPlayback();
        play_url = Contants.PLAY_HEAD_URL + id + Contants.PLAY_FOOT_URL;
        mData.clear();
        mAdapter.notifyDataSetChanged();
        getMessage();
        getLikeData();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.moviextend_play:
                if (isVISIBLE) {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_tag);
                    animation.setFillAfter(true);
                    animation.setFillBefore(false);
                    moviextendPlay.startAnimation(animation);
                    isVISIBLE = false;
                    movieExtend.setVisibility(View.GONE);


                } else {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_tag_2);
                    moviextendPlay.startAnimation(animation);
                    movieExtend.setVisibility(View.VISIBLE);
                    isVISIBLE = true;
                }
        }
    }

    @Override
    public void onOrientationChanged(int screenOrientation, OrientationDetector.Direction direction) {
        Log.d(TAG, "onOrientationChanged: " + screenOrientation);
        if (screenOrientation == 0) {
            isFullscreen = true;
        } else {
            isFullscreen = false;
        }
        onScaleChange(isFullscreen);
    }

    private void onScaleChange(boolean isFullscreen) {
        this.isFullscreen = isFullscreen;
        SurfaceHolder holder = mVideoView.getHolder();
        if (isFullscreen) {
            ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
            int[] widthAndHeight = SysState.getSystemWidthAndHeight();
            layoutParams.width = widthAndHeight[0];
            layoutParams.height = widthAndHeight[1];
            mVideoLayout.setLayoutParams(layoutParams);
            Log.d(TAG, "onScaleChange: " + layoutParams.width + "  " + layoutParams.height);
            holder.setFixedSize(widthAndHeight[0],widthAndHeight[1]);
        } else {
            ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = this.cachedHeight;
            mVideoLayout.setLayoutParams(layoutParams);
            holder.setFixedSize(layoutParams.width, layoutParams.height);
        }
        switchTitleBar(!isFullscreen);
    }

    private void switchTitleBar(boolean show) {
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (show) {
                supportActionBar.show();
            } else {
                supportActionBar.hide();
            }
        }
    }

}
