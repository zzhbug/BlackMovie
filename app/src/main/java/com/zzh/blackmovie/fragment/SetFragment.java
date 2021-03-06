package com.zzh.blackmovie.fragment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.base.BaseFragment;
import com.zzh.blackmovie.common.AppContext;
import com.zzh.blackmovie.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class SetFragment extends BaseFragment {
    public static final String TAG = SetFragment.class.getSimpleName();
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView textTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.textComment)
    TextView textComment;
    @BindView(R.id.learnVersion)
    LinearLayout learnVersion;
    @BindView(R.id.textOurs)
    TextView textOurs;
    @BindView(R.id.textVersion)
    TextView textVersion;
    @BindView(R.id.linearDayNight)
    LinearLayout linearDayNight;
    private boolean isNight;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (AppContext.appConfig.getNightModeSwitch()) {
            getActivity().setTheme(R.style.NightTheme);
        }else {
            getActivity().setTheme(R.style.DayTheme);
        }
        layout = inflater.inflate(R.layout.fragment_set, container, false);
        ButterKnife.bind(this, layout);
        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        textTopbarTitle.setText("我的设置");
        imgTopbarSearch.setVisibility(View.INVISIBLE);
        linearDayNight.setClickable(true);

        String versionName = getVersion(getActivity());
        textVersion.setText(versionName);
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    private String getVersion(Context context) {
        String versionName = "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo packageInfo = manager.getPackageInfo("com.zzh.blackmovie", 0);
            versionName = packageInfo.versionName;
            Log.d(TAG, "getVersion: " + versionName);
            if (TextUtils.isEmpty(String.valueOf(versionName))) {
                return "";
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }


    @OnClick({R.id.imgTopbarBack, R.id.learnVersion, R.id.textOurs, R.id.linearDayNight})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTopbarBack:
                getActivity().finish();
                break;
            case R.id.learnVersion:
                ToastUtil.makeText("版本信息");
                break;
            case R.id.textOurs:
                ToastUtil.makeText("关于我们");
//                getActivity().setTheme(R.style.DayTheme);
//                AppContext.appConfig.setNightModeSwitch(false);

         //       getResources().newTheme().applyStyle(R.style.NightTheme,false);
                break;
            case R.id.linearDayNight:
            //    ToastUtil.makeText("日夜模式切换");
                getActivity().setTheme(R.style.NightTheme);
   //             AppContext.appConfig.setNightModeSwitch(true);

                isNight = !AppContext.appConfig.getNightModeSwitch();

    //           getResources().newTheme().applyStyle(R.style.DayTheme,false);
                AppContext.appConfig.setNightModeSwitch(isNight);
                getActivity().recreate();

                break;
        }
    }


//    public void changeThemeModel(boolean isNight) {
//        if (isNight) {
//            mView.setBackgroundColor(getResources().getColor(R.color.bg_night));
//        } else {
//            mView.setBackgroundColor(getResources().getColor(R.color.bg_day));
//        }
//    }
}
