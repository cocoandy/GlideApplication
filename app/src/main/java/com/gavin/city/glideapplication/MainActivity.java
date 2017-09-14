package com.gavin.city.glideapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list;
    RecyclerView mRecyclerView;
    MovicesAdapter adapter;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.layout);
        initList();
    }

    public void initList() {
        list = new ArrayList<>();
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170912/20170912092013_71898.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170913/20170913113710_88568.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170913/20170913113031_40537.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170913/20170913112611_23177.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170727/20170727101138_54444.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170824/20170824141052_71833.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170830/20170830095005_21201.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170830/20170830095937_58163.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170905/20170905094626_16607.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170906/20170906092131_68417.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170906/20170906094609_54724.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170906/20170906100416_71810.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170908/20170908091230_67498.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170909/20170909085637_14931.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170906/20170906094609_54724.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170906/20170906100416_71810.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170908/20170908091230_67498.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170909/20170909085637_14931.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170912/20170912092013_71898.jpg");
        list.add("https://www.jkmovies.jukest.cn/Upload/image/20170913/20170913113710_88568.jpg");
        initRecycle();
    }
    private void initRecycle() {
        adapter = new MovicesAdapter(this,list);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle);
        //创建默认的线性LayoutManager

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        mRecyclerView.setHasFixedSize(true);
        //创建并设置Adapter
        mRecyclerView.setAdapter(adapter);

        View headview1 = LayoutInflater.from(this).inflate(R.layout.headview1, mRecyclerView, false);
        View headview2 = LayoutInflater.from(this).inflate(R.layout.headview2, mRecyclerView, false);
        headview2.findViewById(R.id.layout).setVisibility(View.VISIBLE);
        adapter.addHeaderView(headview1);
        adapter.addHeaderView(headview2);
        View footview1 = LayoutInflater.from(this).inflate(R.layout.footview1, mRecyclerView, false);
        View footview2 = LayoutInflater.from(this).inflate(R.layout.footview2, mRecyclerView, false);
        adapter.addFootView(footview1);
        adapter.addFootView(footview2);

        //点击事件
        adapter.setItemClickListener(new BaseRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseRecycleAdapter.ViewHolder holder, int position) {
                //内容部分点击事件(position不用加减头部)
                Toast.makeText(MainActivity.this,"我是内容部分"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onHeadClick(BaseRecycleAdapter.ViewHolder holder, int position) {
                //头部点击
                Toast.makeText(MainActivity.this,"我是头部"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFootClick(BaseRecycleAdapter.ViewHolder holder, int position) {
                //底部点击
                Toast.makeText(MainActivity.this,"我是底部"+position,Toast.LENGTH_SHORT).show();
            }
        });
        //长按（和点击事件类似）
        adapter.setItemLongClickListener(new BaseRecycleAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseRecycleAdapter.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this,"我是内容部分长按"+position,Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onHeadLongClick(BaseRecycleAdapter.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this,"我是头部长按"+position,Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onFootLongClick(BaseRecycleAdapter.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this,"我是长按"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        //滑动事件
        EndLessOnScrollListener endLess = new EndLessOnScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                //上拉加载
                if (list.size()>35) return;
                list.add("我是新加载的 狗狗"+currentPage);
                adapter.notifyItemInsert(list.size()-1);
                adapter.notifyItemRemoved(list.size()-1);

            }

            @Override
            public void onScolled(int firstVisibleItem) {
                //这个是监听当前的可见的第一个item
                if (firstVisibleItem>=1){
                    linearLayout.setVisibility(View.VISIBLE);
                }else {
                    linearLayout.setVisibility(View.GONE);
                }
            }
        };
        mRecyclerView.addOnScrollListener(endLess);
    }
}
