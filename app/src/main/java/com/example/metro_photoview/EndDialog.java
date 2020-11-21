package com.example.metro_photoview;

import android.app.Dialog;

import android.content.Context;

import android.os.Bundle;


import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class EndDialog extends Dialog implements View.OnClickListener{ //도넛모양의 레이아웃입니다.

    private Popup_dijkstra dijk;

    private Context mContext;
    private ImageView btn_station_in;
    private ImageView btn_center;
    private ImageView btn_cancel;
    private ImageView btn_depart;
    private ImageView btn_dest;
    public int depart_count=0;
    public int dest_count=0;
    private StringBuilder sb;
    private String route="";
    String depart,dest;
    int station;

    public EndDialog(@NonNull MainActivity context) {
        super(context);
        mContext = context;
    }



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_end);

        btn_station_in = (ImageView) findViewById(R.id.btn_station_in);
        btn_center = (ImageView) findViewById(R.id.btn_center);
        btn_cancel = (ImageView) findViewById(R.id.btn_cancel);
        btn_depart = (ImageView) findViewById(R.id.btn_depart);
        btn_dest = (ImageView) findViewById(R.id.btn_dest);

        btn_cancel.setOnClickListener(this);
        btn_center.setOnClickListener(this);
        btn_dest.setOnClickListener(this);
        btn_depart.setOnClickListener(this);

    }

    public void setStation(String a, String b){
        depart = a;
        dest = b;
    }


    @Override

    public void onClick(View v) { // 여기에서 클릭 이벤트 작업하세요

        switch (v.getId()) {
            case R.id.btn_cancel:
                dismiss();
                break;

            case R.id.btn_depart:

                depart_count ++;
                dismiss();
                break;

            case R.id.btn_dest:

                dest_count ++;
                if(depart_count==1 && dest_count==1){
                    depart_count=0;
                    dest_count=0;

                    //팝업호출
                    dijk = new Popup_dijkstra(this.getContext());
                    dijk.setStation(depart,dest);
                    dijk.setCancelable(false);
                    dijk.show();

                    //출발지,도착지,경로 초기화
                    depart = "";
                    dest = "";
                    route = "";
                }
                //출발지 두번 클릭했을 때 작동 안되는 문제 있음

                dismiss();
                break;
        }
    }
}
