package com.gavin.city.glideapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public class MovicesAdapter extends BaseRecycleAdapter<MovicesAdapter.MyHolde> {
    public List<String> mDatas;

    public MovicesAdapter(Context context, List mDatas) {
        super(context, mDatas);
        this.mDatas = mDatas;
    }

    @Override
    public MyHolde onCreateViewHolders(ViewGroup parent, int viewType) {
        MyHolde holder = new MyHolde(LayoutInflater.from(context).inflate(R.layout.item_movices, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolders(MyHolde holder, int position) {
        Log.e("1111", mDatas.get(position));
//        Picasso.with(context)
//                .load(mDatas.get(position))
//                .error(R.mipmap.ic_launcher)
//                .placeholder(R.mipmap.ic_launcher_round)
//                .into(holder.ima);
        holder.ima.setText(mDatas.get(position));

    }

    class MyHolde extends BaseRecycleAdapter.ViewHolder {
        TextView ima;

        public MyHolde(View itemView) {
            super(itemView);
            ima = (TextView) itemView.findViewById(R.id.img);
        }
    }

}
