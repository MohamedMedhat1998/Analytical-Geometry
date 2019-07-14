package com.andalus.abo_med7at.analyticalgeometry.ui.parabola_activity;

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

public class ParabolaActivity extends AppCompatActivity implements ParabolaActivityContract.View {

    private EditText k_x_e, a_x_e, h_x_e;
    //---------------------------------
    private EditText h_y_e, b_y_e, k_y_e;
    //------------------general//x----------
    private EditText d_x_e, e_x_e, f_x_e;
    //-----------------general//y-----------
    private EditText d_y_e, e_y_e, f_y_e;

    private ParabolaActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parabola_act);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.parabola));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initialize();
    }

    private void initialize() {
        d_y_e = findViewById(R.id.D_y_p_gen);
        e_y_e = findViewById(R.id.E_y_p_gen);
        f_y_e = findViewById(R.id.F_y_p_gen);
        Button btn_draw_gen_y = findViewById(R.id.btn_draw_Gen_y_p);
        btn_draw_gen_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new GeneralYParabolaPresenter(ParabolaActivity.this);
                ((GeneralYParabolaPresenter) presenter)
                        .validateAndSetValues(d_y_e.getText().toString(),
                                e_y_e.getText().toString(),
                                f_y_e.getText().toString());
                presenter.onDrawPressed();
            }
        });
        //-------------------------------------------
        d_x_e = findViewById(R.id.D_x_p_gen);
        e_x_e = findViewById(R.id.E_x_p_gen);
        f_x_e = findViewById(R.id.F_x_p_gen);
        Button btn_draw_gen_x = findViewById(R.id.btn_draw_Gen_x_p);
        btn_draw_gen_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new GeneralXParabolaPresenter(ParabolaActivity.this);
                ((GeneralXParabolaPresenter) presenter)
                        .validateAndSetValues(d_x_e.getText().toString(),
                                e_x_e.getText().toString(),
                                f_x_e.getText().toString());
                presenter.onDrawPressed();
            }
        });
        //------------------------------
        h_y_e = findViewById(R.id.h_para_e_y);
        b_y_e = findViewById(R.id.a_para_e_y);
        k_y_e = findViewById(R.id.k_para_e_y);
        Button btn_draw_y_para = findViewById(R.id.btn_draw_para_y);
        btn_draw_y_para.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new StandardYParabolaPresenter(ParabolaActivity.this);
                ((StandardYParabolaPresenter) presenter)
                        .validateAndSetValues(
                                h_y_e.getText().toString(),
                                b_y_e.getText().toString(),
                                k_y_e.getText().toString());
                presenter.onDrawPressed();
            }
        });
        //-------------------------------
        k_x_e = findViewById(R.id.k_para_e);
        a_x_e = findViewById(R.id.a_para_e);
        h_x_e = findViewById(R.id.h_para_e);
        Button btn_draw_x_para = findViewById(R.id.btn_draw_para_stand_y_sqr);
        btn_draw_x_para.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new StandardXParabolaPresenter(ParabolaActivity.this);
                ((StandardXParabolaPresenter) presenter)
                        .validateAndSetValues(
                                k_x_e.getText().toString(),
                                a_x_e.getText().toString(),
                                h_x_e.getText().toString());
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
        Intent i = new Intent(ParabolaActivity.this, DrawingActivity.class);
        i.putExtra(Constants.Keys.SHAPE, shape);
        startActivity(i);
    }

    @Override
    public void showMessage(@NotNull String text) {
        ToastFactory.create(this,text).show();
    }
}