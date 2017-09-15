package com.gavin.city.glideapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gavin on 2017/9/10.
 * 对recycleview adapter进行简单封装
 *
 */

public interface BaseRecycleAdapterImpl{


    /**
     * 点击事件
     * @param itemClickListener
     */
    public void setItemClickListener(BaseRecycleAdapter.OnItemClickListener itemClickListener) ;
    /**
     *长按事件
     */
    public void setItemLongClickListener(BaseRecycleAdapter.OnItemLongClickListener itemLongClickListener) ;
    /**
     * 添加头部
     * @param headerView
     */
    public void addHeaderView(View headerView);

    /**
     * 添加底部
     * @param footView
     */
    public void addFootView(View footView) ;
    /**
     * 添加刷新
     * @param position
     */
    public void notifyItemInsert(int position) ;

    /**
     * 移除刷新
     * @param position
     */
    public void notifyItemRemov(int position) ;
    /**
     * 移除HeaderView
     * @param view
     */
    public void  removeHeadViewItem(View view);

    /**
     * 移除FootView
     * @param view
     */
    public void  removeFootViewItem(View view);
}
