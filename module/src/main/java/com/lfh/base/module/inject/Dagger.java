package com.lfh.base.module.inject;

import com.lfh.base.module.inject.component.AppCmp;
import com.lfh.base.module.inject.component.DaggerAppCmp;

/**
 * Created by lifuhai on 2017/3/9 0009.
 */
public enum Dagger {
    instance;

    private AppCmp mAppCmp;

    public synchronized AppCmp appCmp(){
        if(null == mAppCmp) {
            mAppCmp = DaggerAppCmp.create();
        }

        return mAppCmp;
    }
}
