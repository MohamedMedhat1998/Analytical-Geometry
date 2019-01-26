package com.andalus.abo_med7at.analyticalgeometry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Abo_Med7at on 18/04/2017.
 */

public class DrawingClass extends AppCompatActivity {
    private static DrawingArea drawingArea;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        switch (data.get("CURVE").toString()){
            case "homo-pair":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"));
                break;
            case "non-homo-pair":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'n');
                break;
            case "general":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'g');
                break;
            case "circle":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("h"),data.getDouble("k"),data.getDouble("r"),'c');
                break;
            case "parabola":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'p');
                break;
            case "yparabola":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'y');
                break;
            case "general_x_para":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'*');
                break;
            case "general_y_para":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'-');
                break;
            case "standard_ellipse":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'e');
                break;
            case "general_ellipse":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"));
                break;
            //Probably I should have replaced "hyperbola" with "xHyperbola"
            case "hyperbola":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'h');
                break;
            //Probably I should have replaced "hyperbola2" with "yHyperbola"
            case "hyperbola2":
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'H');
                break;
        }
        Log.d("TRACING",data.get("CURVE").toString());

        setContentView(R.layout.zoomable_draw_area);
        DrawingFragment drawingFragment = DrawingFragment.newInstance(drawingArea);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.drawing_container,drawingFragment);
        fragmentTransaction.commit();

    }

    public static DrawingArea getDrawingArea(){
        return drawingArea;
    }
}
