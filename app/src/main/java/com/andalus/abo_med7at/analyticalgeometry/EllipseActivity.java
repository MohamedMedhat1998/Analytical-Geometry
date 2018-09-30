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

public class EllipseActivity extends AppCompatActivity {
    private EditText a_e_g , b_e_g,d_e_g,e_e_g,f_e_g;
    private double a_g , b_g , d_g , e_g , f_g;
    private Button draw_gen;
    //-------------------
    private EditText a_sqr_ellipse_standard_e,b_sqr_ellipse_standard_e;
    private double a_e_s , b_e_s;
    private Button btn_draw_s_ellipse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse_act);
        getSupportActionBar().setTitle(getString(R.string.ellipse));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
    }
    private void initialize(){
        a_e_g = findViewById(R.id.a_ell_e_g);
        b_e_g = findViewById(R.id.b_ell_e_g);
        d_e_g = findViewById(R.id.d_ell_e_g);
        e_e_g = findViewById(R.id.e_ell_e_g);
        f_e_g = findViewById(R.id.f_ell_e_g);
        draw_gen = findViewById(R.id.btn_draw_gen_ell);
        draw_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a_g = Double.parseDouble(a_e_g.getText().toString());
                    b_g = Double.parseDouble(b_e_g.getText().toString());
                    d_g = Double.parseDouble(d_e_g.getText().toString());
                    e_g = Double.parseDouble(e_e_g.getText().toString());
                    f_g = Double.parseDouble(f_e_g.getText().toString());
                    Intent i = new Intent(EllipseActivity.this,DrawingClass.class);
                    i.putExtra("a",a_g);
                    i.putExtra("b",b_g);
                    i.putExtra("d",d_g);
                    i.putExtra("e",e_g);
                    i.putExtra("f",f_g);
                    i.putExtra("CURVE","general_ellipse");
                    if(a_g == b_g){
                        Toast.makeText(getBaseContext(),"NOT Ellipse",Toast.LENGTH_LONG).show();
                    }else if(d_g == 0 && e_g==0 &&f_g>=0){
                        Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                    }else if((a_g > 0 && b_g < 0)||(a_g < 0 && b_g > 0)){
                        Toast.makeText(getBaseContext(),"NOT Ellipse",Toast.LENGTH_LONG).show();
                    }
                    else{
                        startActivity(i);
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }
            }
        });
        //---------------------------------
        a_sqr_ellipse_standard_e = findViewById(R.id.a_sqrt_s_ellipse);
        b_sqr_ellipse_standard_e = findViewById(R.id.b_sqrt_s_ellipse);
        btn_draw_s_ellipse = findViewById(R.id.btn_draw_ellipse_standard);
        btn_draw_s_ellipse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    a_e_s = Math.sqrt(Double.parseDouble(a_sqr_ellipse_standard_e.getText().toString()));
                    b_e_s = Math.sqrt(Double.parseDouble(b_sqr_ellipse_standard_e.getText().toString()));
                    Intent i = new Intent(EllipseActivity.this,DrawingClass.class);
                    i.putExtra("a",a_e_s);
                    i.putExtra("b",b_e_s);
                    i.putExtra("CURVE","standard_ellipse");
                    if(a_e_s > 0 && b_e_s > 0){
                        startActivity(i);
                    }else{
                        Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                    }
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
