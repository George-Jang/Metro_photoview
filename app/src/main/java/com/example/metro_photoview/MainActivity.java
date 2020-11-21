package com.example.metro_photoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

import android.view.View;

import java.util.ArrayList;
import java.util.List;


class Station_info{

    public String msg;


}




public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;

    private Button btn_end;
    private EndDialog mEndDialog;
    public Station_info[] st;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btn_end = (Button) findViewById(R.id.btn_finish);
        //btn_end.setOnClickListener(this);
        mEndDialog = new EndDialog(this);
        //Station_info[] st = new Station_info[3];

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.metromain);
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(photoView);
        mAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                String msg = "터치 영역 : " +x+" / " +y;

                Toast. makeText(MainActivity. this, msg, Toast.LENGTH_SHORT ).show();
                Station_Click(x,y);

            }
        });

    }

    public void onClick(View v) {

        /*switch (v.getId()) {
            case R.id.btn_finish:
                mEndDialog = new EndDialog(this);
                mEndDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                mEndDialog.setCancelable(false);
                mEndDialog.show();
                break;
        }*/
    }

    public void Station_Click(float x, float y){

        Station_info[] st = new Station_info[111];
        int s_num = 0;

        for(int i=0; i<111; i++) {
            st[i] = new Station_info();
        }
        s_num = Check_station(x,y);

        if(s_num!=0 && s_num!=112) {
            //Toast.makeText(MainActivity.this, "" + s_num, Toast.LENGTH_SHORT).show();
            mEndDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            mEndDialog.setCancelable(false);
            mEndDialog.show();
        }

        // 함수를 따로 만들어 역을 구별하게 함.
        // 출발지, 도착지 함수 구현(역마다 다른 플래그) count 값을 두어 count==2가 될 시 다익스트라 실행

    }

    public int Check_station(float x, float y){ // 역 체크해주는 함수


        if( 0.07283145<x && x< 0.08737977 && 0.52039397<y && y<0.5381478){return 1;} //101
        else if( 0.07283145<x && x< 0.08737977 && 0.5901217<y && y<0.6099802){return 2;} //102
        else if( 0.07283145<x && x< 0.08737977 && 0.65645707<y && y<0.67645707){return 3;} //103
        else if( 0.07283145<x && x< 0.08737977 && 0.73168176<y && y<0.75168176){return 4;} //104
        else if( 0.07283145<x && x< 0.08737977 && 0.29147115<y && y<0.31090873){return 5;} //105
        else if( 0.11850992<x && x< 0.13850992 && 0.876996<y && y<0.896996){return 6;} //106
        else if( 0.16642024<x && x< 0.18642024 && 0.876996<y && y<0.896996){return 7;} //107
        else if( 0.21673355<x && x< 0.43787116 && 0.876996<y && y<0.896996){return 8;} //108
        else if( 0.26101977<x && x< 0.28101977 && 0.876996<y && y<0.896996){return 9;} //109
        else if( 0.32089525<x && x< 0.34089525 && 0.876996<y && y<0.896996){return 10;} //110
        else if( 0.3670387<x && x< 0.3870387 && 0.876996<y && y<0.896996){return 11;} //111
        else if( 0.4207376<x && x< 0.4407376 && 0.876996<y && y<0.896996){return 12;} //112
        else if( 0.47442818<x && x< 0.49442818 && 0.876996<y && y<0.896996){return 13;} //113
        else if( 0.52161237<x && x< 0.54161237 && 0.80173993<y && y<0.82173993){return 14;} //114
        else if( 0.53079206<x && x< 0.55079206 && 0.732826<y && y<0.752826){return 15;} //115
        else if( 0.528<x && x< 0.548 && 0.618<y && y<0.638){return 16;} //116
        else if( 0.52863544<x && x< 0.54863544 && 0.55575824<y && y<0.57575824){return 17;} //117
        else if( 0.5150551<x && x< 0.5350551 && 0.46112075<y && y<0.48112075){return 18;} //118
        else if( 0.4199929<x && x< 0.4399929 && 0.4340567<y && y<0.4540567){return 19;} //119
        else if( 0.37524396<x && x< 0.39524396 && 0.4340567<y && y<0.4540567){return 20;} //120
        else if( 0.32522358<x && x< 0.34522358 && 0.43323958<y && y<0.45323958){return 21;} //121
        else if( 0.263<x && x< 0.283 && 0.434<y && y<0.454){return 22;} //122
        else if( 0.166<x && x< 0.186 && 0.432<y && y<0.452){return 23;} //123
        else if( 0.072<x && x< 0.092 && 0.399<y && y<0.419){return 24;} //201
        else if( 0.072<x && x< 0.092 && 0.291<y && y<0.311){return 25;} //202
        else if( 0.072<x && x< 0.092 && 0.215<y && y<0.235){return 26;} //203
        else if( 0.072<x && x< 0.092 && 0.144<y && y<0.164){return 27;} //204
        else if( 0.072<x && x< 0.092 && 0.065<y && y<0.085){return 28;} //205
        else if( 0.117<x && x< 0.137 && 0.065<y && y<0.085){return 29;} //206
        else if( 0.166<x && x< 0.186 && 0.065<y && y<0.085){return 30;} //207
        else if( 0.213<x && x< 0.233 && 0.065<y && y<0.085){return 31;} //208
        else if( 0.262<x && x< 0.282 && 0.065<y && y<0.085){return 32;} //209
        else if( 0.344<x && x< 0.364 && 0.065<y && y<0.085){return 33;} //210
        else if( 0.420<x && x< 0.440 && 0.065<y && y<0.085){return 34;} //211
        else if( 0.493<x && x< 0.513 && 0.065<y && y<0.085){return 35;} //212
        else if( 0.572<x && x< 0.592 && 0.065<y && y<0.085){return 36;} //213
        else if( 0.642<x && x< 0.662 && 0.065<y && y<0.085){return 37;} //214
        else if( 0.698<x && x< 0.718 && 0.065<y && y<0.085){return 38;} //215
        else if( 0.747<x && x< 0.767 && 0.065<y && y<0.085){return 39;} //216
        else if( 0.842<x && x< 0.862 && 0.065<y && y<0.085){return 40;} //217
        else if( 0.167<x && x< 0.190 && 0.145<y && y<0.165){return 41;} //301
        else if( 0.167<x && x< 0.190 && 0.215<y && y<0.235){return 42;} //302
        else if( 0.167<x && x< 0.190 && 0.293<y && y<0.313){return 43;} //303
        else if( 0.167<x && x< 0.190 && 0.363<y && y<0.383){return 44;} //304
        else if( 0.167<x && x< 0.190 && 0.517<y && y<0.537){return 45;} //305
        else if( 0.167<x && x< 0.190 && 0.62<y && y<0.64){return 46;} //306
        else if( 0.167<x && x< 0.190 && 0.731<y && y<0.751){return 47;} //307
        else if( 0.167<x && x< 0.190 && 0.803<y && y<0.823){return 48;} //308
        else if( 0.124<x && x< 0.144 && 0.733<y && y<0.753){return 49;} //401
        else if( 0.22<x && x< 0.24 && 0.733<y && y<0.753){return 50;} //402
        else if( 0.261<x && x< 0.281 && 0.733<y && y<0.753){return 51;} //403
        else if( 0.323<x && x< 0.343 && 0.733<y && y<0.753){return 52;} //404
        else if( 0.371<x && x< 0.391 && 0.733<y && y<0.753){return 53;} //405
        else if( 0.421<x && x< 0.441 && 0.733<y && y<0.753){return 54;} //406
        else if( 0.475<x && x< 0.495 && 0.733<y && y<0.753){return 55;} //407
        else if( 0.592<x && x< 0.612 && 0.733<y && y<0.753){return 56;} //408
        else if( 0.643<x && x< 0.663 && 0.733<y && y<0.753){return 57;} //409
        else if( 0.697<x && x< 0.717 && 0.733<y && y<0.753){return 58;} //410
        else if( 0.747<x && x< 0.767 && 0.733<y && y<0.753){return 59;} //411
        else if( 0.747<x && x< 0.767 && 0.619<y && y<0.639){return 60;} //412
        else if( 0.747<x && x< 0.767 && 0.529<y && y<0.549){return 61;} //413
        else if( 0.747<x && x< 0.767 && 0.441<y && y<0.461){return 62;} //414
        else if( 0.747<x && x< 0.767 && 0.363<y && y<0.383){return 63;} //415
        else if( 0.747<x && x< 0.767 && 0.293<y && y<0.313){return 64;} //416
        else if( 0.747<x && x< 0.767 && 0.153<y && y<0.173){return 65;} //417
        else if( 0.261<x && x< 0.281 && 0.145<y && y<0.165){return 66;} //501
        else if( 0.261<x && x< 0.281 && 0.215<y && y<0.235){return 67;} //502
        else if( 0.261<x && x< 0.281 && 0.293<y && y<0.313){return 68;} //503
        else if( 0.261<x && x< 0.281 && 0.363<y && y<0.383){return 69;} //504
        else if( 0.261<x && x< 0.281 && 0.517<y && y<0.537){return 70;} //505
        else if( 0.261<x && x< 0.281 && 0.62<y && y<0.64){return 71;} //506
        else if( 0.261<x && x< 0.281 && 0.803<y && y<0.823){return 72;} //507
        else if( 0.325<x && x< 0.345 && 0.293<y && y<0.313){return 73;} //601
        else if( 0.325<x && x< 0.345 && 0.363<y && y<0.383){return 74;} //602
        else if( 0.325<x && x< 0.345 && 0.517<y && y<0.537){return 75;} //603
        else if( 0.365<x && x< 0.385 && 0.615<y && y<0.635){return 76;} //604
        else if( 0.421<x && x< 0.441 && 0.619<y && y<0.639){return 77;} //605
        else if( 0.478<x && x< 0.498 && 0.619<y && y<0.639){return 78;} //606
        else if( 0.592<x && x< 0.612 && 0.619<y && y<0.639){return 79;} //607
        else if( 0.644<x && x< 0.664 && 0.619<y && y<0.639){return 80;} //608
        else if( 0.695<x && x< 0.715 && 0.619<y && y<0.639){return 81;} //609
        else if( 0.816<x && x< 0.836 && 0.609<y && y<0.629){return 82;} //610
        else if( 0.844<x && x< 0.864 && 0.541<y && y<0.561){return 83;} //611
        else if( 0.844<x && x< 0.864 && 0.452<y && y<0.472){return 84;} //612
        else if( 0.844<x && x< 0.864 && 0.372<y && y<0.392){return 85;} //613
        else if( 0.844<x && x< 0.864 && 0.293<y && y<0.313){return 86;} //614
        else if( 0.844<x && x< 0.864 && 0.212<y && y<0.232){return 87;} //615
        else if( 0.797<x && x< 0.817 && 0.153<y && y<0.173){return 88;} //616
        else if( 0.697<x && x< 0.717 && 0.153<y && y<0.173){return 89;} //617
        else if( 0.641<x && x< 0.661 && 0.153<y && y<0.173){return 90;} //618
        else if( 0.575<x && x< 0.595 && 0.153<y && y<0.173){return 91;} //619
        else if( 0.502<x && x< 0.522 && 0.153<y && y<0.173){return 92;} //620
        else if( 0.422<x && x< 0.442 && 0.153<y && y<0.173){return 93;} //621
        else if( 0.347<x && x< 0.367 && 0.168<y && y<0.188){return 94;} //622
        else if( 0.376<x && x< 0.396 && 0.293<y && y<0.313){return 95;} //701
        else if( 0.421<x && x< 0.441 && 0.293<y && y<0.313){return 96;} //702
        else if( 0.502<x && x< 0.522 && 0.293<y && y<0.313){return 97;} //703
        else if( 0.573<x && x< 0.593 && 0.293<y && y<0.313){return 98;} //704
        else if( 0.643<x && x< 0.663 && 0.293<y && y<0.313){return 99;} //705
        else if( 0.693<x && x< 0.713 && 0.293<y && y<0.313){return 100;} //706
        else if( 0.792<x && x< 0.812 && 0.293<y && y<0.313){return 101;} //707
        else if( 0.567<x && x< 0.587 && 0.875<y && y<0.895){return 102;} //801
        else if( 0.643<x && x< 0.663 && 0.875<y && y<0.895){return 103;} //802
        else if( 0.643<x && x< 0.663 && 0.802<y && y<0.822){return 104;} //803
        else if( 0.643<x && x< 0.663 && 0.529<y && y<0.549){return 105;} //804
        else if( 0.643<x && x< 0.663 && 0.439<y && y<0.459){return 106;} //805
        else if( 0.643<x && x< 0.663 && 0.361<y && y<0.381){return 107;} //806
        else if( 0.421<x && x< 0.441 && 0.801<y && y<0.821){return 108;} //901
        else if( 0.421<x && x< 0.441 && 0.517<y && y<0.537){return 109;} //902
        else if( 0.421<x && x< 0.441 && 0.36<y && y<0.38){return 110;} //903
        else if( 0.421<x && x< 0.441 && 0.214<y && y<0.234){return 111;} //904

        else{ return 112; }

    }

}