package com.edu.ldu.cn.mynews.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.edu.ldu.cn.mynews.NewsDetailActivity;
import com.edu.ldu.cn.mynews.R;
import com.edu.ldu.cn.mynews.adapter.NetNewsAdapter;
import com.edu.ldu.cn.mynews.entity.NetNews;
import com.edu.ldu.cn.mynews.entity.NewsType;
import com.edu.ldu.cn.mynews.request.StringHeaderRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private List<NetNews> mData;
    private NetNewsAdapter adapter;

    public NewsFragment() {
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ListView lv = (ListView)view.findViewById(R.id.news_list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), NewsDetailActivity.class);
                NetNews n = (NetNews)adapter.getItem(position);
                intent.putExtra("url",n.getUrl());
                startActivity(intent);
            }
        });
        mData = new ArrayList<>();
        loadData();
        //initData();
        adapter = new NetNewsAdapter(mData,getActivity());
        lv.setAdapter(adapter);
        return view;
    }

    private void loadData() {
        NewsType nt = (NewsType)getArguments().getSerializable("type");
        //创建请求队列
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(
                Request.Method.GET,
                nt.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        System.out.println(s);
                        try {
                            JSONObject job = new JSONObject(s);
                            if (job.getString("reason").equals("成功的返回")){
                                List<NetNews> news = new ArrayList<>();
                                JSONObject result = job.getJSONObject("result");
                                JSONArray ja = result.getJSONArray("data");
                                for (int i = 0; i < ja.length(); i++) {
                                    JSONObject item = ja.getJSONObject(i);
                                    NetNews n = new NetNews();
                                    n.setPicUrl(item.getString("thumbnail_pic_s"));
                                    n.setTitle(item.getString("title"));
                                    n.setNtime(item.getString("date"));
                                    n.setDescription(item.getString("author_name"));
                                    n.setUrl(item.getString("url"));
                                    news.add(n);
                                }
                                mData.addAll(news);
                                adapter.notifyDataSetChanged();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }
        );
        queue.add(request);
    }

//    private void initData() {
//        mData.add(
//                new NetNews(
//                        "刚刚",
//                        "民进党代表提华航改台航网友讽刺：中国卧底",
//                        "北京晨报",
//                        "",
//                        R.mipmap.ic_launcher
//                )
//        );
//
//        mData.add(
//                new NetNews(
//                        "刚刚",
//                        "热烈庆祝两会成功召开",
//                        "北京晨报",
//                        "",
//                        R.mipmap.ic_launcher
//                )
//        );
//
//        mData.add(
//                new NetNews(
//                        "刚刚",
//                        "留守儿童面临生活困难",
//                        "北京晨报",
//                        "",
//                        R.mipmap.ic_launcher
//                )
//        );
//
//        mData.add(
//                new NetNews(
//                        "刚刚",
//                        "国家鼓励大学生自主创业",
//                        "北京晨报",
//                        "",
//                        R.mipmap.ic_launcher
//                )
//        );
//
//        mData.add(
//                new NetNews(
//                        "刚刚",
//                        "北京出现罕见的雾霾天气",
//                        "北京晨报",
//                        "",
//                        R.mipmap.ic_launcher
//                )
//        );
//
//        mData.add(
//                new NetNews(
//                        "刚刚",
//                        "国家大力扶持中小型企业",
//                        "北京晨报",
//                        "",
//                        R.mipmap.ic_launcher
//                )
//        );
//
//        mData.add(
//                new NetNews(
//                        "刚刚",
//                        "某高中学生各科成绩均是满分",
//                        "北京晨报",
//                        "",
//                        R.mipmap.ic_launcher
//                )
//        );
//
//    }

}
