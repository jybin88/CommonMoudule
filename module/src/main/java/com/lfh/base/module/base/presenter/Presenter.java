package com.lfh.base.module.base.presenter;

/**
 * Created by lifuhai on 2017/3/9 0009.
 */
public interface Presenter<V extends BaseView> {
    void onViewAttach(V pV);

    void onViewDetach();
}
