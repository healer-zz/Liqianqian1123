package com.example.yk.avtivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.yk.presenter.Ipresenter;


/**
 * Created by 李倩 on 2017/11/23.
 */

public abstract class BaseActivity<T extends Ipresenter> extends AppCompatActivity{
    public  T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createpresenter();
    }
    public abstract  void createpresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detch();
        }
    }
}
