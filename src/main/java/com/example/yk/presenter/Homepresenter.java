package com.example.yk.presenter;

import android.util.Log;

import com.example.yk.bean.HomeBean;
import com.example.yk.model.Homemodel;
import com.example.yk.view.IHomeView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李倩 on 2017/11/23.
 */

public class Homepresenter implements Ipresenter<IHomeView> {
    IHomeView view;
    SoftReference<IHomeView> softReference;
    Homemodel model;
    List<HomeBean.RetBean.ListBean.ChildListBean> list=new ArrayList<>();
    List<HomeBean.RetBean.ListBean.ChildListBean> list2=new ArrayList<>();
    public Homepresenter(IHomeView view) {
        attch(view);
        model=new Homemodel();
    }

    public void getData(){
        model.showgethome()
                .getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("zzzzzz", "onError: "+e);
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        for (int i = 0; i < homeBean.getRet().getList().get(0).getChildList().size(); i++) {
                            list.add(homeBean.getRet().getList().get(0).getChildList().get(i));

                        }
                        for (int i = 0; i < homeBean.getRet().getList().get(3).getChildList().size(); i++) {
                            list2.add(homeBean.getRet().getList().get(3).getChildList().get(i));

                        }

                        softReference.get().setbanner(list);
                        softReference.get().initvp(list2);
                    }
                });
    }

    @Override
    public void attch(IHomeView view) {
        softReference=new SoftReference<IHomeView>(view);
    }

    @Override
    public void detch() {
        softReference.clear();

    }
}
