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
import com.zzh.blackmovie.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class FavFragment extends BaseFragment {
    public static final String TAG = FavFragment.class.getSimpleName();
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView textTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.textNothing)
    TextView textNothing;
    @BindView(R.id.recyclerMovie)
    RecyclerView recyclerMovie;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_fav,container,false);

        ButterKnife.bind(this, layout);
        return layout;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        textTopbarTitle.setText("我的收藏");
        imgTopbarSearch.setImageResource(R.drawable.delete_bg);
        //设置图片宽高
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(20,20);
//        imgTopbarSearch.setLayoutParams(layoutParams);
//        imgTopbarSearch.setMaxHeight(5);
//        imgTopbarSearch.setMaxWidth(5);
        imgTopbarSearch.setPadding(20,20,20,20);
        textNothing.setText("暂无收藏记录");
    }

    @OnClick({R.id.imgTopbarBack, R.id.imgTopbarSearch})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTopbarBack:
                getActivity().finish();
                break;
            case R.id.imgTopbarSearch:
                ToastUtil.makeText("删除");
                break;
        }
    }
 //   前程无忧  拉钩 猎聘
}
