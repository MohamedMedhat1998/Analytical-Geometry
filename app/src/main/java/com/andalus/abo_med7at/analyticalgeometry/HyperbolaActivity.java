package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HyperbolaActivity extends AppCompatActivity {
    EditText a_e_g , b_e_g,d_e_g,e_e_g,f_e_g;
    double a_g , b_g , d_g , e_g , f_g;
    Button draw_gen;
    //----------------------------------------
    EditText a_e2 , b_e2;
    Button draw_hyper2;
    //-----------------------------------------------
    EditText a_e , b_e;
    Button draw_hyper;
    double a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyperbola_act);
        initialize();
    }
    private void initialize(){
        a_e_g = (EditText) findViewById(R.id.a_ell_e_g);
        b_e_g = (EditText) findViewById(R.id.b_ell_e_g);
        d_e_g = (EditText) findViewById(R.id.d_ell_e_g);
        e_e_g = (EditText) findViewById(R.id.e_ell_e_g);
        f_e_g = (EditText) findViewById(R.id.f_ell_e_g);
        draw_gen = (Button) findViewById(R.id.btn_draw_gen_ell);
        draw_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a_g = Double.parseDouble(a_e_g.getText().toString());
                    b_g = Double.parseDouble(b_e_g.getText().toString());
                    d_g = Double.parseDouble(d_e_g.getText().toString());
                    e_g = Double.parseDouble(e_e_g.getText().toString());
                    f_g = Double.parseDouble(f_e_g.getText().toString());
                    Intent i = new Intent(HyperbolaActivity.this,Drawing_class.class);
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
        a_e2 = (EditText)findViewById(R.id.a_hyper2);
        b_e2 = (EditText)findViewById(R.id.b_hyper2);
        draw_hyper2 = (Button) findViewById(R.id.btn_draw_hyper2);
        draw_hyper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.sqrt(Double.parseDouble(a_e2.getText().toString()));
                    b = Math.sqrt(Double.parseDouble(b_e2.getText().toString()));
                    Intent i = new Intent(HyperbolaActivity.this,Drawing_class.class);
                    i.putExtra("a",a);
                    i.putExtra("b",b);
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
        a_e = (EditText)findViewById(R.id.a_hyper);
        b_e = (EditText)findViewById(R.id.b_hyper);
        draw_hyper = (Button) findViewById(R.id.btn_draw_hyper);
        draw_hyper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Math.sqrt(Double.parseDouble(a_e.getText().toString()));
                    b = Math.sqrt(Double.parseDouble(b_e.getText().toString()));
                    Intent i = new Intent(HyperbolaActivity.this,Drawing_class.class);
                    i.putExtra("a",a);
                    i.putExtra("b",b);
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
}
