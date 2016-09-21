package com.zzh.blackmovie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.base.BaseFragment;
import com.zzh.blackmovie.http.BaseCallback;
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.HomeMovieAll;
import com.zzh.blackmovie.adapter.HomeRecyclerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import lib.homhomlib.design.SlidingLayout;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class HomeFragment extends BaseFragment {
    public static final String TAG = "HomeFragment";
    @BindView(R.id.recyclerHome)
    RecyclerView mRcyclerHome;
    @BindView(R.id.slidingLayout)
    SlidingLayout mSlidingLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initHttp();
    }

    private void initView() {
        mRcyclerHome.setAdapter(new HomeRecyclerAdapter());

    }
    private void initHttp() {
        OkHttpUtils.get()
                .url("https://apis.vcinema.cn:8445/v2.3/rest/home/getHomeResource/1/0/10?channels=aph1&appVersion=4.1.0&platform=1")
                //                .url("http://api.duotin.com/podcast/latest?device_key=353375050122414&platform=android&source=fm&device_token=&user_key=&package=com.duotin.fm&longitude=&latitude=&channel=hiapk&version=2.7.20")
                .build()
                .execute(new BaseCallback<HomeMovieAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onResponse(HomeMovieAll response, int id) {
                        Log.d(TAG, "onResponse: " + response);
                    }
                });
    }

}
