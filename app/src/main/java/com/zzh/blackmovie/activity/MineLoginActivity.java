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

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.zzh.blackmovie.R;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MineLoginActivity extends AppCompatActivity {
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
            mShareAPI.getPlatformInfo(MineLoginActivity.this, platform, umAuthListener);
            Log.d(TAG, "onComplete: " + map.toString());


            String screen_name = map.get("screen_name");
            String openid = map.get("openid");
            int vip = Integer.parseInt(map.get("vip"));

            //获取登录用户名 id
            String screen_nameShare = mSharedPreferences.getString(screen_name,"none");
            String openidShare = mSharedPreferences.getString(openid, "none");
            if (!mSharedPreferences.contains(screen_name) || !mSharedPreferences.contains(openid)) {
                mEdit.putString("screen_name","none");
                mEdit.putString("openid","none");
                mEdit.commit();
            }else {
                if (!screen_nameShare.equals(screen_name) || !openidShare.equals(openid)) {
                    mEdit.putString(screen_name,"none");
                    mEdit.putString(openid,"none");
                    mEdit.commit();
                }
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

}
