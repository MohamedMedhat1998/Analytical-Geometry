package com.andalus.abo_med7at.analyticalgeometry.ui.pair_activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.andalus.abo_med7at.analyticalgeometry.factories.ToastFactory;
import com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity.DrawingActivity;
import com.andalus.abo_med7at.analyticalgeometry.R;
import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

import org.jetbrains.annotations.NotNull;

public class PairActivity extends AppCompatActivity implements PairActivityContract.View {

    private EditText a_val, h_val, b_val, a_val_non, h_val_non, b_val_non, g_val_non, f_val_non, c_val_non;
    private PairActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_act);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.pair_of_lines));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initialize();
    }

    private void initialize() {
        a_val = findViewById(R.id.a_edit);
        h_val = findViewById(R.id.h2_edit);
        b_val = findViewById(R.id.b_edit);
        //non
        a_val_non = findViewById(R.id.a_edit_non);
        h_val_non = findViewById(R.id.h2_edit_non);
        b_val_non = findViewById(R.id.b_edit_non);
        g_val_non = findViewById(R.id.g2_edit_non);
        f_val_non = findViewById(R.id.f2_edit_non);
        c_val_non = findViewById(R.id.c_edit_non);
        //------------
        Button btn_draw = findViewById(R.id.btn_draw);
        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new HomogeneousPairPresenter(PairActivity.this);
                ((HomogeneousPairPresenter) presenter)
                        .validateAndSetValues(
                                a_val.getText().toString(),
                                h_val.getText().toString(),
                                b_val.getText().toString());
                presenter.onDrawPressed();

            }
        });
        Button btn_draw_non = findViewById(R.id.btn_draw2);
        btn_draw_non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new GeneralPairPresenter(PairActivity.this);
                ((GeneralPairPresenter) presenter)
                        .validateAndSetValues(
                                a_val_non.getText().toString(),
                                h_val_non.getText().toString(),
                                b_val_non.getText().toString(),
                                g_val_non.getText().toString(),
                                f_val_non.getText().toString(),
                                c_val_non.getText().toString());
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
        Intent i = new Intent(PairActivity.this, DrawingActivity.class);
        i.putExtra(Constants.Keys.SHAPE, shape);
        startActivity(i);
    }

    @Override
    public void showMessage(@NotNull String text) {
        ToastFactory.create(this,text).show();
    }
}