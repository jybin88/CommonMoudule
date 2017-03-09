package com.lfh.base.module.inject.module;

import android.app.Activity;
import android.content.Context;

import com.lfh.base.module.inject.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lifuhai on 2017/3/9 0009.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity pActivity) {
        this.mActivity = pActivity;
    }

    @Provides
    Activity provideActivity() {
        return this.mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return this.mActivity.getApplicationContext();
    }
}
