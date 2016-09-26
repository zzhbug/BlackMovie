package com.zzh.blackmovie.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.PlayActivity;
import com.zzh.blackmovie.adapter.RankAdapter;
import com.zzh.blackmovie.base.BaseFragment;
import com.zzh.blackmovie.http.BaseCallback;
import com.zzh.blackmovie.http.Contants;
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.MovieRankAll;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class RankingFragment extends BaseFragment implements RankAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    public static final String TAG = "RankingFragment";
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView textTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.recycler_rank)
    PullToRefreshRecyclerView recyclerRank;


    private List<MovieRankAll.MovieRankContent.MovieRank> mData;

    private RankAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_ranking, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imgTopbarBack.setVisibility(View.INVISIBLE);
        textTopbarTitle.setText("排行");
        initView();
        setView(DOWN_DATA);
    }


    private void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerRank.setLayoutManager(layoutManager);
//        设置刷新
        recyclerRank.setSwipeEnable(true);
        recyclerRank.setRefreshing(true);
        recyclerRank.setOnRefreshListener(this);
//        空白页和动画
        View inflate = View.inflate(getActivity(), R.layout.empty_view, null);
        recyclerRank.setEmptyView(inflate);
        ImageView imgLoading = (ImageView) inflate.findViewById(R.id.imgLoading);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgLoading.getDrawable();
        animationDrawable.start();
//-----------------------------------------------------------------------------------------------
        mData = new ArrayList<>();
        mAdapter = new RankAdapter(getActivity(), mData, R.layout.recycler_rank_item);
        mAdapter.setOnItemClickListener(this);
        recyclerRank.setAdapter(mAdapter);

    }

    private void setView(final int type) {
        OkHttpUtils.get()
                .url(Contants.RANK_URL)
                .build()
                .execute(new BaseCallback<MovieRankAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {}
                    @Override
                    public void onResponse(MovieRankAll response, int id) {
                        List<MovieRankAll.MovieRankContent.MovieRank> list = response.getContent().get(0).getProductmovieList();
                        switch (type) {
                            case DOWN_DATA:
                                mAdapter.downDataRes(list);
                                break;
                            case UP_DATA:
                                mAdapter.updataRes(list);
                                break;

                        }
                        recyclerRank.setOnRefreshComplete();

                    }
                });
    }

    @Override
    public void OnItemClick(View view, int position) {

        ToastUtil.makeText(mData.get(position).getId() + "");
        Intent intent = new Intent(getActivity(), PlayActivity.class);
        int id = mData.get(position).getId();
        intent.putExtra("movieid", id);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        setView(DOWN_DATA);
    }


}
