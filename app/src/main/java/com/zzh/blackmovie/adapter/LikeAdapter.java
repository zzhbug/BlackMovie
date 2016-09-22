package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.model.MovieLikeAll;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public class LikeAdapter extends RecyclerBaseAdapter<MovieLikeAll.LikeMovie> implements View.OnClickListener {


    public LikeAdapter(Context context, List<MovieLikeAll.LikeMovie> data, int itemId) {
        super(context, data, itemId);
    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        View coverView = fistViewHolder.getCoverView();
        coverView.setOnClickListener(this);
        return fistViewHolder;
    }

    @Override
    protected void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition) {
        ImageView imageView = (ImageView) holder.getView(R.id.img_recycler_like_item);
        TextView textView = (TextView) holder.getView(R.id.text_recycler_like_item);
    }

    @Override
    public void onClick(View v) {

    }
}
