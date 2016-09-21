package com.zzh.blackmovie.ui.selfview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/12 0012.
 */
public abstract class AllAdapter<T> extends BaseAdapter {

    private List<T> mData;
    private LayoutInflater inflater;
    private int mListResource;

    public AllAdapter(Context context,List<T> mData, int mListResource) {
        if (mData != null){
            this.mData = mData;
        }else {
            this.mData = new ArrayList<>();
        }

        this.mListResource = mListResource;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoler holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(mListResource,parent,false);
            holder = new ViewHoler(convertView) ;
            convertView.setTag(holder);
        }else {
            holder = (ViewHoler) convertView.getTag();
        }
        initData(holder,mData.get(position),position);
        return convertView;
    }

    /**
     * 加载数据
     * @param holer
     * @param data
     * @param position
     */
    protected abstract void initData(ViewHoler holer,T data,int position);

    /**
     * 下拉刷新
     * @param data
     */
    public void updateRes(List<T> data){
        if (data != null) {
            mData.clear();
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    /**
     * 上拉加载
     * @param data
     */
    public void addRes(List<T> data){
        if (data != null) {
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    protected static class ViewHoler{
        private View convertView;
        private Map<Integer,View> mCacheView;
        public ViewHoler(View convertView) {
            this.convertView = convertView;
            mCacheView = new HashMap<>();
        }

        public View getView(int resId){
            View view = null;
            if (mCacheView.containsKey(resId)) {
                view = mCacheView.get(resId);

            }else {
                view = convertView.findViewById(resId);
                mCacheView.put(resId,view);
            }
            return view;
        }
    }


}
