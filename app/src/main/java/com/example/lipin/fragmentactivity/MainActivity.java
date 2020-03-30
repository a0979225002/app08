package com.example.lipin.fragmentactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;

    private FragmentManager fmgr;
    private F1 f1;
    private F2 f2;
    private F3 f3;

    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //實作fragment出來
        f1 = new F1();
        f2 = new F2();
        f3 = new F3();

        //取得片段,這個FragmentManager事件,每個activity都會帶有
        //所以不是new出來,而是get出來
        fmgr = getSupportFragmentManager();


        //開始交易
        FragmentTransaction transaction = fmgr.beginTransaction();

        //將f1這個fragment塞進container這個FrameLayout內
        //目前首頁是f1
        transaction.add(R.id.container, f1);

        //完成交易
        transaction.commit();
    }


    public void gotopage1(View view) {
        //開始交易
        FragmentTransaction transaction = fmgr.beginTransaction();
        //將f1這個fragment塞進container這個FrameLayout內
        transaction.replace(R.id.container, f1);
        //完成交易
        transaction.commit();
    }

    public void gotopage2(View view) {
        //開始交易
        FragmentTransaction transaction = fmgr.beginTransaction();
        //將f1這個fragment塞進container這個FrameLayout內
        transaction.replace(R.id.container, f2);
        //完成交易
        transaction.commit();
    }

    public void gotopage3(View view) {
        //開始交易
        FragmentTransaction transaction = fmgr.beginTransaction();
        //將f1這個fragment塞進container這個FrameLayout內
        transaction.replace(R.id.container, f3);
        //完成交易
        transaction.commit();
    }

    //點擊標題可以更改隨機數
    public void test1(View view) {
        f1.showLottery();
    }
    //點擊按鈕更改標題方法
    public void changeTitle(String newTitle){
        text.setText(newTitle);
    }

    //這為fragment_f1內加入的button
    //不過不能寫在F1內,他還是算MainActivity內的資源
    //因為不好維護所以拿掉
    //改寫為使用id來抓
//    public  void test1(View view){
//        Log.v("brad","F1");
//    }
}
