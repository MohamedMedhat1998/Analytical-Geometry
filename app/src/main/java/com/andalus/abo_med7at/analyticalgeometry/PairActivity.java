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

public class PairActivity extends AppCompatActivity {
    private double a , h , b , g , f , c ;
    private EditText a_val , h_val , b_val , a_val_non , h_val_non , b_val_non , g_val_non , f_val_non , c_val_non;
    private Button btn_draw , btn_draw_non;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_act);
        getSupportActionBar().setTitle(getString(R.string.pair_of_lines));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
    }
    private void initialize(){
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
        btn_draw = findViewById(R.id.btn_draw);
        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    a = Double.parseDouble(a_val.getText().toString());
                    h = Double.parseDouble(h_val.getText().toString())/2.0;
                    b = Double.parseDouble(b_val.getText().toString());
                    Intent i = new Intent(PairActivity.this,Drawing_class.class);
                    i.putExtra("a",a);
                    i.putExtra("h",h);
                    i.putExtra("b",b);
                    i.putExtra("CURVE","homo-pair");
                    if(h*h-a*b < 0){
                        Toast.makeText(getBaseContext(),"NOT PAIR",Toast.LENGTH_SHORT).show();
                    }else{
                        if(a!=0 && b!=0){
                            startActivity(i);
                        }else{
                            Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }

            }
        });
        btn_draw_non = findViewById(R.id.btn_draw2);
        btn_draw_non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Double.parseDouble(a_val_non.getText().toString());
                    h = Double.parseDouble(h_val_non.getText().toString())/2.0;
                    b = Double.parseDouble(b_val_non.getText().toString());
                    g = Double.parseDouble(g_val_non.getText().toString())/2.0;
                    f = Double.parseDouble(f_val_non.getText().toString())/2.0;
                    c = Double.parseDouble(c_val_non.getText().toString());
                    Intent i = new Intent(PairActivity.this,Drawing_class.class);
                    i.putExtra("a",a);
                    i.putExtra("h",h);
                    i.putExtra("b",b);
                    i.putExtra("g",g);
                    i.putExtra("f",f);
                    i.putExtra("c",c);
                    i.putExtra("CURVE","non-homo-pair");
                    if(h*h - a*b >= 0 && a*b*c + 2*f*g*h - a*f*f - b*g*g - c*h*h == 0){
                        if(a!=0 && b!=0){
                            startActivity(i);
                        }else{
                            Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getBaseContext(),"NOT PAIR",Toast.LENGTH_SHORT).show();
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
