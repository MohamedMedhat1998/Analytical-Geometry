package com.andalus.abo_med7at.analyticalgeometry.ui.drawing_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.andalus.abo_med7at.analyticalgeometry.CoordinatePlane;
import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

import org.jetbrains.annotations.NotNull;

public class DrawingFragment extends Fragment implements View.OnTouchListener, DrawingFragmentContract.View {

    private CoordinatePlane coordinatePlane;
    private float mScaleFactor = 1.0f;
    private ScaleGestureDetector mScaleGestureDetector;
    private float differenceX, differenceY;

    private DrawingFragmentContract.Presenter presenter = new DrawingFragmentPresenter(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter.start();
        return coordinatePlane;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                differenceX = coordinatePlane.getX() - motionEvent.getRawX();
                differenceY = coordinatePlane.getY() - motionEvent.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                coordinatePlane.setX(motionEvent.getRawX() + differenceX);
                coordinatePlane.setY(motionEvent.getRawY() + differenceY);
                break;
        }
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    @Override
    public void createCoordinatePlane() {
        if (getArguments() != null && getContext() != null) {
            Shape shape = (Shape) getArguments().getSerializable(Constants.Keys.SHAPE);
            coordinatePlane = new CoordinatePlane(getContext());
            mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
            coordinatePlane.setOnTouchListener(this);
            if (shape != null) {
                coordinatePlane.setShape(shape);
            }
        }
    }

    @Override
    public void showMessage(@NotNull String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
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
