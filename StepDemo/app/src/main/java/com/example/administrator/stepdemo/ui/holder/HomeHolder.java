package com.example.administrator.stepdemo.ui.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.model.response.HomeResponse;
import com.example.administrator.stepdemo.widget.MoneyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

public class HomeHolder extends ItemViewBinder<HomeResponse, HomeHolder.HomeViewHolder> {

    @NonNull
    @Override
    protected HomeViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new HomeViewHolder(inflater.inflate(R.layout.item_home_layout, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull HomeViewHolder holder, @NonNull HomeResponse item) {
        holder.tvWallet.setText(item.getWallet());
        holder.mvAmount.setMoneyText(item.getAmount());
        holder.ivWallet.setImageResource(item.getWallet_url());
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_wallet)
        ImageView ivWallet;

        @BindView(R.id.tv_wallet)
        TextView tvWallet;

        @BindView(R.id.mv_amount)
        MoneyView mvAmount;

        HomeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
