package com.lfh.base.module.base.presenter;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * MVP presenter层基类
 * Created by lifuhai on 2017/3/9 0009.
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {
    private WeakReference<V> mVWeakReference;//为了避免内存泄露，只持有View的弱引用

    @Override
    @CallSuper
    public void onViewAttach(V pView) {
        mVWeakReference = new WeakReference<V>(pView);
    }

    @Override
    @CallSuper
    public void onViewDetach() {
        if (null != mVWeakReference) {
            mVWeakReference.clear();
            mVWeakReference = null;
        }
    }

    public final boolean isViewAttached() {
        return null != mVWeakReference && null != mVWeakReference.get();
    }

    @Nullable
    public final V getView() {
        return null == mVWeakReference ? null : mVWeakReference.get();
    }

    public final void checkViewAttached() {
        if (!isViewAttached()) throw new ViewNotAttachedException();
    }

    public final static class ViewNotAttachedException extends RuntimeException {
        public ViewNotAttachedException() {
            super("Please call Presenter.onViewAttach(BaseView) before" + " requesting data to the Presenter");
        }
    }
}
