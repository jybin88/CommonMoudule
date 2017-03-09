package com.lfh.base.module.inject.component;

import android.app.Application;

import com.lfh.base.module.inject.module.AppModule;
import com.lfh.base.module.sdk.NetOperator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by lifuhai on 2017/3/9 0009.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppCmp {
    NetOperator operator();

    Application application();

//    void inject();
}
