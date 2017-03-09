package com.lfh.base.module.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lfh.base.module.inject.Dagger;
import com.lfh.base.module.inject.component.AppCmp;

/**
 * Created by lifuhai on 2017/3/9 0009.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setComponent(Dagger.instance.appCmp());
    }

    protected void setComponent(AppCmp pComponent) {
    }
}
