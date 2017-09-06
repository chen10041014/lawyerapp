package com.yuanjin.attorney.attorney.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yuanjin.attorney.attorney.bean.FragmentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chan on 2017/8/23.
 */

public class Case_CaseAdapter extends FragmentStatePagerAdapter {
    private List<FragmentInfo> mShowItems = new ArrayList<>();

    public Case_CaseAdapter(FragmentManager fm, List<FragmentInfo> showItems) {
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

    @Override
    public CharSequence getPageTitle(int position) {
        return mShowItems.get(position).title;
    }
}
