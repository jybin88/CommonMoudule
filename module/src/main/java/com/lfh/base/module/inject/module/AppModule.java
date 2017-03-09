package com.lfh.base.module.inject.module;

import android.app.Application;

import com.lfh.base.module.sdk.NetOperator;
import com.lfh.base.module.sdk.NetOperatorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lifuhai on 2017/3/9 0009.
 */
@Module
public class AppModule {
    @Singleton
    @Provides
    public NetOperator operator() {
        return new NetOperatorImpl();
    }

    @Singleton
    @Provides
    public Application application() {
        return null;
    }
}
