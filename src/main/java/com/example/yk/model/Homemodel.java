package com.example.yk.model;

import com.example.yk.RetrofitManager;
import com.example.yk.api.HomeAPI;
import com.example.yk.api.connet;

import okhttp3.OkHttpClient;

/**
 * Created by 李倩 on 2017/11/23.
 */

public class Homemodel implements IHomemodel{
    @Override
    public HomeAPI showgethome() {
        OkHttpClient client=new OkHttpClient.Builder()
                .build();
        HomeAPI api = RetrofitManager.getinstantce(connet.USERURL, client)
                .setcreate(HomeAPI.class);
        return api;
    }
  }
