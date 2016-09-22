package com.zzh.blackmovie.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.adapter.LikeAdapter;

import com.zzh.blackmovie.model.MovieLikeAll;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayActivity extends AppCompatActivity implements LikeAdapter.OnItemClickListener{
    private static final String TAG = "MainActivity";
    @BindView(R.id.recycler_like)
    RecyclerView recyclerLike;
    private List<MovieLikeAll.LikeMovie> mData;
    private LikeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerLike.setLayoutManager(layoutManager);
        mData=new ArrayList<>();
        mAdapter = new LikeAdapter(this,mData, R.layout.recycler_like_item);
        mAdapter.setOnItemClickListener(this);
        recyclerLike.setAdapter(mAdapter);
    }

    @Override
    public void OnItemClick(View view, int position) {

    }
}
