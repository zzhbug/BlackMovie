package com.zzh.blackmovie.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.model.UserInfo;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineLoginActivity extends AppCompatActivity implements AMapLocationListener {
    private static final String TAG = "MineLoginActivity";
    private SHARE_MEDIA platform;
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView textTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.editLoginPhone)
    TextInputEditText editLoginPhone;
    @BindView(R.id.textLoginSend)
    TextView textLoginSend;
    @BindView(R.id.editLoginCode)
    TextInputEditText editLoginCode;
    @BindView(R.id.btnQuickLogin)
    Button btnQuickLogin;
    @BindView(R.id.btnTDPLogin)
    Button btnTDPLogin;
    private UMShareAPI mShareAPI;

    private SharedPreferences.Editor mEdit;
    private SharedPreferences mSharedPreferences;

    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    private AMapLocationClient mlocationClient;
    private String mCity;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_login);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        imgTopbarSearch.setVisibility(View.INVISIBLE);
        textTopbarTitle.setText("登录");
        //数据存储
        mSharedPreferences = getSharedPreferences("userInfo", Activity.MODE_PRIVATE);
        mEdit = mSharedPreferences.edit();
    }

    @OnClick({R.id.btnQuickLogin, R.id.btnTDPLogin, R.id.imgTopbarBack})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnQuickLogin:
                //极速登录
                quickLogin();
                break;
            case R.id.btnTDPLogin:
                //第三方登录
                tdpLogin();
                break;
            case R.id.imgTopbarBack:
                //返回键
                this.finish();
                break;
        }
    }

    private void quickLogin() {
        if ("".equals(editLoginPhone.getText().toString())) {
            Toast.makeText(MineLoginActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
        } else if ("".equals(editLoginCode.toString())) {
            Toast.makeText(MineLoginActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
        }
    }


    private void tdpLogin() {

        mShareAPI = UMShareAPI.get(this);

        platform = SHARE_MEDIA.QQ;
        //授权
        mShareAPI.doOauthVerify(this, platform, umAuthListener);

        //获取客户端安装信息
        mShareAPI.isInstall(this, SHARE_MEDIA.WEIXIN);
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Log.d(TAG, "onComplete: " + map.toString());

            String screen_name = map.get(UserInfo.NAME);
            String openid = map.get(UserInfo.OPENID);
            String vip = map.get(UserInfo.VIP);
            String image_url = map.get(UserInfo.IMAGE_URL);
            Log.d(TAG, "onComplete: " + screen_name + "     " + openid + "      " + vip + "     " + image_url);

            //获取登录用户名 id
                mEdit.putString(UserInfo.NAME,screen_name);
                mEdit.putString(UserInfo.OPENID,openid);
                mEdit.putString(UserInfo.VIP,vip);
                mEdit.putString(UserInfo.IMAGE_URL,image_url);
                mEdit.putString(UserInfo.CITY,mCity);
                mEdit.commit();
            Log.d(TAG, "onComplete: OK" );

            //定位
            getPosition();

            //当用户名不为空时结束当前页面
            if (screen_name != null  && mCity != null && image_url != null) {
                finish();
            }else {    //获取用户信息
                mShareAPI.getPlatformInfo(MineLoginActivity.this, platform, umAuthListener);
            }
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Log.d(TAG, "onError: ");
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Log.d(TAG, "onCancel: ");
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }

    private void getPosition() {

        //实例化定位的服务
        mlocationClient = new AMapLocationClient(getApplicationContext());
        //设置一个定位的监听
        mlocationClient.setLocationListener(this);
        //设置一个定位的配置
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        //设置LocationClientOption
        mlocationClient.setLocationOption(aMapLocationClientOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == AMapLocation.LOCATION_SUCCESS) {
//                //定位成功回调信息，设置相关消息
                mCity = amapLocation.getCity();  //获得城市信息
                Log.d(TAG, "onLocationChanged: " + mCity );

            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Log.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
