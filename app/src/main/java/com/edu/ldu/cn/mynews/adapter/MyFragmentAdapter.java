package com.edu.ldu.cn.mynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edu.ldu.cn.mynews.entity.NewsType;

import java.util.List;

/**
 * Created by mic on 2017/1/20.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mData;
    private List<NewsType> titles;
    public MyFragmentAdapter(FragmentManager fm,List<Fragment> mData,List<NewsType> titles) {
        super(fm);
        this.mData = mData;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position).getTitle();
    }
}
