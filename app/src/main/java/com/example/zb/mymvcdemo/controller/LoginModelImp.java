package com.example.zb.mymvcdemo.controller;

import com.example.zb.mymvcdemo.callback.LoginListener;
import com.example.zb.mymvcdemo.utils.HttpUtils;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by zb on 2019/4/25.
 */

public class LoginModelImp implements LoginModel{
    @Override
    public void login(String admin, String pas, String url, final LoginListener loginListener) {

        if (loginListener == null) return;
        loginListener.onBefore();

        HashMap<String, String> param=new HashMap<>();
        param.put("code",admin);
        param.put("password",pas);
        HttpUtils.doPost(url, param, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                loginListener.onFailed();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                loginListener.onSuccess(response.body().string());
            }
        });
    }
}
