package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.model.ProductmovieList;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;
import com.zzh.blackmovie.utils.SysState;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class RecyclerItemAdapter extends RecyclerBaseAdapter<ProductmovieList> implements View.OnClickListener {

    private static final String TAG = "RecyclerItemAdapter";
    private final int screenWidth;

    public RecyclerItemAdapter(Context context, List<ProductmovieList> data, int itemId) {
        super(context, data, itemId);
        int[] andHeight = SysState.getSystemWidthAndHeight();
        screenWidth = andHeight[0];
    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        View coverView = fistViewHolder.getCoverView();
        //-------------------设置Item的高度和宽度------------------
        View cardView = coverView.findViewById(R.id.cardHomeView);
        int width = screenWidth / 3;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width, width / 3 * 4 + 80);
        cardView.setLayoutParams(params);

        //设置图片的高度和宽度
        int margin = cardView.getMeasuredWidth() + cardView.getMeasuredHeight();
        int imgWidth = (screenWidth - 3 * margin) / 3;
        Log.d(TAG, "onCreateBaseViewHolder: " + imgWidth);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(imgWidth, imgWidth / 3 * 4);
        View view2 = coverView.findViewById(R.id.imgMoviePic);
        view2.setLayoutParams(params1);
        coverView.setOnClickListener(this);

        return fistViewHolder;
    }

    @Override
    protected void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition) {
        ImageView imgMoviePic = (ImageView) holder.getView(R.id.imgMoviePic);
        TextView textMovieName = (TextView) holder.getView(R.id.textMovieName);
        textMovieName.setText(mData.get(dataPosition).getName());
        Picasso.with(mContext).load(mData.get(dataPosition).getMovieImageUrl())
                .noFade()
                .placeholder(R.mipmap.picdefault)
                .into(imgMoviePic);

    }


    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        Log.d(TAG, "onClick: "+position);
        //在这里跳转二级页面

    }
}
