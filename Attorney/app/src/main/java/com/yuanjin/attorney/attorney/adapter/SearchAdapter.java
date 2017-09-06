package com.yuanjin.attorney.attorney.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yuanjin.attorney.attorney.bean.FragmentInfo;

import java.util.ArrayList;
import java.util.List;



public class SearchAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> mShowItems = new ArrayList<>();

    public SearchAdapter(FragmentManager fm, List<FragmentInfo> showItems) {
        super(fm);
        mShowItems = showItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mShowItems.get(position).fragment;
    }

    @Override
    public int getCount() {
        return mShowItems.size();
    }

    /*标题*/

    @Override
    public CharSequence getPageTitle(int position) {
        return mShowItems.get(position).title;
    }
}
