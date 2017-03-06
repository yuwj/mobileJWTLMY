package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.jwt.jwtmobile.entity.EntityXunlpcRYXX;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by sheep on 2017/3/2.
 */

public class XunlpcRycxlistActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_view)
    XRecyclerView listView;
    @BindView(R.id.wangge_view)
    XRecyclerView wanggeView;
    private int state = 1;//state=1为列表状态，state=2为网格状态
    private CommonAdapter<EntityXunlpcRYXX> adapterList;
    private CommonAdapter<EntityXunlpcRYXX> adapterWangge;

    private List<EntityXunlpcRYXX> mDatas = new ArrayList<>();
    MenuItem menuItem = null;

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_xunlpc_rycxlist;
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, XunlpcRycxlistActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
        initView();
    }

    private void initParam() {
        //假数据
        EntityXunlpcRYXX entityXunlpcRYXX = new EntityXunlpcRYXX();
        entityXunlpcRYXX.setName("哈登");
        entityXunlpcRYXX.setAddress("武汉市关山大道598号中地数码科技园");
        entityXunlpcRYXX.setSfzh("420205198622738476");
        EntityXunlpcRYXX entityXunlpcRYXX2 = new EntityXunlpcRYXX();
        entityXunlpcRYXX.setName("戈登");
        entityXunlpcRYXX.setAddress("德克萨斯州休斯敦丰田中心球馆");
        entityXunlpcRYXX.setSfzh("420212332385729000");
        mDatas.add(entityXunlpcRYXX);
        mDatas.add(entityXunlpcRYXX2);
        mDatas.add(entityXunlpcRYXX);
        mDatas.add(entityXunlpcRYXX);
        mDatas.add(entityXunlpcRYXX);
        mDatas.add(entityXunlpcRYXX);
        mDatas.add(entityXunlpcRYXX);
        mDatas.add(entityXunlpcRYXX);
        mDatas.add(entityXunlpcRYXX);

        adapterWangge = new CommonAdapter<EntityXunlpcRYXX>(this, R.layout.item_xunlpc_rycx_wangg, mDatas) {
            @Override
            protected void convert(ViewHolder holder, EntityXunlpcRYXX entityXunlpcRYXX, int position) {
                holder.setText(R.id.tv_name, entityXunlpcRYXX.getName());
                holder.setText(R.id.tv_address, entityXunlpcRYXX.getAddress());
                holder.setText(R.id.tv_sfzh, entityXunlpcRYXX.getSfzh());

            }

            @Override
            public void convert(ViewHolder holder, EntityXunlpcRYXX entityXunlpcRYXX) {

            }
        };

        adapterList = new CommonAdapter<EntityXunlpcRYXX>(this, R.layout.item_xunlpc_rycx_xianx, mDatas) {
            @Override
            protected void convert(ViewHolder holder, EntityXunlpcRYXX entityXunlpcRYXX, int position) {
                holder.setText(R.id.tv_name, entityXunlpcRYXX.getName());
                holder.setText(R.id.tv_address, entityXunlpcRYXX.getAddress());
                holder.setText(R.id.tv_sfzh, entityXunlpcRYXX.getSfzh());

            }

            @Override
            public void convert(ViewHolder holder, EntityXunlpcRYXX entityXunlpcRYXX) {

            }
        };
        adapterList.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    private void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        wanggeView.setLayoutManager(new GridLayoutManager(this,2));
        wanggeView.setAdapter(adapterWangge);
        wanggeView.setLoadingMoreEnabled(true);
        wanggeView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        wanggeView.setPullRefreshEnabled(false);
        wanggeView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        wanggeView.loadMoreComplete();
                    }
                }, 2000);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(linearLayoutManager);
        listView.setAdapter(adapterList);
        listView.setLoadingMoreEnabled(true);
        listView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        listView.setPullRefreshEnabled(false);
        listView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listView.loadMoreComplete();
                    }
                }, 2000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_xunlpc_renylb, menu);
        menuItem = menu.findItem(R.id.menu_qiehuan);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_qiehuan:
                if (state == 1) {
                    menuItem.setIcon(getDrawable(R.drawable.ic_xianxlb));
                    wanggeView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    state = 2;
                } else if (state == 2) {
                    menuItem.setIcon(getDrawable(R.drawable.ic_wangglb));
                    listView.setVisibility(View.VISIBLE);
                    wanggeView.setVisibility(View.GONE);
                    state = 1;
                }
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
