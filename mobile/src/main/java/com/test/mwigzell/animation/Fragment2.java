package com.test.mwigzell.animation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.test.mwigzell.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment2 extends Fragment
{
    @BindView(R.id.fragment2_logo)
    ImageView mLogo;
    @BindView(R.id.fragment2_button)
    ImageButton mButton;

    public Fragment2()
    {
        // Required empty public constructor
    }

    public static Fragment2 newInstance()
    {
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment2, container, false);
        if (v != null)
        {
            ButterKnife.bind(this, v);
        }
        return v;
    }
}