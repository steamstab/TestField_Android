package com.steamstab.testfield.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Steam on 16/12/21.
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V mView;
    private CompositeSubscription mCompositeSubscription;

    @Override
    public void attchView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unsubscribe();
    }

    @Override
    public void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
