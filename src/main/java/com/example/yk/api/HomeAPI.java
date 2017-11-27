package com.example.yk.api;

import com.example.yk.bean.HomeBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 李倩 on 2017/11/23.
 */

public interface HomeAPI {
    @GET("homePageApi/homePage.do")
    Observable<HomeBean> getHome();


}
