package com.andalus.abo_med7at.analyticalgeometry.ui.hyperbola_activity;

import android.content.Intent;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity.DrawingActivity;
import com.andalus.abo_med7at.analyticalgeometry.R;
import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

import org.jetbrains.annotations.NotNull;

public class HyperbolaActivity extends AppCompatActivity implements HyperbolaActivityContract.View {
    private EditText a_e_g, b_e_g, d_e_g, e_e_g, f_e_g;
    //----------------------------------------
    private EditText a_e2, b_e2;
    //-----------------------------------------------
    private EditText a_e, b_e;

    private HyperbolaActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyperbola_act);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.hyperbola));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initialize();
    }

    private void initialize() {
        a_e_g = findViewById(R.id.a_ell_e_g);
        b_e_g = findViewById(R.id.b_ell_e_g);
        d_e_g = findViewById(R.id.d_ell_e_g);
        e_e_g = findViewById(R.id.e_ell_e_g);
        f_e_g = findViewById(R.id.f_ell_e_g);
        Button draw_gen = findViewById(R.id.btn_draw_gen_ell);
        draw_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new GeneralHyperbolaPresenter(HyperbolaActivity.this);
                ((GeneralHyperbolaPresenter) presenter)
                        .validateAndSetValues(
                                a_e_g.getText().toString(),
                                b_e_g.getText().toString(),
                                d_e_g.getText().toString(),
                                e_e_g.getText().toString(),
                                f_e_g.getText().toString());
                presenter.onDrawPressed();
            }
        });
        //------------------------------
        a_e2 = findViewById(R.id.a_hyper2);
        b_e2 = findViewById(R.id.b_hyper2);
        Button draw_hyper2 = findViewById(R.id.btn_draw_hyper2);
        draw_hyper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new StandardYHyperbolaPresenter(HyperbolaActivity.this);
                ((StandardYHyperbolaPresenter) presenter)
                        .validateAndSetValues(
                                a_e2.getText().toString(),
                                b_e2.getText().toString());
                presenter.onDrawPressed();
            }
        });
        //-------------------------------------
        a_e = findViewById(R.id.a_hyper);
        b_e = findViewById(R.id.b_hyper);
        Button draw_hyper = findViewById(R.id.btn_draw_hyper);
        draw_hyper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new StandardXHyperbolaPresenter(HyperbolaActivity.this);
                ((StandardXHyperbolaPresenter) presenter)
                        .validateAndSetValues(
                                a_e.getText().toString(),
                                b_e.getText().toString());
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
        Intent i = new Intent(HyperbolaActivity.this, DrawingActivity.class);
        i.putExtra(Constants.Keys.SHAPE, shape);
        startActivity(i);
    }

    @Override
    public void showMessage(@NotNull String text) {
        Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG).show();
    }
}
