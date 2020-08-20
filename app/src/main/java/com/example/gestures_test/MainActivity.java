package com.example.gestures_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    TextView single;
    TextView onLong;
    TextView onDouble;
    TextView onFling;
    TextView onDown;
    TextView onScrolling;
    TextView onShow;
    int onShowInt = 0;
    int singleClick = 0;
    int longClick = 0;
    int doubleClick = 0;
    int fling = 0;
    int scroll = 0;
    int down = 0;
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        single = (TextView) findViewById(R.id.singlePress);
        onLong = (TextView) findViewById(R.id.longPress);
        onDouble = (TextView) findViewById(R.id.doubleTap);
        onFling = (TextView) findViewById(R.id.onFling);
        onScrolling = (TextView) findViewById(R.id.onScrolling);
        onDown = (TextView) findViewById(R.id.onDown);
        onShow = (TextView) findViewById(R.id.onShow);
        this.gestureDetector = new GestureDetector(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        singleClick++;
        single.setText("onSingle TapConfirmed :"+singleClick);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        doubleClick++;
        onDouble.setText("onDouble Tap                  :"+doubleClick);
        System.out.println("Double");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        down++;
        onDown.setText("onDown                             :"+down);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        onShowInt++;
        onShow.setText("onShow                             :"+onShowInt);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        scroll++;
        onScrolling.setText("onScroll                             :"+scroll);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        longClick++;
        onLong.setText("OnLong Press                 :"+longClick);
        System.out.println("Long");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        fling++;
        onFling.setText("onFling                              :"+fling);
        System.out.println("Fling");
        return false;
    }
}