package com.example.yk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yk.adapter.MyAdapter;
import com.example.yk.app.Image;
import com.example.yk.avtivity.BaseActivity;
import com.example.yk.bean.HomeBean;
import com.example.yk.presenter.Homepresenter;
import com.example.yk.view.IHomeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<Homepresenter> implements IHomeView {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.getData();
    }

    @Override
    public void createpresenter() {
        presenter = new Homepresenter(this);

    }

    @Override
    public void setbanner(List<HomeBean.RetBean.ListBean.ChildListBean> listbean) {
        ArrayList<String> blist=new ArrayList<>();
        for (int i = 0; i <listbean.size() ; i++) {
            blist.add(listbean.get(i).getPic());
        }
        banner.setImageLoader(new Image());
        banner.setImages(blist);
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initvp(List<HomeBean.RetBean.ListBean.ChildListBean> list) {
        LinearLayoutManager mar=new LinearLayoutManager(this);
        rv.setLayoutManager(mar);
        MyAdapter adapter = new MyAdapter(MainActivity.this, list);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
