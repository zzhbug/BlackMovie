package com.zzh.blackmovie.ui.selfview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.squareup.picasso.Picasso;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.model.ProductmovieList;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class NetworkImageHolderView implements Holder<ProductmovieList> {
    private static final String TAG = "NetworkImageHolderView";
    private ImageView imageView;
    private LayoutInflater inflater;
    private TextView mTextPagerShow;

    @Override
    public View createView(Context context) {

        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_pager_item, null);
        imageView = ((ImageView) view.findViewById(R.id.imgPagerShow));
        mTextPagerShow = ((TextView) view.findViewById(R.id.textPagerTitle));
        return view;
    }

    @Override
    public void UpdateUI(Context context, final int position, ProductmovieList data) {
        Picasso.with(context).load(data.getMovieImageUrl()).into(imageView);
        String content = data.getLfadvert().trim();
        mTextPagerShow.setText(content);
    }
}