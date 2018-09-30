package com.andalus.abo_med7at.analyticalgeometry;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;

public class DrawingFragment extends Fragment implements View.OnTouchListener{

    private DrawingArea drawingArea;
    private float mScaleFactor = 1.0f;
    private ScaleGestureDetector mScaleGestureDetector;
    private float currentX,currentY;
    private float differenceX,differenceY;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(),new ScaleListener());
        drawingArea.setOnTouchListener(this);
        return drawingArea;
    }

    public void setDrawingArea(DrawingArea drawingArea) {
        this.drawingArea = drawingArea;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mScaleGestureDetector.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentX = motionEvent.getX();
                currentY = motionEvent.getY();
                differenceX = drawingArea.getX() - currentX;
                differenceY = drawingArea.getY() - currentY;
                break;
            case MotionEvent.ACTION_MOVE:
                drawingArea.setX(motionEvent.getX()+differenceX);
                drawingArea.setY(motionEvent.getY()+differenceY);
                break;

        }
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            drawingArea.setScaleX(mScaleFactor);
            drawingArea.setScaleY(mScaleFactor);
            return true;
        }
    }
}
