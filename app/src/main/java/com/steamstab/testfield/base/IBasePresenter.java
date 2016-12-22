package com.steamstab.testfield.base;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Steam on 16/12/15.
 */

public interface IBasePresenter<V extends IBaseView> {

    void attchView(V view);

    void detachView();

    void subscribe();

    void addSubscription(Subscription subscription);

    void unsubscribe();

}
