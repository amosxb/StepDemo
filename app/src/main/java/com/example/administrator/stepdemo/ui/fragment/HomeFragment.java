package com.example.administrator.stepdemo.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.stepdemo.R;
import com.example.administrator.stepdemo.base.BaseFragment;
import com.example.administrator.stepdemo.base.BasePresenter;
import com.example.administrator.stepdemo.model.response.HomeResponse;
import com.example.administrator.stepdemo.ui.holder.HomeHolder;

import java.util.logging.StreamHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import me.drakeet.multitype.MultiTypeAsserts;

/**
 * 首页fragment
 *
 * @author xb
 * @time 2018/11/14 0014 10:43
 */
public class HomeFragment extends BaseFragment {

    private Items mItems = new Items();
    private MultiTypeAdapter mMultiTypeAdapter;

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private String[] amounts = new String[]{"5645.30", "687.00", "300.00"};
    private String[] wallets = new String[]{"WTL钱包", "KYB钱包", "ECS钱包"};
    private int[] walletUrls = new int[]{R.drawable.ic_wtl, R.drawable.ic_kyb, R.drawable.ic_ecs};

    @Override
    protected void initData() {
        for (int i = 0; i < amounts.length; i++) {
            mItems.add(new HomeResponse(walletUrls[i], wallets[i], amounts[i]));
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView(View rootView) {
        mMultiTypeAdapter = new MultiTypeAdapter(mItems);
        mMultiTypeAdapter.register(HomeResponse.class, new HomeHolder());
        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.setAdapter(mMultiTypeAdapter);
    }

    @Override
    protected int contentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @OnClick(R.id.rv_list)
    public void onClick() {
    }
}
