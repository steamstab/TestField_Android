package com.steamstab.testfield.product.Presenter;


import com.steamstab.testfield.base.BasePresenter;
import com.steamstab.testfield.product.contract.IProductContract;
import com.steamstab.testfield.product.contract.IProductContract.IPresenter;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by Steam on 16/12/20.
 */

public class ProductPresenter extends BasePresenter<IProductContract.IView> implements IPresenter {

    private IProductContract.IView mView;


    public ProductPresenter(IProductContract.IView view) {
        mView = view;
    }

    @Override
    public void getProduct(String key) {

//        if (key == null) {
//            return;
//        }
//
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 50; i++){
//            list.add(i + "");
//        }
//        mView.updateProduct(list);

    }

}
