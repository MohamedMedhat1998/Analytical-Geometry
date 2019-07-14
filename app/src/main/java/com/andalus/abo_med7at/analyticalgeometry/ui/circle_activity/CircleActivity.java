package com.andalus.abo_med7at.analyticalgeometry.ui.circle_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.andalus.abo_med7at.analyticalgeometry.R;
import com.andalus.abo_med7at.analyticalgeometry.factories.ToastFactory;
import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity.DrawingActivity;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

import org.jetbrains.annotations.NotNull;

public class CircleActivity extends AppCompatActivity implements CircleActivityContract.View {

    private EditText etHStandardCircle, etKStandardCircle, etRStandardCircle;
    private EditText etAGeneralCircle, etBGeneralCircle, etGGeneralCircle, etFGeneralCircle,
            etCGeneralCircle;
    private EditText etX1DiameterCircle, etX2DiameterCircle, etY1DiameterCircle, etY2DiameterCircle;

    private CircleActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_act);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.circle));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initialize();
    }

    private void initialize() {

        etHStandardCircle = findViewById(R.id.edit_h_c);
        etKStandardCircle = findViewById(R.id.edit_k_c);
        etRStandardCircle = findViewById(R.id.edit_r_c);

        etAGeneralCircle = findViewById(R.id.a_edit_c);
        etBGeneralCircle = findViewById(R.id.b_edit_c);

        etGGeneralCircle = findViewById(R.id.g2_edit_c);
        etFGeneralCircle = findViewById(R.id.f2_edit_c);
        etCGeneralCircle = findViewById(R.id.c_edit_c);

        etX1DiameterCircle = findViewById(R.id.x1_e);
        etX2DiameterCircle = findViewById(R.id.x2_e);
        etY1DiameterCircle = findViewById(R.id.y1_e);
        etY2DiameterCircle = findViewById(R.id.y2_e);

        Button btn_draw_standard = findViewById(R.id.btn_draw_standard_circle);
        btn_draw_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new StandardCirclePresenter(CircleActivity.this);
                ((StandardCirclePresenter) presenter).
                        validateAndSetValues(etHStandardCircle.getText().toString(),
                                etKStandardCircle.getText().toString(),
                                etRStandardCircle.getText().toString());
                presenter.onDrawPressed();
            }
        });

        Button btn_draw_general = findViewById(R.id.btn_draw_general_c);
        btn_draw_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new GeneralCirclePresenter(CircleActivity.this);
                ((GeneralCirclePresenter) presenter)
                        .validateAndSetValues(etAGeneralCircle.getText().toString(),
                                etBGeneralCircle.getText().toString(),
                                etGGeneralCircle.getText().toString(),
                                etFGeneralCircle.getText().toString(),
                                etCGeneralCircle.getText().toString());
                presenter.onDrawPressed();
            }
        });

        Button draw_with_ends = findViewById(R.id.btn_draw_with_ends);
        draw_with_ends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new DiameterCirclePresenter(CircleActivity.this);
                ((DiameterCirclePresenter) presenter)
                        .validateAndSetValues(
                                etX1DiameterCircle.getText().toString(),
                                etX2DiameterCircle.getText().toString(),
                                etY1DiameterCircle.getText().toString(),
                                etY2DiameterCircle.getText().toString());
                presenter.onDrawPressed();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void navigateToDrawingActivity(@NotNull Shape shape) {
        Intent i = new Intent(CircleActivity.this, DrawingActivity.class);
        i.putExtra(Constants.Keys.SHAPE, shape);
        startActivity(i);
    }

    @Override
    public void showMessage(@NotNull String text) {
        ToastFactory.create(this,text).show();
    }
}