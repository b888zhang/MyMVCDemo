package com.example.zb.mymvcdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.zb.mymvcdemo.callback.LoginListener;
import com.example.zb.mymvcdemo.controller.LoginModelImp;
import com.example.zb.mymvcdemo.utils.MyLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginListener{

    @BindView(R.id.bt_on)
    Button   mBtOn;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    LoginModelImp loginModelImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.bt_on)
    public void onViewClicked() {

        if (loginModelImp == null) {
            loginModelImp = new LoginModelImp();
        }
        String url="http://192.168.200.211:8081/BLPDAService.asmx/GetUserInfo";
        loginModelImp.login("admin","bolesoft",url,MainActivity.this);

    }
    private ProgressDialog dialog;
    @Override
    public void onBefore() {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }
        dialog.show();
    }

    @Override
    public void onSuccess(final String str) {
        MyLog.i("成功str-------------",str);
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvContent.setText(str);
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onFailed() {
        dialog.dismiss();
    }
}
