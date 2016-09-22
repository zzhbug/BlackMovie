package com.zzh.blackmovie.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.MineLoginActivity;
import com.zzh.blackmovie.base.BaseFragment;
import com.zzh.blackmovie.model.UserInfo;
import com.zzh.blackmovie.ui.selfview.CircleTransformation;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class MineFragment extends BaseFragment {
    public static final String TAG = "MineFragment";
    private static final int TAG_LOGIN = 1;
    private static final int TAG_HISTORY = 2;
    private static final int TAG_DOWNLOAD = 3;
    private static final int TAG_FAV = 4;
    private static final int TAG_FEEDBACK = 5;
    private static final int TAG_SET = 6;
    private static final int TAG_LOGOUT = 7;
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
    //设标记  根据不同的标记 加载不同  布局
    private  int tag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, layout);
        Log.d(TAG, "onCreateView: 111111");


        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        ButterKnife.bind(this, layout);
        imgTopbarSearch.setVisibility(View.GONE);
        imgTopbarBack.setVisibility(View.GONE);

    }

    @OnClick({R.id.imgUserPhoto, R.id.textLogin, R.id.textSmallTitle, R.id.linearHistory, R.id.learnDownload, R.id.learnFav, R.id.learnFeedback, R.id.learnSet, R.id.learnLogout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgUserPhoto:
                tag = TAG_LOGIN;
                login();

                break;
            case R.id.textLogin:
                tag = TAG_LOGIN;
                login();

                break;
            case R.id.linearHistory:
                tag = TAG_HISTORY;
                Toast.makeText(getActivity(), "观影历史", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnDownload:

                tag = TAG_DOWNLOAD;
                Toast.makeText(getActivity(), "离线缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnFav:
                tag = TAG_FAV;
                Toast.makeText(getActivity(), "我的收藏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnFeedback:
                tag = TAG_FEEDBACK;
                Toast.makeText(getActivity(), "我要反馈", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnSet:
                tag = TAG_SET;
                Toast.makeText(getActivity(), "我的设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.learnLogout:
                tag = TAG_LOGOUT;
                Toast.makeText(getActivity(), "退出", Toast.LENGTH_SHORT).show();
                logout();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    /**
     * 退出
     */
    private void logout() {
        //清空数据
        SharedPreferences userInfo = getActivity().getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor edit = userInfo.edit();
        edit.clear();
        edit.commit();
        cleanInfo();
    }

    /**
     * 设为默认信息
     */
    private void cleanInfo() {
        imgUserPhoto.setImageResource(R.mipmap.userphoto_default);
        textLogin.setText("登录/注册");
        textSmallTitle.setText("你的地盘你做主，做主怎能不登录?");
        imgUserPhoto.setClickable(true);
        textLogin.setClickable(true);
        learnLogout.setVisibility(View.INVISIBLE);
    }

    /**
     * 登录
     */
    private void login() {
        Intent intent = new Intent(getActivity(), MineLoginActivity.class);
        startActivity(intent);

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
        EventBus.getDefault().register(this);
        //共享参数取值
        SharedPreferences userInfo = getActivity().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Log.d(TAG, "onCreateView: " + userInfo.getString(UserInfo.OPENID,null));
        if (userInfo.contains(UserInfo.OPENID)) {
            String screen_name = userInfo.getString(UserInfo.NAME,null);
            String image_url = userInfo.getString(UserInfo.IMAGE_URL, null);
            String city = userInfo.getString(UserInfo.CITY, null);
            changeInfo(image_url,screen_name,city);
            Log.d(TAG, "onStart: ");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        EventBus.getDefault().unregister(this);
    }

    /**
     * 当用户登录后修改  头像  和  登录文字
     * 并把  头像 和 登录文字  设为不可点击
     * 把  退出账号  显示
     * @param imgUrl
     * @param name
     */
    private void changeInfo(String imgUrl,String name,String city) {
        Picasso.with(getActivity()).load(imgUrl)
                .transform(new CircleTransformation())
                .into(imgUserPhoto);
        imgUserPhoto.setClickable(false);

        textLogin.setText(name);
        textLogin.setClickable(false);
        textSmallTitle.setText("你好," + city + "网友");
        learnLogout.setVisibility(View.VISIBLE);
    }

}
