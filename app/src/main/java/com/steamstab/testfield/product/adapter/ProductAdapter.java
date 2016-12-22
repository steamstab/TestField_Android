package com.steamstab.testfield.product.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.steamstab.testfield.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Steam on 16/12/20.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.VH> {

    private Context mContext;
    private ArrayList<String> mList;

    public ProductAdapter(Context context, ArrayList<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.setMessage(mList.get(position));
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(mContext).inflate(R.layout.list_item_base,
                parent, false));
    }

    public class VH extends RecyclerView.ViewHolder {

        @BindView(R.id.message)
        public TextView mTextView;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setMessage(String s){
            mTextView.setText(s);
        }
    }
}
