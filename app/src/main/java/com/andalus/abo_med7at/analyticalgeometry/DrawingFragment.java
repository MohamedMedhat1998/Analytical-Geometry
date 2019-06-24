package com.andalus.abo_med7at.analyticalgeometry;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

public class DrawingFragment extends Fragment implements View.OnTouchListener {

    private CoordinatePlane coordinatePlane;
    private float mScaleFactor = 1.0f;
    private ScaleGestureDetector mScaleGestureDetector;
    private float differenceX, differenceY;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        if (getArguments() != null && getContext() != null) {
            Shape shape = (Shape) getArguments().getSerializable(Constants.Keys.SHAPE);
            coordinatePlane = new CoordinatePlane(getContext());
            if (shape != null) {
                coordinatePlane.setShape(shape);
            }
        }
        coordinatePlane.setOnTouchListener(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (getActivity() != null) {
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        Toast.makeText(getContext(), R.string.pinch_to_zoom, Toast.LENGTH_LONG).show();
        return coordinatePlane;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float currentX = motionEvent.getX();
                float currentY = motionEvent.getY();
                differenceX = coordinatePlane.getX() - currentX;
                differenceY = coordinatePlane.getY() - currentY;
                break;
            case MotionEvent.ACTION_MOVE:
                coordinatePlane.setX(motionEvent.getX() + differenceX);
                coordinatePlane.setY(motionEvent.getY() + differenceY);
                break;

        }
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            if (mScaleFactor >= 1.0f && mScaleFactor <= 4.0f) {
                coordinatePlane.setScaleX(mScaleFactor);
                coordinatePlane.setScaleY(mScaleFactor);
            }
            if (mScaleFactor > 4.0f) {
                mScaleFactor = 4.0f;
            }
            if (mScaleFactor < 1.0f) {
                mScaleFactor = 1.0f;
            }
            return true;
        }
    }

    public static DrawingFragment newInstance() {
        return new DrawingFragment();
    }

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
    }
}
