package com.steamstab.testfield.base;

import rx.Subscription;

/**
 * Created by Steam on 16/12/15.
 */

public interface IBasePresenter<V extends IBaseView> {

    /**
     * 绑定View
     * @param view
     */
    void attchView(V view);

    /**
     * 解绑View
     */
    void detachView();

    /**
     * 订阅
     */
    void subscribe();

    /**
     * 对异步操作添加统一管理
     * @param subscription
     */
    void addSubscription(Subscription subscription);

    /**
     * 解绑
     */
    void unsubscribe();

}