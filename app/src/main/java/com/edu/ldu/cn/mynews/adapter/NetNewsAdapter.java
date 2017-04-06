package com.edu.ldu.cn.mynews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.edu.ldu.cn.mynews.R;
import com.edu.ldu.cn.mynews.entity.NetNews;

import java.util.List;

/**
 * Created by mic on 2017/1/20.
 */

public class NetNewsAdapter extends BaseAdapter {
    private List<NetNews> mData;
    private Context context;
    public NetNewsAdapter(){

    }
    public NetNewsAdapter(List<NetNews> mData,Context context){
        this.mData = mData;
        this.context = context;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NetNews n = this.mData.get(position);
        //布局加载器
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.news_item,null,false);
        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        TextView title = (TextView)convertView.findViewById(R.id.title);
        TextView description = (TextView)convertView.findViewById(R.id.description);
        TextView time = (TextView)convertView.findViewById(R.id.time);

        Glide.with(context)
                .load(n.getPicUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(img);
        img.setImageResource(R.mipmap.ic_launcher);
        title.setText(n.getTitle());
        description.setText(n.getDescription());
        time.setText(n.getNtime());
        return convertView;
    }
}
