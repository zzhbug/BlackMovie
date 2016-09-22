package com.zzh.blackmovie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.PlayActivity;
import com.zzh.blackmovie.adapter.RankAdapter;
import com.zzh.blackmovie.base.BaseFragment;
import com.zzh.blackmovie.http.BaseCallback;
import com.zzh.blackmovie.http.Contants;
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.MovieRankAll;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class RankingFragment extends BaseFragment implements RankAdapter.OnItemClickListener{
    public static final String TAG = "RankingFragment";
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView textTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.recycler_rank)
    RecyclerView recyclerRank;

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
        imgTopbarBack.setVisibility(View.GONE);
        textTopbarTitle.setText("排行");
        initView();
        setView();
    }


    private void initView() {
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),3);
        recyclerRank.setLayoutManager(layoutManager);
        mData=new ArrayList<>();
        mAdapter = new RankAdapter(getActivity(),mData, R.layout.recycler_rank_item);
        mAdapter.setOnItemClickListener(this);
        recyclerRank.setAdapter(mAdapter);

    }

    private void setView() {
        OkHttpUtils.get()
                .url(Contants.RANK_URL)
                .build()
                .execute(new BaseCallback<MovieRankAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(MovieRankAll response, int id) {
                        List<MovieRankAll.MovieRankContent.MovieRank> list = response.getContent().get(0).getProductmovieList();
                        mAdapter.updataRes(list);
                    }
                });
    }

    @Override
    public void OnItemClick(View view, int position) {

        ToastUtil.makeText(mData.get(position).getId()+"");
        Intent intent = new Intent(getActivity(), PlayActivity.class);
        int id=mData.get(position).getId();
        intent.putExtra("movieid",id);
        startActivity(intent);
    }
}
