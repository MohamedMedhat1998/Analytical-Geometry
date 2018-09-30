package com.andalus.abo_med7at.analyticalgeometry;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Abo_Med7at on 18/04/2017.
 */

public class DrawingClass extends AppCompatActivity {
    DrawingArea d_a;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        switch (data.get("CURVE").toString()){
            case "homo-pair":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"));
                break;
            case "non-homo-pair":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'n');
                break;
            case "general":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'g');
                break;
            case "circle":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("h"),data.getDouble("k"),data.getDouble("r"),'c');
                break;
            case "parabola":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'p');
                break;
            case "yparabola":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'y');
                break;
            case "general_x_para":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'*');
                break;
            case "general_y_para":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'-');
                break;
            case "standard_ellipse":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'e');
                break;
            case "general_ellipse":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"));
                break;
            case "hyperbola":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'h');
                break;
            case "hyperbola2":
                d_a = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'H');
                break;
        }

        setContentView(R.layout.zoomable_draw_area);
        DrawingFragment drawingFragment = new DrawingFragment();
        drawingFragment.setDrawingArea(d_a);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.drawing_container,drawingFragment);
        fragmentTransaction.commit();

    }
}
