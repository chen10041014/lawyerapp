package com.yuanjin.attorney.attorney.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yuanjin.attorney.attorney.bean.HomeLableDetailsInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chan on 2017/6/28.
 */

public class HomeLableAdapter extends FragmentStatePagerAdapter {
    private List<HomeLableDetailsInfo> mShowItems = new ArrayList<>();

    public HomeLableAdapter(FragmentManager fm, List<HomeLableDetailsInfo> showItems) {
        super(fm);
        this.mShowItems = showItems;
    }


    @Override
    public Fragment getItem(int position) {

        return mShowItems.get(position).mFragment;
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
