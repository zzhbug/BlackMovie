package com.zzh.blackmovie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.MineLoginActivity;
import com.zzh.blackmovie.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class MineFragment extends BaseFragment {
    public static final String TAG = "MineFragment";
    @BindView(R.id.imgUserPhoto)
    ImageView imgUserPhoto;
    @BindView(R.id.textLogin)
    TextView textLogin;
    @BindView(R.id.textSmallTitle)
    TextView textSmallTitle;
    @BindView(R.id.linearHistory)
    LinearLayout linearHistory;
    @BindView(R.id.learnDownload)
    LinearLayout learnDownload;
    @BindView(R.id.learnFav)
    LinearLayout learnFav;
    @BindView(R.id.learnFeedback)
    LinearLayout learnFeedback;
    @BindView(R.id.learnSet)
    LinearLayout learnSet;
    @BindView(R.id.learnLogout)
    LinearLayout learnLogout;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;

    private boolean isLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, layout);
        imgTopbarSearch.setVisibility(View.GONE);
        imgTopbarBack.setVisibility(View.GONE);
        if (isLogin == true) {
            imgUserPhoto.setClickable(false);
        }
    }

    @OnClick({R.id.imgUserPhoto, R.id.textLogin, R.id.textSmallTitle, R.id.linearHistory, R.id.learnDownload, R.id.learnFav, R.id.learnFeedback, R.id.learnSet, R.id.learnLogout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgUserPhoto:
                login();

                Toast.makeText(getActivity(), "头像", Toast.LENGTH_SHORT).show();
                break;
            case R.id.textLogin:
                Toast.makeText(getActivity(), "用户名", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linearHistory:
                Toast.makeText(getActivity(), "观影历史", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnDownload:
                Toast.makeText(getActivity(), "离线缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnFav:
                Toast.makeText(getActivity(), "我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnFeedback:
                Toast.makeText(getActivity(), "我要反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnSet:
                Toast.makeText(getActivity(), "我的设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnLogout:
                Toast.makeText(getActivity(), "退出", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void login() {
        Intent intent = new Intent(getActivity(), MineLoginActivity.class);

        startActivity(intent);
        isLogin = true;
    }
}
