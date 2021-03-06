package com.andalus.abo_med7at.analyticalgeometry.ui.ellipse_activity;

import android.content.Intent;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andalus.abo_med7at.analyticalgeometry.factories.ToastFactory;
import com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity.DrawingActivity;
import com.andalus.abo_med7at.analyticalgeometry.R;
import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

import org.jetbrains.annotations.NotNull;

public class EllipseActivity extends AppCompatActivity implements EllipseActivityContract.View {
    private EditText a_e_g, c_e_g, d_e_g, e_e_g, f_e_g;
    //-------------------
    private EditText a_sqr_ellipse_standard_e, b_sqr_ellipse_standard_e;

    private EllipseActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse_act);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.ellipse));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initialize();
    }

    private void initialize() {
        a_e_g = findViewById(R.id.a_ell_e_g);
        c_e_g = findViewById(R.id.b_ell_e_g);
        d_e_g = findViewById(R.id.d_ell_e_g);
        e_e_g = findViewById(R.id.e_ell_e_g);
        f_e_g = findViewById(R.id.f_ell_e_g);
        Button draw_gen = findViewById(R.id.btn_draw_gen_ell);
        draw_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new GeneralEllipsePresenter(EllipseActivity.this);
                ((GeneralEllipsePresenter) presenter)
                        .validateAndSetValues(
                                a_e_g.getText().toString(),
                                c_e_g.getText().toString(),
                                d_e_g.getText().toString(),
                                e_e_g.getText().toString(),
                                f_e_g.getText().toString());
                presenter.onDrawPressed();
            }
        });
        //---------------------------------
        a_sqr_ellipse_standard_e = findViewById(R.id.a_sqrt_s_ellipse);
        b_sqr_ellipse_standard_e = findViewById(R.id.b_sqrt_s_ellipse);
        Button btn_draw_s_ellipse = findViewById(R.id.btn_draw_ellipse_standard);
        btn_draw_s_ellipse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new StandardEllipsePresenter(EllipseActivity.this);
                ((StandardEllipsePresenter) presenter)
                        .validateAndSetValues(
                                a_sqr_ellipse_standard_e.getText().toString(),
                                b_sqr_ellipse_standard_e.getText().toString());
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
        Intent i = new Intent(EllipseActivity.this, DrawingActivity.class);
        i.putExtra(Constants.Keys.SHAPE, shape);
        startActivity(i);
    }

    @Override
    public void showMessage(@NotNull String text) {
        ToastFactory.create(this,text).show();
    }
}