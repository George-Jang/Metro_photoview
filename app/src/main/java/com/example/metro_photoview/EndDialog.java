package com.example.metro_photoview;

import android.app.Dialog;

import android.content.Context;

import android.os.Bundle;


import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class EndDialog extends Dialog implements View.OnClickListener{
    private Context mContext;
    private ImageView btn_station_in;
    private ImageView btn_center;
    private ImageView btn_cancel;

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
        btn_cancel = (ImageView) findViewById(R.id.txt5);

        btn_cancel.setOnClickListener(this);
        btn_center.setOnClickListener(this);

    }


    @Override

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt5:
                dismiss();
                break;

            case R.id.btn_center:
                //((MainActivity) mContext).finish();
                break;
        }
    }
}
