package com.smsoft.webradio.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smsoft.webradio.R;

/**
 * Created by sergey on 02.12.2015.
 */
public class TabFragment extends Fragment {
    public TabFragment() {
    }

    public static TabFragment getInstance() {
        return new TabFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        return view;
    }
}
