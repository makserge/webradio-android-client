package com.smsoft.webradio.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.smsoft.webradio.R;
import com.smsoft.webradio.fragment.TabFragment;

/**
 * Created by sergey on 02.12.2015.
 */
public class TabsPageFragmentAdapter extends FragmentPagerAdapter {
    private static final int FM_POSITION = 0;
    private static final int WEB_POSITION = 1;
    private static final int MP3_POSITION = 2;
    private Context mContext;
    private int mTabs[] = { R.string.fm_radio, R.string.web_radio, R.string.mp3_player };

    public TabsPageFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabsPageFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(mTabs[position]);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case FM_POSITION:
                return TabFragment.getInstance();
            case WEB_POSITION:
                return TabFragment.getInstance();
            case MP3_POSITION:
                return TabFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }
}
