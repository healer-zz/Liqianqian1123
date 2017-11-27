package com.example.yk.view;


import com.example.yk.bean.HomeBean;

import java.util.List;

/**
 * Created by 李倩 on 2017/11/23.
 */

public interface IHomeView {
    public void setbanner(List<HomeBean.RetBean.ListBean.ChildListBean> listbean);
    public void initvp(List<HomeBean.RetBean.ListBean.ChildListBean> list);
}
