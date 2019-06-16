package com.andalus.abo_med7at.analyticalgeometry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

/**
 * Created by Abo_Med7at on 18/04/2017.
 */

public class DrawingClass extends AppCompatActivity {
    private static DrawingArea drawingArea;

    private Shape shape;
    private static NewDrawingArea newDrawingArea;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        shape = (Shape) data.getSerializable(Constants.Keys.SHAPE);
        newDrawingArea = new NewDrawingArea(getBaseContext());
        newDrawingArea.setShape(shape);

        /*switch (data.get(Constants.CURVE).toString()){
            case Constants.HOMO_PAIR:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"));
                break;
            case Constants.NON_HOMO_PAIR:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'n');
                break;
            case Constants.GENERAL:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("h"),data.getDouble("b"),data.getDouble("g"),data.getDouble("f"),data.getDouble("c"),'g');
                break;
            case Constants.CIRCLE:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("h"),data.getDouble("k"),data.getDouble("r"),'c');
                break;
            case Constants.X_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'p');
                break;
            case Constants.Y_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("k"),data.getDouble("a"),data.getDouble("h"),'y');
                break;
            case Constants.GENERAL_X_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'*');
                break;
            case Constants.GENERAL_Y_PARABOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),'-');
                break;
            case Constants.STANDARD_ELLIPSE:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'e');
                break;
            case Constants.GENERAL_ELLIPSE:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),Constants.GENERAL_ELLIPSE);
                break;
            case Constants.GENERAL_HYPERBOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),data.getDouble("d"),data.getDouble("e"),data.getDouble("f"),Constants.GENERAL_HYPERBOLA);
                break;
            case Constants.X_HYPERBOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'h');
                break;
            case Constants.Y_HYPERBOLA:
                drawingArea = new DrawingArea(getBaseContext(),data.getDouble("a"),data.getDouble("b"),'H');
                break;
        }*/

        /*setContentView(R.layout.zoomable_draw_area);
        DrawingFragment drawingFragment = DrawingFragment.newInstance(drawingArea);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.drawing_container,drawingFragment);
        fragmentTransaction.commit();*/

        setContentView(R.layout.zoomable_draw_area);
        DrawingFragment drawingFragment = DrawingFragment.newInstance(newDrawingArea);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.drawing_container,drawingFragment);
        fragmentTransaction.commit();

    }

    /*public static DrawingArea getNewDrawingArea(){
        return drawingArea;
    }*/
    public static NewDrawingArea getNewDrawingArea(){
        return newDrawingArea;
    }
}
