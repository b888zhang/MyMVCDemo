package com.example.zb.mymvcdemo.callback;

/**
 * @Description TODO(数据操作回调接口)
 * @author
 * @Date
 */
public interface LoginListener {
    void onBefore();

    void onSuccess(String str);

    void onFailed();
}
