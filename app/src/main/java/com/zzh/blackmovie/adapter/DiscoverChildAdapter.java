package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zzh.blackmovie.model.ProductmovieList;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class DiscoverChildAdapter extends RecyclerBaseAdapter<ProductmovieList> {

    public DiscoverChildAdapter(Context context, List<ProductmovieList> data, int itemId) {
        super(context, data, itemId);
    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        return fistViewHolder;
    }

    @Override
    protected void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition) {
//                mData.get(dataPosition).getName()
    }
}
