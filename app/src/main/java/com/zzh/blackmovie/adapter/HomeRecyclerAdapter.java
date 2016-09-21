package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.model.MovieSort;
import com.zzh.blackmovie.model.ProductmovieList;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HomeRecyclerAdapter extends RecyclerBaseAdapter<MovieSort> {

    private static final String TAG = "HomeRecyclerAdapter";
    private final LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerViewItem;
    private int screenWidth;

    public HomeRecyclerAdapter(Context context, List<MovieSort> data, int itemId) {
        super(context, data, itemId);
        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        return fistViewHolder;
    }

    @Override
    protected void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition) {
        TextView textMovieTitle = (TextView) holder.getView(R.id.textMovieTitleItem);
        //        TextView view = (TextView) holder.getView(R.id.textMovieMoreItem);
        textMovieTitle.setText(mData.get(itemPosition).getCategoryzdName());

        List<ProductmovieList> productmovieList = mData.get(itemPosition).getProductmovieList();
        mRecyclerViewItem = ((RecyclerView) holder.getView(R.id.recyclerItem));
        mRecyclerViewItem.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        RecyclerItemAdapter adapter = new RecyclerItemAdapter(mContext, productmovieList, R.layout.moive_list_item);
        mRecyclerViewItem.setAdapter(adapter);


    }

}
