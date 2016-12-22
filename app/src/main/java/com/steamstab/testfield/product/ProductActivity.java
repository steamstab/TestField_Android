package com.steamstab.testfield.product;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.steamstab.testfield.R;
import com.steamstab.testfield.base.BaseActivity;
import com.steamstab.testfield.product.Presenter.ProductPresenter;
import com.steamstab.testfield.product.adapter.ProductAdapter;
import com.steamstab.testfield.product.contract.IProductContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Steam on 16/12/20.
 */

public class ProductActivity extends BaseActivity implements IProductContract.IView {

    @BindView(R.id.RecyclerView)
    RecyclerView mRecyclerView;

    private ProductPresenter mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_product);
        Log.d("activity", "onCreate");
        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void updateProduct(ArrayList<String> products) {
        mRecyclerView.setAdapter(new ProductAdapter(this, products));
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("activity", "onResume");
        mPresenter = new ProductPresenter(this);
        mPresenter.getProduct("product");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("activity", "onStart");
    }
}
