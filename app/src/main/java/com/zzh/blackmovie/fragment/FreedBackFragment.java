package com.zzh.blackmovie.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public class FreedBackFragment extends BaseFragment {
    public static final String TAG = FreedBackFragment.class.getSimpleName();
    @BindView(R.id.imgTopbarBack)
    ImageView imgTopbarBack;
    @BindView(R.id.textTopbarTitle)
    TextView textTopbarTitle;
    @BindView(R.id.imgTopbarSearch)
    ImageView imgTopbarSearch;
    @BindView(R.id.textComment)
    TextView textComment;
    @BindView(R.id.edit)
    EditText edit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_freedback, container, false);

        ButterKnife.bind(this, layout);
        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        textTopbarTitle.setText("我要反馈");
        textComment.setText("提交");
        textComment.setClickable(true);
        textComment.setVisibility(View.VISIBLE);
        imgTopbarSearch.setVisibility(View.GONE);
    }

    @OnClick({R.id.imgTopbarBack, R.id.textComment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTopbarBack:
                getActivity().finish();
                break;
            case R.id.textComment:
                ToastUtil.makeText("提交");
                break;
        }
    }
}
