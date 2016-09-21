package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public class RecyclerItemAdapter extends RecyclerBaseAdapter<ProductmovieList> {

    private static final String TAG ="RecyclerItemAdapter" ;
    private final int screenWidth;

    public RecyclerItemAdapter(Context context, List<ProductmovieList> data, int itemId) {
        super(context, data, itemId);
        int[] andHeight = SysState.getSystemWidthAndHeight();
        screenWidth = andHeight[0];
    }

    @Override
    protected ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType) {
        View coverView = fistViewHolder.getCoverView();
        View cardView = coverView.findViewById(R.id.cardHomeView);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(screenWidth / 3, 200);
        cardView.setLayoutParams(params);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) cardView.getLayoutParams();
//        int margin = layoutParams.leftMargin + layoutParams.rightMargin;
//        int imgWidth = (screenWidth - 3 *margin) / 3;
//        Log.d(TAG, "onCreateBaseViewHolder: " + imgWidth);
//        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(i, i / 3 * 2);
//        View view2 = coverView.findViewById(R.id.imgMoviePic);
//        view2.setLayoutParams(params1);

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


}
