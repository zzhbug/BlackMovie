package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.PlayActivity;
import com.zzh.blackmovie.activity.MoreActivity;
import com.zzh.blackmovie.model.MovieSort;
import com.zzh.blackmovie.model.ProductmovieList;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HomeRecyclerAdapter extends RecyclerBaseAdapter<MovieSort> implements View.OnClickListener {

    private static final String TAG = "HomeRecyclerAdapter";

    private RecyclerView mRecyclerViewItem;


    public HomeRecyclerAdapter(Context context, List<MovieSort> data, int itemId) {
        super(context, data, itemId);

    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        View view = fistViewHolder.getCoverView().findViewById(R.id.textMovieMoreItem);
        view.setOnClickListener(this);
        return fistViewHolder;
    }

    @Override
    protected void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition) {
        TextView textMovieTitle = (TextView) holder.getView(R.id.textMovieTitleItem);
        textMovieTitle.setText(mData.get(itemPosition).getCategoryzdName());
        List<ProductmovieList> productmovieList = mData.get(itemPosition).getProductmovieList();
        mRecyclerViewItem = ((RecyclerView) holder.getView(R.id.recyclerItem));
        mRecyclerViewItem.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        RecyclerItemAdapter adapter = new RecyclerItemAdapter(mContext, productmovieList, R.layout.moive_list_item);
        mRecyclerViewItem.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        ViewGroup parent = (ViewGroup) (v.getParent().getParent());
        int position = mRecyclerViewItem.getChildAdapterPosition(parent);
        Log.d(TAG, "onClick: " + position);
        startActivity(position);
        //跳转更多页面
    }

    private void startActivity(int position) {
        String categoryName = mData.get(position).getCategoryName();
        int categoryId = mData.get(position).getCategoryId();
        Intent intent = new Intent(mContext, MoreActivity.class);
        intent.putExtra(MoreActivity.TITLE, categoryName);
        intent.putExtra(MoreActivity.CATEGORY_ID, String.valueOf(categoryId));
        mContext.startActivity(intent);
    }


}
