package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.MoreActivity;
import com.zzh.blackmovie.activity.PlayActivity;
import com.zzh.blackmovie.model.DiscoverMovieContent;
import com.zzh.blackmovie.model.ProductmovieList;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class MovieTagAdapter extends RecyclerBaseAdapter<DiscoverMovieContent> implements View.OnClickListener {
    private static final String TAG = "MovieTagAdapter";
    private static final int TYPE_TWO = 1;
    private static final int TYPE_ONE = 0;

    public MovieTagAdapter(Context context, List<DiscoverMovieContent> data, int itemId) {
        super(context, data, itemId);
    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        View coverView = fistViewHolder.getCoverView();
        coverView.setOnClickListener(this);
        switch (viewType) {
            case TYPE_ONE:
                Log.d(TAG, "onCreateBaseViewHolder: one");
                return fistViewHolder;
            case TYPE_TWO:
                View inflate = mInflater.inflate(R.layout.discover_type2_item, parent, false);

                Log.d(TAG, "onCreateBaseViewHolder: two");
                return new ViewHolder(inflate);
        }
        return fistViewHolder;
    }

    @Override
    protected void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition) {
        switch (mData.get(dataPosition).getPositoin()) {
            case TYPE_ONE:
                TextView textDiscoverTag = (TextView) holder.getView(R.id.textDiscoverTag);
                textDiscoverTag.setText(mData.get(dataPosition).getCategoryzdName());
                break;
            case TYPE_TWO:
                TextView textView = (TextView) holder.getView(R.id.textDiscoverItem2);
                textView.setText(mData.get(dataPosition).getCategoryzdName());

                //-----------------------------------------------
                List<ProductmovieList> productmovieList = mData.get(dataPosition).getProductmovieList();

                RecyclerView view = (RecyclerView) holder.getView(R.id.recyclerDiscoverChild);
                GridLayoutManager layout = new GridLayoutManager(mContext, 3);
                view.setLayoutManager(layout);
                DiscoverChildAdapter adapter = new DiscoverChildAdapter(mContext, productmovieList, R.layout.simple_movie);
                view.setAdapter(adapter);
                Log.d(TAG, "onBindBaseViewHolder: " + productmovieList.size());
                break;
        }
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        ToastUtil.makeText("" + position);
        startActivity(position);
    }


    private void startActivity(int position) {
        String categoryName = mData.get(position).getCategoryName();
        int categoryId = mData.get(position).getCategoryId();
        Intent intent = new Intent(mContext, MoreActivity.class);
        intent.putExtra(MoreActivity.TITLE, categoryName);
        intent.putExtra(MoreActivity.CATEGORY_ID, String.valueOf(categoryId));
        mContext.startActivity(intent);

    }


    @Override
    public int getItemBaseViewType(int position) {
        if (mData.get(position).getPositoin() == 1) {
            return TYPE_TWO;
        } else {
            return TYPE_ONE;
        }
    }


}
