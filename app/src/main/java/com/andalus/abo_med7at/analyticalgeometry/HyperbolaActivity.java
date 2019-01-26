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

public class HyperbolaActivity extends AppCompatActivity {
    private EditText a_e_g , b_e_g,d_e_g,e_e_g,f_e_g;
    private double a_g , b_g , d_g , e_g , f_g;
    private Button draw_gen;
    //----------------------------------------
    private EditText a_e2 , b_e2;
    private Button draw_hyper2;
    //-----------------------------------------------
    private EditText a_e , b_e;
    private Button draw_hyper;
    private double a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyperbola_act);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.hyperbola));
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
                    Intent i = new Intent(HyperbolaActivity.this,DrawingClass.class);
                    i.putExtra("a",a_g);
                    i.putExtra("b",b_g);
                    i.putExtra("d",d_g);
                    i.putExtra("e",e_g);
                    i.putExtra("f",f_g);
                    i.putExtra("CURVE","general_ellipse");
                    /*else if(d_g == 0 && e_g==0 &&f_g>=0){
                        Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                    }else */if((a_g >= 0 && b_g >= 0)||(a_g <= 0 && b_g <= 0)){
                        Toast.makeText(getBaseContext(),"NOT Hyperbola",Toast.LENGTH_LONG).show();
                    }
                    else{
                        startActivity(i);
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }
            }
        });
        //------------------------------
        a_e2 = findViewById(R.id.a_hyper2);
        b_e2 = findViewById(R.id.b_hyper2);
        draw_hyper2 = findViewById(R.id.btn_draw_hyper2);
        draw_hyper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.sqrt(Double.parseDouble(a_e2.getText().toString()));
                    b = Math.sqrt(Double.parseDouble(b_e2.getText().toString()));
                    Intent i = new Intent(HyperbolaActivity.this,DrawingClass.class);
                    i.putExtra("a",a);
                    i.putExtra("b",b);
                    //Probably I should have replaced "hyperbola2" with "yHyperbola"
                    i.putExtra("CURVE","hyperbola2");
                    if(a > 0 && b > 0){
                        startActivity(i);
                    }else {
                        Toast.makeText(getBaseContext(),"Unable to draw", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data", Toast.LENGTH_LONG).show();
                }
            }
        });
        //-------------------------------------
        a_e = findViewById(R.id.a_hyper);
        b_e = findViewById(R.id.b_hyper);
        draw_hyper = findViewById(R.id.btn_draw_hyper);
        draw_hyper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.sqrt(Double.parseDouble(a_e.getText().toString()));
                    b = Math.sqrt(Double.parseDouble(b_e.getText().toString()));
                    Intent i = new Intent(HyperbolaActivity.this,DrawingClass.class);
                    i.putExtra("a",a);
                    i.putExtra("b",b);
                    //Probably I should have replaced "hyperbola" with "xHyperbola"
                    i.putExtra("CURVE","hyperbola");
                    if(a > 0 && b > 0){
                        startActivity(i);
                    }else {
                        Toast.makeText(getBaseContext(),"Unable to draw", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data", Toast.LENGTH_LONG).show();
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
