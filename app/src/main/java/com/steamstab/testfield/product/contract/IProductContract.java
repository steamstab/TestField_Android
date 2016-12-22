package com.steamstab.testfield.product.contract;

import com.steamstab.testfield.base.IBasePresenter;
import com.steamstab.testfield.base.IBaseView;

import java.util.ArrayList;

/**
 * Created by Steam on 16/12/19.
 */

public interface IProductContract {

    interface IView extends IBaseView {

        void updateProduct(ArrayList<String> products);
    }

    interface IPresenter extends IBasePresenter<IView> {

        void getProduct(String key);
    }
}
