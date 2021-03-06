package com.test.mwigzell.animation;

import android.os.Bundle;
import android.os.Handler;
import android.support.transition.Fade;
import android.support.transition.TransitionInflater;
import android.support.transition.TransitionSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.mwigzell.test.R;

import butterknife.ButterKnife;

/**
 * Created by mwigzell on 2/6/18.
 */

public class SharedElementActivity extends AppCompatActivity {
    private static final long MOVE_DEFAULT_TIME = 1000;
    private static final long FADE_DEFAULT_TIME = 300;

    private FragmentManager mFragmentManager;

    private Handler mDelayedTransactionHandler = new Handler();
    private Runnable mRunnable = this::performTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();

        loadInitialFragment();
        mDelayedTransactionHandler.postDelayed(mRunnable, 1000);
    }

    private void loadInitialFragment()
    {
        Fragment initialFragment = Fragment1.newInstance();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, initialFragment);
        fragmentTransaction.commit();
    }

    private void performTransition()
    {
        if (isDestroyed())
        {
            return;
        }
        Fragment previousFragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        Fragment nextFragment = Fragment2.newInstance();

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        // 1. Exit for Previous Fragment
        Fade exitFade = new Fade();
        exitFade.setDuration(FADE_DEFAULT_TIME);
        previousFragment.setExitTransition(exitFade);

        // 2. Shared Elements Transition
        TransitionSet enterTransitionSet = new TransitionSet();
        enterTransitionSet.addTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.move));
        enterTransitionSet.setDuration(MOVE_DEFAULT_TIME);
        enterTransitionSet.setStartDelay(FADE_DEFAULT_TIME);
        nextFragment.setSharedElementEnterTransition(enterTransitionSet);

        // 3. Enter Transition for New Fragment
        Fade enterFade = new Fade();
        enterFade.setStartDelay(MOVE_DEFAULT_TIME + FADE_DEFAULT_TIME);
        enterFade.setDuration(FADE_DEFAULT_TIME);
        nextFragment.setEnterTransition(enterFade);

        View logo = this.findViewById(R.id.fragment1_logo);
        fragmentTransaction.addSharedElement(logo, logo.getTransitionName());
        fragmentTransaction.replace(R.id.fragment_container, nextFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mDelayedTransactionHandler.removeCallbacks(mRunnable);
    }
}