package com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.ui.drawing_fragment.DrawingFragment;
import com.andalus.abo_med7at.analyticalgeometry.R;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

/**
 * Created by Abo_Med7at on 18/04/2017.
 */

public class DrawingActivity extends AppCompatActivity implements DrawingActivityContract.View {

    private Bundle bundle;

    private final DrawingActivityContract.Presenter presenter = new DrawingActivityPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoomable_draw_area);
        presenter.start();
    }

    @Override
    public void receiveExtras() {
        Bundle data = getIntent().getExtras();
        if (data != null) {
            bundle = data;
        }
    }

    @Override
    public void loadDrawingFragment() {
        DrawingFragment drawingFragment = DrawingFragment.newInstance();
        drawingFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.drawing_container, drawingFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void setTitle() {
        Shape shape = (Shape) bundle.getSerializable(Constants.Keys.SHAPE);
        if (getSupportActionBar() != null) {
            try {
                getSupportActionBar().setTitle(shape.getFormula());
                getSupportActionBar().setSubtitle(shape.getCategory());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
