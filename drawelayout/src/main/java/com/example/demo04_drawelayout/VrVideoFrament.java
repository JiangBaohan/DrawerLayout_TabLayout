package com.example.demo04_drawelayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * data:2017/8/3
 * author:汉堡(Administrator)
 * function:
 */
public class VrVideoFrament extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment03, container, false);
    }
}
