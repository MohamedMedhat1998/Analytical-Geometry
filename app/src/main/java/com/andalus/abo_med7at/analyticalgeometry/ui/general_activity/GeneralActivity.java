package com.andalus.abo_med7at.analyticalgeometry.ui.general_activity;

import android.content.Intent;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.andalus.abo_med7at.analyticalgeometry.ui.drawing_activity.DrawingActivity;
import com.andalus.abo_med7at.analyticalgeometry.R;
import com.andalus.abo_med7at.analyticalgeometry.models.Shape;
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;

import org.jetbrains.annotations.NotNull;

public class GeneralActivity extends AppCompatActivity implements GeneralActivityContract.View {
    private EditText a_val, h_val, b_val, g_val, f_val, c_val;

    private GeneralActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_act);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.general));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initialize();
    }

    private void initialize() {
        a_val = findViewById(R.id.general_a);
        h_val = findViewById(R.id.general_h);
        b_val = findViewById(R.id.general_b);
        g_val = findViewById(R.id.general_g);
        f_val = findViewById(R.id.general_f);
        c_val = findViewById(R.id.general_c);

        Button btn_draw_general = findViewById(R.id.general_btn_draw);
        btn_draw_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter = new GeneralShapePresenter(GeneralActivity.this);
                ((GeneralShapePresenter) presenter)
                        .validateAndSetValues(
                                a_val.getText().toString(),
                                h_val.getText().toString(),
                                b_val.getText().toString(),
                                g_val.getText().toString(),
                                f_val.getText().toString(),
                                c_val.getText().toString());
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
        Intent i = new Intent(GeneralActivity.this, DrawingActivity.class);
        i.putExtra(Constants.Keys.SHAPE, shape);
        startActivity(i);
    }

    @Override
    public void showMessage(@NotNull String text) {
        Toast toast = Toast.makeText(getBaseContext(), text, Toast.LENGTH_LONG);
        TextView v = toast.getView().findViewById(android.R.id.message);
        if (v != null) v.setGravity(Gravity.CENTER);
        toast.show();
    }
}
