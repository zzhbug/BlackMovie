package com.zzh.blackmovie.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.fragment.DownLoadFragment;
import com.zzh.blackmovie.fragment.FavFragment;
import com.zzh.blackmovie.fragment.FreedBackFragment;
import com.zzh.blackmovie.fragment.MovieHistoryFragment;
import com.zzh.blackmovie.fragment.SetFragment;

public class MineOtherActivity extends AppCompatActivity {

    private static final int TAG_HISTORY = 2;
    private static final int TAG_DOWNLOAD = 3;
    private static final int TAG_FAV = 4;
    private static final int TAG_FEEDBACK = 5;
    private static final int TAG_SET = 6;
    public static final String FRAGMENT_TAG ="FRAGMENT_TAG";

    private FragmentManager mFragmentManager;
    private Fragment mShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_other);

        initView();
    }

    private void initView() {

        mFragmentManager = getSupportFragmentManager();

        int tag = getIntent().getIntExtra(FRAGMENT_TAG, 0);
        switch (tag) {
            case TAG_HISTORY:
                showFragment(MovieHistoryFragment.class,MovieHistoryFragment.TAG);
                break;
            case TAG_DOWNLOAD:
                showFragment(DownLoadFragment.class,DownLoadFragment.TAG);
                break;
            case TAG_FAV:
                showFragment(FavFragment.class,FavFragment.TAG);
                break;
            case TAG_FEEDBACK:
                showFragment(FreedBackFragment.class,FreedBackFragment.TAG);
                break;
            case TAG_SET:
                showFragment(SetFragment.class,SetFragment.TAG);
                break;
        }
    }


    private void showFragment(Class<? extends Fragment> cls, String tag) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
     //   transaction.hide(mShowFragment);
        mShowFragment = mFragmentManager.findFragmentByTag(tag);
        if (mShowFragment == null) {
            try {
                mShowFragment = cls.newInstance();
                transaction.add(R.id.frameContainer, mShowFragment, tag);
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
