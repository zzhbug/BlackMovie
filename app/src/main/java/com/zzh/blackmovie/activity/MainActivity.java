package com.zzh.blackmovie.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.fragment.DiscoverFragment;
import com.zzh.blackmovie.fragment.HomeFragment;
import com.zzh.blackmovie.fragment.MineFragment;
import com.zzh.blackmovie.fragment.RankingFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroupBottom;
    private Fragment mShowFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        this.radioGroupBottom = (RadioGroup) findViewById(R.id.radioGroupBottom);
        radioGroupBottom.setOnCheckedChangeListener(this);

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        mShowFragment = new HomeFragment();
        transaction.add(R.id.layoutLoadFragment, mShowFragment, HomeFragment.TAG);
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.btnHomeMenu:
                showFragment(HomeFragment.class, HomeFragment.TAG);
                break;
            case R.id.btnRankMenu:
                showFragment(RankingFragment.class, RankingFragment.TAG);
                break;
            case R.id.btnDiscoverMenu:
                showFragment(DiscoverFragment.class, DiscoverFragment.TAG);
                break;
            case R.id.btnMineMenu:
                showFragment(MineFragment.class, MineFragment.TAG);
                break;
        }

    }

    private void showFragment(Class<? extends Fragment> cls, String tag) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.hide(mShowFragment);
        mShowFragment = mFragmentManager.findFragmentByTag(tag);
        if (mShowFragment == null) {
            try {
                mShowFragment = cls.newInstance();
                transaction.add(R.id.layoutLoadFragment, mShowFragment, tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        transaction.show(mShowFragment);
        transaction.commit();

    }
}
