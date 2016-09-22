package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.MoreActivity;
import com.zzh.blackmovie.activity.PlayActivity;
import com.zzh.blackmovie.model.ProductmovieList;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DiscoverChildAdapter extends RecyclerBaseAdapter<ProductmovieList> implements View.OnClickListener {

    public DiscoverChildAdapter(Context context, List<ProductmovieList> data, int itemId) {
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
        TextView textSimpleMovieTitle = (TextView) holder.getView(R.id.textSimpleMovieTitle);
        textSimpleMovieTitle.setText(mData.get(dataPosition).getName());
        ImageView imgSimpleMovie = (ImageView) holder.getView(R.id.imgSimpleMovie);

        String trim = mData.get(dataPosition).getMovieImageUrl().trim();
        if (trim != null && !"".equals(trim)) {
            Picasso.with(mContext)
                    .load(trim)
                    .placeholder(R.mipmap.picdefault)
                    .into(imgSimpleMovie);
        }
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        ToastUtil.makeText(mData.get(position).getName());
        //页面跳转
        startActivity(position);
    }


    private void startActivity(int position) {
        Intent intent = new Intent(mContext, PlayActivity.class);
        intent.putExtra(PlayActivity.MOVIE_ID,mData.get(position).getId());
        mContext.startActivity(intent);
    }

}
