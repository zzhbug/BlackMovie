package com.zzh.blackmovie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.model.MovieRankAll;
import com.zzh.blackmovie.ui.selfview.RecyclerBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class RankAdapter extends RecyclerBaseAdapter<MovieRankAll.MovieRankContent.MovieRank> implements View.OnClickListener {
    private int [] r={R.mipmap.rank_first_icon,R.mipmap.rank_second_icon,R.mipmap.rank_third_icon,R.mipmap.rank_other_icon};

//    private OnItemClickListener listener;
    public RankAdapter(Context context, List<MovieRankAll.MovieRankContent.MovieRank> data, int itemId) {
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
        ImageView imageView = (ImageView) holder.getView(R.id.img_recycler_rank_item);
        ImageView tagView = (ImageView) holder.getView(R.id.tag_recycler_rank_item);
        TextView numView = (TextView) holder.getView(R.id.num_recycler_rank_item);
        numView.setText(""+(dataPosition+1));
        Picasso.with(mContext)
                .load(mData.get(dataPosition).getMovieImageUrl())
                .placeholder(R.mipmap.picdefault)
                .resize(120,160)
                .into(imageView);

        if (dataPosition<3) {

            Picasso.with(mContext).load(r[dataPosition]).into(tagView);
        }else {

            Picasso.with(mContext).load(r[3]).into(tagView);
        }

        TextView textView = (TextView) holder.getView(R.id.text_recycler_rank_item);
        textView.setText(mData.get(dataPosition).getName());


    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
        if (mListener!=null) {
            mListener.OnItemClick(v,childAdapterPosition);
        }

    }
}
