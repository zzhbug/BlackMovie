package com.zzh.blackmovie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.base.BaseFragment;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class RankingFragment extends BaseFragment {
    public static final String TAG = "RankingFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_ranking, container, false);
        return layout;
    }
}
