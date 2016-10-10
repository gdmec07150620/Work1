package com.example.zsl.work1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class Work1 extends AppCompatActivity implements View.OnClickListener{


   private TextView tView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_work1);
        tView = new TextView(this);
        tView.setText("手动启动界面");
        setContentView(tView);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_VOLUME_UP:
            SetMessage("按下了音量大键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("按下了音量小键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_HOME:
                SetMessage("你按下了家键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("你按下了菜单键");
                break;
            default:
                SetMessage("你按下的键是"+keyCode);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_VOLUME_DOWN:
               SetMessage("你放开了音量小键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("你放开了音量大键");
                break;
            default:
                    SetMessage("你放开的键是"+keyCode);
                    break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        SetMessage("长时间按按钮");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        if(action==MotionEvent.ACTION_CANCEL||action==MotionEvent.ACTION_DOWN||action==MotionEvent.ACTION_MOVE){
            return false;
        }
        String x = String.valueOf(event.getX());
        String y = String.valueOf(event.getY());
        SetMessage("触点坐标：("+x+","+y+")");
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        SetMessage("按下返回键了");
        super.onBackPressed();
    }

    public void SetMessage(String str){
        String oldStr=tView.getText().toString();
        String newStr=oldStr+"\n"+str;
        tView.setText(newStr);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "按钮事件", Toast.LENGTH_LONG).show();
    }
}
