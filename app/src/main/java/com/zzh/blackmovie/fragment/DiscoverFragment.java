package com.zzh.blackmovie.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.adapter.MovieTagAdapter;
import com.zzh.blackmovie.base.BaseFragment;
import com.zzh.blackmovie.http.BaseCallback;
import com.zzh.blackmovie.http.Contants;
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.DiscoverMovieContent;
import com.zzh.blackmovie.model.DiscoverTagAll;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class DiscoverFragment extends BaseFragment {
    public static final String TAG = "DiscoverFragment";
    @BindView(R.id.imgTopbarBack)
    ImageView mImgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView mTextTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView mImgTopbarSearch;
    @BindView(R.id.pullRecyclerDiscover)
    PullToRefreshRecyclerView mPullRecyclerDiscover;
    private List<DiscoverMovieContent> mData;
    private MovieTagAdapter mMovieTagAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_discover, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initHttp(DOWN_DATA);
    }


    private void initView() {
        mImgTopbarBack.setVisibility(View.INVISIBLE);
        mTextTopbarTitle.setText("发现");
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        mPullRecyclerDiscover.setLayoutManager(layoutManager);
        //-------------------------空白页面和动画---------------------------------
        View inflate = View.inflate(getActivity(), R.layout.empty_view, null);
        mPullRecyclerDiscover.setEmptyView(inflate);
        ImageView imgLoading = (ImageView) inflate.findViewById(R.id.imgLoading);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgLoading.getDrawable();
        animationDrawable.start();
        //----------------------------------------------------------------
        mData = new ArrayList<>();
        mMovieTagAdapter = new MovieTagAdapter(getActivity(), mData, R.layout.discover_tag);
        mPullRecyclerDiscover.setAdapter(mMovieTagAdapter);
        //多布局
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = 1;
                if (mData.get(position).getPositoin() == 1) {
                    type = 3;
                }
                return type;
            }
        });

    }

    private void initHttp(final int type) {
        String url = Contants.DISCOVER_URL;
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new BaseCallback<DiscoverTagAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onResponse(DiscoverTagAll response, int id) {
                        Log.d(TAG, "onResponse: ");
                        List<DiscoverMovieContent> content = response.getContent();
                        switch (type) {
                            case DOWN_DATA:
                                mMovieTagAdapter.downDataRes(content);
                                break;
                            case UP_DATA:
                                break;
                        }

                    }
                });
        ;
    }


    @OnClick(R.id.imgTopbarSearch)
    public void onClick() {
        ToastUtil.makeText("搜索");
    }

}
