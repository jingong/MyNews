package com.edu.ldu.cn.mynews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.ldu.cn.mynews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CareFragment extends Fragment {


    public CareFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_care, container, false);
        return view;
    }

}
