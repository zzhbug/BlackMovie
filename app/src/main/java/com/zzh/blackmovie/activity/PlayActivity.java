package com.zzh.blackmovie.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
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
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
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

public class PlayActivity extends AppCompatActivity implements LikeAdapter.OnItemClickListener {
    private static final String TAG = "MainActivity";
    public static final String MOVIE_ID = "movieid";
    @BindView(R.id.recycler_like)
    RecyclerView recyclerLike;
    private TextView movienamePlay;


    private List<MovieLikeAll.LikeMovie> mData;
    private LikeAdapter mAdapter;
    private MoviePlayAll.MovieMessage mContent;
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
        setView();

    }


    private void initView() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.movie_view, null);
        movienamePlay = (TextView) inflate.findViewById(R.id.moviename_play);
        movieareaPlay = (TextView) inflate.findViewById(R.id.moviearea_play);
        movieyearPlay = (TextView) inflate.findViewById(R.id.movieyear_play);
        movierankPlay = (TextView) inflate.findViewById(R.id.movierank_play);
        movieactorPlay = (TextView) inflate.findViewById(R.id.movieactor_play);
        moviedirectorPlay = (TextView) inflate.findViewById(R.id.moviedirector_play);
        moviecontentPlay = (TextView) inflate.findViewById(R.id.moviecontent_play);
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
                        mContent = response.getContent();
                        movienamePlay.setText(mContent.getName());
                        movieareaPlay.setText(mContent.getArea());
                        movieyearPlay.setText(mContent.getYear());
                        movierankPlay.setText("暗黑指数" + mContent.getTerrorismIndex());
                        movieactorPlay.setText("主演：" + mContent.getActor());
                        moviedirectorPlay.setText("导演：" + mContent.getDirector());
                        moviecontentPlay.setText(mContent.getContent());
                        playUrlBy480p = mContent.getPlayUrlBy480p();
                        playfunction();

                    }
                });


    }

    private void setView() {
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
        mVideoView.pause();
        play_url = Contants.PLAY_HEAD_URL + id + Contants.PLAY_FOOT_URL;
        mData.clear();
        mAdapter.notifyDataSetChanged();
        getMessage();
        setView();


    }
}
