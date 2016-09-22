package com.zzh.blackmovie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DownLoadFragment extends BaseFragment {
    public static final String TAG = DownLoadFragment.class.getSimpleName();
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView textTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.textComment)
    TextView textComment;
    @BindView(R.id.textNothing)
    TextView textNothing;
    @BindView(R.id.recyclerMovie)
    RecyclerView recyclerMovie;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_download,container,false);

        ButterKnife.bind(this, layout);

        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        textTopbarTitle.setText("我的缓存");
        imgTopbarSearch.setVisibility(View.GONE);
        textComment.setVisibility(View.VISIBLE);
        textComment.setTextSize(18f);
        textComment.setClickable(true);
        textNothing.setText("暂无缓存记录");

    }

    @OnClick({R.id.imgTopbarBack, R.id.textComment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTopbarBack:
                getActivity().finish();
                break;
            case R.id.textComment:
                break;
        }
    }
}
