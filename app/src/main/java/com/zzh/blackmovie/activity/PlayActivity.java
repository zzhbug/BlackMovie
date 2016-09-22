package com.zzh.blackmovie.activity;

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
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.MovieLikeAll;
import com.zzh.blackmovie.model.MoviePlayAll;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class PlayActivity extends AppCompatActivity implements LikeAdapter.OnItemClickListener {
    private static final String TAG = "MainActivity";
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
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
                .url("https://apis.vcinema.cn:8445/v2.3/rest/movie/queryMovieById/228893/956/1?channels=aph1&appVersion=4.1.0&platform=1")
                .build()
                .execute(new BaseCallback<MoviePlayAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(MoviePlayAll response, int id) {
                        mContent=response.getContent();
                        movienamePlay.setText(mContent.getName()+"  ");
                        movieareaPlay.setText(mContent.getArea()+"  ");
                        movieyearPlay.setText("暗黑指数"+mContent.getTerrorismIndex());
                        movieactorPlay.setText("主演："+mContent.getActor());
                        moviedirectorPlay.setText("导演："+mContent.getDirector());
                        moviecontentPlay.setText(mContent.getContent());

                    }
                });


    }

    private void setView() {
        OkHttpUtils.get()
                .url("https://apis.vcinema.cn:8445/v2.3/rest/movie/queryMovieByRecommend/228893/974?channels=aph1&appVersion=4.1.0&platform=1").build()
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

    @Override
    public void OnItemClick(View view, int position) {
        ToastUtil.makeText(mData.get(position).getName());
    }
}
