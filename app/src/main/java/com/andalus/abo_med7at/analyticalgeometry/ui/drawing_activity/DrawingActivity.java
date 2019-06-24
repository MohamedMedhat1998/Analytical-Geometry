package com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.andalus.abo_med7at.analyticalgeometry.DrawingFragment;
import com.andalus.abo_med7at.analyticalgeometry.R;

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
        //TODO set the title of the Activity to the formula of the shape
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
}
