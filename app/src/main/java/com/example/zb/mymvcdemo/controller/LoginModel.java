package com.example.zb.mymvcdemo.controller;

import com.example.zb.mymvcdemo.callback.LoginListener;

/**
 * 关于用户数据操作接口)
 * Created by zb on 2019/4/25.
 */

public interface LoginModel {
    /**
     * (获取登录数据)
     * Created by zb on 2019/4/25.
     */
    void login(String admin, String pas,String url, LoginListener loginListener);

}
