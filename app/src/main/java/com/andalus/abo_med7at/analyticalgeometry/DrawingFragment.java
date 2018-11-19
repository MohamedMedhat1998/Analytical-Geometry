package com.andalus.abo_med7at.analyticalgeometry;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class DrawingFragment extends Fragment implements View.OnTouchListener{

    private DrawingArea drawingArea;
    private float mScaleFactor = 1.0f;
    private ScaleGestureDetector mScaleGestureDetector;
    private float currentX,currentY;
    private float differenceX,differenceY;
    private float screenX,screenY;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(),new ScaleListener());
        drawingArea.setOnTouchListener(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenX = displayMetrics.heightPixels;
        screenY = displayMetrics.widthPixels;
        Log.d("DIMENS","Screen Area Height : " + displayMetrics.heightPixels);
        Log.d("DIMENS","Screen Width : " + displayMetrics.widthPixels);
        Toast.makeText(getContext(), R.string.pinch_to_zoom, Toast.LENGTH_LONG).show();
        return drawingArea;
    }

    public void setDrawingArea(DrawingArea drawingArea) {
        this.drawingArea = drawingArea;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
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
                float fx = motionEvent.getX()+differenceX, fy = motionEvent.getY()+differenceY;
                Log.d("DIMENS","NEW LOCATION X : " + fx);
                Log.d("DIMENS","NEW LOCATION Y : " + fy);
                break;

        }
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            Log.d("SCALE_FACTOR","BEFORE : " +mScaleFactor);
            if(mScaleFactor >= 1.0f && mScaleFactor <= 4.0f){
                drawingArea.setScaleX(mScaleFactor);
                drawingArea.setScaleY(mScaleFactor);
            }
            if(mScaleFactor > 4.0f){
                mScaleFactor = 4.0f;
            }
            if(mScaleFactor < 1.0f){
                mScaleFactor = 1.0f;
            }
            Log.d("SCALE_FACTOR","AFTER : " + mScaleFactor);
            return true;
        }
    }
}
