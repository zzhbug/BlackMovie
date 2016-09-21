package com.zzh.blackmovie.ui.selfview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/12 0012.
 * 9/15添加去掉头布局的方法
 */
public abstract class RecyclerBaseAdapter<T> extends RecyclerView.Adapter<RecyclerBaseAdapter.ViewHolder> {
    private static final String TAG = "RecyclerBaseAdapter";
    protected static final int HEAD_TYPE = 1111;//头的类型 可能冲突
    protected List<T> mData;
    protected int mItemRes;
    protected RecyclerView mRecyclerView;
    protected LayoutInflater mInflater;
    protected int mHeaderSize = 0;
    protected Map<Integer, View> mHeaderView;
    protected OnItemClickListener mListener;
    protected Context mContext;
    /**
     * //当前头布局的位置  调用getItemViewType后才能生效
     */
    private int mCurrentIndex = 0;

    public RecyclerBaseAdapter(Context context, List<T> data, int itemId) {
        if (data == null) {
            this.mData = new ArrayList<>();
        } else {
            this.mData = data;
        }
        this.mInflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        this.mItemRes = itemId;
        this.mContext = context;
    }


    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private Map<Integer, View> sViewCache;
        private View coverView;

        public ViewHolder(View itemView) {
            super(itemView);
            sViewCache = new HashMap<>();
            this.coverView = itemView;
        }

        /**
         * @param resId 通过id查找View
         * @return
         */
        public View getView(int resId) {
            View v;
            if (sViewCache.containsKey(resId)) {
                v = sViewCache.get(resId);
            } else {
                Log.d(TAG, "getView: FindById");
                v = coverView.findViewById(resId);
                sViewCache.put(resId, v);
            }
            return v;
        }

        public View getCoverView() {
            return coverView;
        }

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEAD_TYPE) {
            Log.e(TAG, "onCreateViewHolder: " + mCurrentIndex);
            return new ViewHolder(mHeaderView.get(mCurrentIndex));
        } else {
            //非头布局
            View view = mInflater.inflate(mItemRes, parent, false);
            ViewHolder fistViewHolder = new ViewHolder(view);
            return onCreateBaseViewHolder(fistViewHolder, parent, viewType);
        }
    }


    /**
     * @param fistViewHolder 默认ViewHolder(第一个布局的ViewHolder)
     * @param parent         父控件
     * @param viewType       类别
     * @return
     */
    protected abstract ViewHolder onCreateBaseViewHolder(ViewHolder fistViewHolder, ViewGroup parent, int viewType);

    /**
     * 获取条目在RecyclerView中的位置
     *
     * @param holder
     * @return
     */
    public int getRelPosition(RecyclerView.ViewHolder holder) {
        int layoutPosition = holder.getLayoutPosition();
        //数据从0开始 添加头之后头的item 位置为0 所有layoutPosition - mHeaderSize

        return mHeaderView == null ? layoutPosition : layoutPosition - mHeaderSize;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position > mHeaderSize - 1) {
            //非头布局会调用此方法
            Log.d(TAG, "onBindViewHolder: " + getRelPosition(holder));
            onBindBaseViewHolder(holder, getRelPosition(holder), position);
        }
    }

    /**
     * @param holder
     * @param dataPosition 数据在mData中的位置
     * @param itemPosition item在RecycleView中的位置
     */
    protected abstract void onBindBaseViewHolder(ViewHolder holder, int dataPosition, int itemPosition);


    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + mData.size());
        return mData == null ? mHeaderSize : mData.size() + mHeaderSize;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @Override
    public int getItemViewType(int position) {

        if (position < mHeaderSize) {
            mCurrentIndex = position;
            Log.d(TAG, "getItemViewType: " + position);

            return HEAD_TYPE;
        } else {
            return getItemBaseViewType(position);
        }

    }

    /**
     * @param position 不是头布局 默认返回0
     * @return
     */
    public int getItemBaseViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     * @param data 上拉加载
     */
    public void updataRes(List<T> data) {
        if (data != null) {
            this.mData.addAll(data);
            this.notifyDataSetChanged();
        }
    }

    /**
     * @param data 下拉刷新
     */
    public void downDataRes(List<T> data) {
        if (data != null) {
            this.mData.clear();
            this.mData.addAll(data);
            this.notifyDataSetChanged();
        }

    }

    /**
     * 添加一个Item
     *
     * @param data
     * @param position
     */
    public void addItem(T data, int position) {
        this.addItem(data, position);
        this.notifyItemInserted(position);
    }

    /**
     * 删除一个Item
     *
     * @param position
     */
    public void removeItem(int position) {
        this.mData.remove(position);
        notifyItemInserted(position);
    }

    /**
     * 添加头布局
     *
     * @param view
     */
    public void addHeadView(View view) {
        if (mHeaderView == null) {
            mHeaderView = new HashMap<>();
        }
        mHeaderView.put(mHeaderSize, view);
        mHeaderSize++;
        Log.d(TAG, "addHeadView: " + mHeaderSize);
        //        this.notifyItemInserted(0);
        this.notifyDataSetChanged();
    }

    /**
     * 删除头布局
     *
     * @return
     */

    public boolean removeHeadView() {
        View view = mHeaderView.remove(--mHeaderSize);
        if (view == null) {
            Log.e(TAG, "removeHeadView: 没有头布局");
            return false;
        }
        mRecyclerView.removeViewAt(mHeaderSize);
        this.notifyDataSetChanged();
        return true;
    }


    /**
     * item的监听接口
     */
    public interface OnItemClickListener {
        public void OnItemClick(View view, int position);
    }


}
