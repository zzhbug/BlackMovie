package com.zzh.blackmovie.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.adapter.MoreMovieAdapter;
import com.zzh.blackmovie.base.BaseActivity;
import com.zzh.blackmovie.http.BaseCallback;
import com.zzh.blackmovie.http.Contants;
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.MovieContent;
import com.zzh.blackmovie.model.MovieListAll;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class MoreActivity extends BaseActivity {
    private static final String TAG = "MoreActivity";
    private static final int UP_DATA = 2;
    private static final int DOWN_DATA = 1;
    @BindView(R.id.textTopbarTitle)
    TextView mTextTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView mImgTopbarSearch;
    @BindView(R.id.pullMoreRecyclerView)
    PullToRefreshRecyclerView mPullMoreRecyclerView;
    @BindView(R.id.imgTopbarBack)
    ImageView mImgTopbarBack;
    private MoreMovieAdapter mMoreMovieAdapter;
    private List<MovieContent> mData;

    private String mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);
        initView();
        initHttp(DOWN_DATA);
    }


    private void initView() {
        mImgTopbarSearch.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        String title = intent.getStringExtra(TITLE);
        mId = intent.getStringExtra(CATEGORY_ID);
        mTextTopbarTitle.setText(title);
        Log.d(TAG, "initView: " + mId);
        mPullMoreRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        //添加空白页添加动画
        View inflate = View.inflate(this, R.layout.empty_view, null);
        mPullMoreRecyclerView.setEmptyView(inflate);
        ImageView imgLoading = (ImageView) inflate.findViewById(R.id.imgLoading);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgLoading.getDrawable();
        animationDrawable.start();
        //-----------------------------------------------
        mData = new ArrayList<>();
        mMoreMovieAdapter = new MoreMovieAdapter(this, mData, R.layout.simple_movie);

        mPullMoreRecyclerView.setAdapter(mMoreMovieAdapter);

    }

    private void initHttp(final int type) {
        String url = Contants.MORE_MOVIE_HEAD_URL + mId + Contants.MORE_MOVIE_FOOT_URL;
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new BaseCallback<MovieListAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onResponse(MovieListAll response, int id) {
                        Log.d(TAG, "onResponse: " + response);
                        List<MovieContent> content = response.getContent();
                        switch (type) {
                            case DOWN_DATA: //刷新
                                mMoreMovieAdapter.downDataRes(content);
                                break;
                            case UP_DATA:  //加载
                                mMoreMovieAdapter.updataRes(content);
                                break;
                        }

                    }
                });


    }

    @OnClick(R.id.imgTopbarBack)
    public void onClick() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
