package com.zzh.blackmovie.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class BaseActivity extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    public static final String CATEGORY_ID = "CATEGORY_ID";

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
