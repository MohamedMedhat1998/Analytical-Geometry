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
        switch (data.get(ConstantKeys.CURVE).toString()){
            case ConstantKeys.HOMO_PAIR:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"));
                break;
            case ConstantKeys.NON_HOMO_PAIR:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'n');
                break;
            case ConstantKeys.GENERAL:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'g');
                break;
            case ConstantKeys.CIRCLE:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("h"),data.getDouble("k"),data.getDouble("r"),'c');
                break;
            case ConstantKeys.X_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'p');
                break;
            case ConstantKeys.Y_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'y');
                break;
            case ConstantKeys.GENERAL_X_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'*');
                break;
            case ConstantKeys.GENERAL_Y_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'-');
                break;
            case ConstantKeys.STANDARD_ELLIPSE:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'e');
                break;
            case ConstantKeys.GENERAL_ELLIPSE:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),ConstantKeys.GENERAL_ELLIPSE);
                break;
            case ConstantKeys.GENERAL_HYPERBOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),ConstantKeys.GENERAL_HYPERBOLA);
                break;
            case ConstantKeys.X_HYPERBOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'h');
                break;
            case ConstantKeys.Y_HYPERBOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'H');
                break;
        }

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
