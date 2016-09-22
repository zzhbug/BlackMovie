package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.model.MovieContent;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
import com.zzh.blackmovie.utils.SysState;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class MoreMovieAdapter extends RecyclerBaseAdapter<MovieContent> implements View.OnClickListener {
    private static final String TAG = "MoreMovieAdapter";
    private final int mImgeWidth;
    private final int mImgeHight;

    public MoreMovieAdapter(Context context, List<MovieContent> data, int itemId) {
        super(context, data, itemId);
        int[] systemWidthAndHeight = SysState.getSystemWidthAndHeight();
        mImgeWidth = systemWidthAndHeight[0] / 3;
        mImgeHight = mImgeWidth * 4 / 3;
    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        View coverView = fistViewHolder.getCoverView();
        coverView.setOnClickListener(this);
        return fistViewHolder;
    }

    @Override
    protected void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition) {
        ImageView imgSimpleMovie = (ImageView) holder.getView(R.id.imgSimpleMovie);
        TextView text = (TextView) holder.getView(R.id.textSimpleMovieTitle);
        text.setText(mData.get(dataPosition).getName());
        Picasso.with(mContext).load(mData.get(dataPosition).getMovieImageUrl())
                .placeholder(R.mipmap.picdefault)
                .into(imgSimpleMovie);
        Log.d(TAG, "onBindBaseViewHolder: " + text);
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        ToastUtil.makeText(String.valueOf(position));
        //做页面跳转更具
    }
}
