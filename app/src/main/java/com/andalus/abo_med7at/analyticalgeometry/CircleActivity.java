package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CircleActivity extends AppCompatActivity {
    private double h,k,r;
    private double x1,y1,x2,y2;
    private double a,b,g,f,c;
    private EditText e_h , e_k , e_r;
    private EditText x1_e,x2_e,y1_e,y2_e;
    private EditText a_val_c , b_val_c , g_val_c , f_val_c , c_val_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_act);
        getSupportActionBar().setTitle(getString(R.string.circle));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
    }
    private void initialize(){
        e_h = findViewById(R.id.edit_h_c);
        e_k = findViewById(R.id.edit_k_c);
        e_r = findViewById(R.id.edit_r_c);
        //--------------------
        a_val_c = findViewById(R.id.a_edit_c);
        b_val_c = findViewById(R.id.b_edit_c);
        //------------------
        g_val_c = findViewById(R.id.g2_edit_c);
        f_val_c = findViewById(R.id.f2_edit_c);
        c_val_c = findViewById(R.id.c_edit_c);
        //-----------------
        x1_e = findViewById(R.id.x1_e);
        x2_e = findViewById(R.id.x2_e);
        y1_e = findViewById(R.id.y1_e);
        y2_e = findViewById(R.id.y2_e);
        //----------
        Button btn_draw_standard = findViewById(R.id.btn_draw_standard_circle);
        btn_draw_standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    h = Double.parseDouble(e_h.getText().toString());
                    k = Double.parseDouble(e_k.getText().toString());
                    r = Double.parseDouble(e_r.getText().toString());
                    Intent i = new Intent(CircleActivity.this,DrawingClass.class);
                    i.putExtra("h",h);
                    i.putExtra("k",k);
                    i.putExtra("r",r);
                    i.putExtra(ConstantKeys.CURVE,ConstantKeys.CIRCLE);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }

            }
        });
        Button btn_draw_general = findViewById(R.id.btn_draw_general_c);
        btn_draw_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Double.parseDouble(a_val_c.getText().toString());
                    b = Double.parseDouble(b_val_c.getText().toString());
                    g = Double.parseDouble(g_val_c.getText().toString())/2.0;
                    g/=a;
                    f = Double.parseDouble(f_val_c.getText().toString())/2.0;
                    f/=a;
                    c = Double.parseDouble(c_val_c.getText().toString());
                    c/=a;
                    Intent i = new Intent(CircleActivity.this,DrawingClass.class);
                    if(a == b && g*g+f*f-c >= 0){
                        i.putExtra("h",-g);
                        i.putExtra("k",-f);
                        i.putExtra("r",Math.sqrt(g*g+f*f-c));
                        i.putExtra("CURVE","circle");
                        if(a != 0){
                            startActivity(i);
                        }else{
                            Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getBaseContext(),"NOT CIRCLE",Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }
            }
        });

        Button draw_with_ends = findViewById(R.id.btn_draw_with_ends);
        draw_with_ends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    x1 = Double.parseDouble(x1_e.getText().toString());
                    x2 = Double.parseDouble(x2_e.getText().toString());
                    y1 = Double.parseDouble(y1_e.getText().toString());
                    y2 = Double.parseDouble(y2_e.getText().toString());
                    double h_ = (x1+x2)/2 , k_ = (y1+y2)/2;
                    double r_ = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2))/2;
                    Intent i = new Intent(CircleActivity.this,DrawingClass.class);
                    i.putExtra("h",h_);
                    i.putExtra("k",k_);
                    i.putExtra("r",r_);
                    i.putExtra(ConstantKeys.CURVE,ConstantKeys.CIRCLE);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
