package com.zzh.blackmovie.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.lhh.ptrrv.library.PullToRefreshRecyclerView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zzh.blackmovie.R;
import com.zzh.blackmovie.activity.PlayActivity;
import com.zzh.blackmovie.adapter.HomeRecyclerAdapter;
import com.zzh.blackmovie.base.BaseFragment;
import com.zzh.blackmovie.http.BaseCallback;
import com.zzh.blackmovie.http.Contants;
import com.zzh.blackmovie.http.JsonBaseSerializator;
import com.zzh.blackmovie.model.HomeMovieAll;
import com.zzh.blackmovie.model.MovieSort;
import com.zzh.blackmovie.model.ProductmovieList;
import com.zzh.blackmovie.ui.selfview.DemoLoadMoreView;
import com.zzh.blackmovie.ui.selfview.DividerItemDecoration;
import com.zzh.blackmovie.ui.selfview.NetworkImageHolderView;
import com.zzh.blackmovie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class HomeFragment extends BaseFragment implements OnItemClickListener {
    public static final String TAG = "HomeFragment";
    @BindView(R.id.pullRecyclerView)
    PullToRefreshRecyclerView mPullRecyclerView;
    //    @BindView(R.id.recyclerHome)
    //    RecyclerView mRcyclerHome;
    //    @BindView(R.id.slidingLayout)
    //    SlidingLayout mSlidingLayout;
    private List<MovieSort> mData;
    private HomeRecyclerAdapter mHomeAdapter;
    private LinearLayout mHeaderView;
    private int mPageIndex = 10;
    private int mStartIndex = 0;
    private int mMaxIndex = 100;
    private ConvenientBanner mConvenientBanner;
    private List<String> networkImages = new ArrayList();
    private List<ProductmovieList> mProductmovieList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initHttp(DOWN_DATA);
    }


    private void initView() {

        DemoLoadMoreView loadMoreView = new DemoLoadMoreView(getActivity(), mPullRecyclerView.getRecyclerView());
        loadMoreView.setLoadmoreString("Loading");
        loadMoreView.setLoadMorePadding(80);

        mPullRecyclerView.setLoadMoreCount(9);

        mPullRecyclerView.setLoadMoreFooter(loadMoreView);

        // set true to open swipe(pull to refresh, default is true)
        mPullRecyclerView.setSwipeEnable(true);

        mPullRecyclerView.setRefreshing(true);


        // set the layoutManager which to use
        mPullRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


        // set PagingableListener
        mPullRecyclerView.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                //do loadmore here
                Log.d(TAG, ": ");
                initHttp(UP_DATA);
            }
        });


        // set OnRefreshListener
        mPullRecyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // do refresh here
                Log.d(TAG, "onRefresh: ");
                mStartIndex = 0;
                mPageIndex = 10;
                initHttp(DOWN_DATA);

            }
        });

        // add item divider to recyclerView
        mPullRecyclerView.getRecyclerView().addItemDecoration(new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL_LIST));

        //----------------添加头布局------------------------------------------
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mHeaderView = ((LinearLayout) inflater.inflate(R.layout.home_head, null));
        mConvenientBanner = ((ConvenientBanner) mHeaderView.findViewById(R.id.convenientBanner));
        mPullRecyclerView.addHeaderView(mHeaderView);
        //----------------添加头布局------------------------------------------
        //----------------添加空白页------------------------------------------
        View inflate = View.inflate(getActivity(), R.layout.empty_view, null);
        mPullRecyclerView.setEmptyView(inflate);

        ImageView imgLoading = (ImageView) inflate.findViewById(R.id.imgLoading);
        AnimationDrawable animationDrawable = (AnimationDrawable) imgLoading.getDrawable();
        animationDrawable.start();

        // set loadmore enable, onFinishLoading(can load more? , select before item)
        mPullRecyclerView.onFinishLoading(true, false);

        mData = new ArrayList<>();
        mHomeAdapter = new HomeRecyclerAdapter(getActivity(), mData, R.layout.home_movie_item);

        mPullRecyclerView.setAdapter(mHomeAdapter);

    }


    private void initHttp(final int type) {
        String url = Contants.HOME_URL_HEAD + mPageIndex + Contants.HOME_URL_FOOT;
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new BaseCallback<HomeMovieAll>(new JsonBaseSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.makeText("网络连接失败");
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onResponse(HomeMovieAll response, int id) {
                        switch (type) {
                            case UP_DATA:
                                upData(response);
                                break;
                            case DOWN_DATA:
                                downData(response);
                                break;
                        }
                        mPullRecyclerView.setOnRefreshComplete();
                        mPullRecyclerView.onFinishLoading(true, false);
                    }
                });
    }

    private void upData(HomeMovieAll response) {

        ArrayList<MovieSort> list = new ArrayList<>();
        List<MovieSort> content = response.getContent();
        for (int i = mStartIndex; i < content.size(); i++) {
            list.add(content.get(i));
        }
        mHomeAdapter.updataRes(list);
        mStartIndex = mPageIndex;
        mPageIndex += 10;

    }

    private void downData(HomeMovieAll response) {
        List<MovieSort> content = response.getContent();
        MovieSort remove = content.remove(mStartIndex);
        //添加头部数据
        List<ProductmovieList> productmovieList = remove.getProductmovieList();

        addHeadData(productmovieList);
        //------------------
        mHomeAdapter.downDataRes(content);
        mStartIndex = mPageIndex;
        mPageIndex += 10;

    }

    private void addHeadData(List<ProductmovieList> productmovieList) {
        this.mProductmovieList = productmovieList;
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        mConvenientBanner.setPages(
                new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                }, productmovieList)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setOnItemClickListener(this);
        //                //设置指示器的方向
        //                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        //设置翻页的效果，不需要翻页效果可用不设
        //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
        //        mConvenientBanner.setManualPageable(false);//设置不能手动影响
    }


    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        mConvenientBanner.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mConvenientBanner.stopTurning();
    }

    /**
     * viewPager点击监听
     *
     * @param position
     */
    @Override
    public void onItemClick(int position) {
        ToastUtil.makeText(String.valueOf(position));
        int id = mProductmovieList.get(position).getId();
        Intent intent = new Intent(getActivity(), PlayActivity.class);
        intent.putExtra("movieid",id);
        getActivity().startActivity(intent);

    }
}
