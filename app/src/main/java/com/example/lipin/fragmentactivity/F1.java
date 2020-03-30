package com.example.lipin.fragmentactivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import butterknife.BindView;

public class F1 extends Fragment {
    //Fragment不是context

    private TextView lottery;

    private  View view;//不讓遷換畫面重跑先創立一個view
    private  MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //因為切換到下個Fragment這段會在重跑,
        // 造成切換回來時,不會顯示原來給在這的隨機數的值
        //所以判斷如果是null的時候才給他跑這段
        if (view == null) {
            //拿取整個值
            view = inflater.inflate(R.layout.fragment_f1, container, false);

            Button test1 = view.findViewById(R.id.page1_test1);
            lottery = view.findViewById(R.id.page1_lottery);

            //因為是用ID來呼叫按鈕所以這樣寫
            //產生一個隨機數
            test1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showLottery();
                }
            });
            //第二顆按鈕
            view.findViewById(R.id.page1_test2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.changeTitle("brad123456");
                }
            });
        }
        return view;
    }
    //產生一個隨機數寫法
    public void showLottery(){
        lottery.setText(""+(int)(Math.random()*49+1));
    }

    //這裡的context指的是MainActivity
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //拿取context的值
        mainActivity = (MainActivity) context;
        mainActivity.text.setText("brad123");
    }
}
