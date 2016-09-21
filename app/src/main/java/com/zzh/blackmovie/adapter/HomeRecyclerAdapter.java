package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzh.blackmovie.model.MovieSort;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    private List<MovieSort> mData;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;
    private Context mContext;


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


    /**
     * @param data 上拉加载
     */
    public void updataRes(List<MovieSort> data) {
        if (data != null) {
            this.mData.addAll(data);
            this.notifyDataSetChanged();
        }
    }

    /**
     * @param data 下拉刷新
     */
    public void downDataRes(List<MovieSort> data) {
        if (data != null) {
            this.mData.clear();
            this.mData.addAll(data);
            this.notifyDataSetChanged();
        }

    }


}
