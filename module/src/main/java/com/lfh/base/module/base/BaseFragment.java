package com.lfh.base.module.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.lfh.base.module.inject.Dagger;
import com.lfh.base.module.inject.component.AppCmp;

/**
 * Created by lifuhai on 2017/3/9 0009.
 */

public class BaseFragment extends Fragment {

    @CallSuper
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCmp appCmp = Dagger.instance.appCmp();
        setupComponent(appCmp);
    }

    protected void setupComponent(AppCmp pAppCmp) {
    }
}
