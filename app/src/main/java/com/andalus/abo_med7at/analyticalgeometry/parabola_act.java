package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class parabola_act extends AppCompatActivity {
    EditText k_x_e , a_x_e, h_x_e;
    Button btn_draw_x_para;
    double k_x_para , a_x_para , h_x_para;
    //---------------------------------
    EditText h_y_e, a_y_e, k_y_e ;
    Button btn_draw_y_para;
    double h_y , a_y , k_y;
    //------------------general//x----------
    EditText d_x_e,e_x_e,f_x_e;
    Button btn_draw_gen_x;
    double d_x , e_x , f_x;
    //-----------------general//y-----------
    EditText d_y_e,e_y_e,f_y_e;
    Button btn_draw_gen_y;
    double d_y , e_y , f_y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parabola_act);
        initialize();
    }
    private void initialize(){
        d_y_e = (EditText) findViewById(R.id.D_y_p_gen);
        e_y_e = (EditText) findViewById(R.id.E_y_p_gen);
        f_y_e = (EditText) findViewById(R.id.F_y_p_gen);
        btn_draw_gen_y = (Button) findViewById(R.id.btn_draw_Gen_y_p);
        btn_draw_gen_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    d_y = Double.parseDouble(d_y_e.getText().toString());
                    e_y = Double.parseDouble(e_y_e.getText().toString());
                    f_y = Double.parseDouble(f_y_e.getText().toString());
                    Intent i = new Intent(parabola_act.this,Drawing_class.class);
                    i.putExtra("d",d_y);
                    i.putExtra("e",e_y);
                    i.putExtra("f",f_y);
                    i.putExtra("CURVE","general_y_para");
                    if(e_y == 0){
                        Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                    }else {
                        startActivity(i);
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }
            }
        });
        //-------------------------------------------
        d_x_e = (EditText) findViewById(R.id.D_x_p_gen);
        e_x_e = (EditText) findViewById(R.id.E_x_p_gen);
        f_x_e = (EditText) findViewById(R.id.F_x_p_gen);
        btn_draw_gen_x = (Button) findViewById(R.id.btn_draw_Gen_x_p);
        btn_draw_gen_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    d_x = Double.parseDouble(d_x_e.getText().toString());
                    e_x = Double.parseDouble(e_x_e.getText().toString());
                    f_x = Double.parseDouble(f_x_e.getText().toString());
                    Intent i = new Intent(parabola_act.this,Drawing_class.class);
                    i.putExtra("d",d_x);
                    i.putExtra("e",e_x);
                    i.putExtra("f",f_x);
                    i.putExtra("CURVE","general_x_para");
                    if(d_x == 0){
                        Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                    }else{
                        startActivity(i);
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }
            }
        });
        //------------------------------
        h_y_e = (EditText) findViewById(R.id.h_para_e_y);
        a_y_e = (EditText) findViewById(R.id.a_para_e_y);
        k_y_e = (EditText) findViewById(R.id.k_para_e_y);
        btn_draw_y_para = (Button) findViewById(R.id.btn_draw_para_y);
        btn_draw_y_para.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    h_y = Double.parseDouble(h_y_e.getText().toString());
                    a_y = Double.parseDouble(a_y_e.getText().toString());
                    k_y = Double.parseDouble(k_y_e.getText().toString());
                    Intent i = new Intent(parabola_act.this,Drawing_class.class);
                    i.putExtra("h",h_y);
                    i.putExtra("a",a_y);
                    i.putExtra("k",k_y);
                    i.putExtra("CURVE","yparabola");
                    if(a_y == 0){
                        Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                    }else{
                        startActivity(i);
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }

            }
        });
        //-------------------------------
        k_x_e = (EditText) findViewById(R.id.k_para_e);
        a_x_e = (EditText) findViewById(R.id.a_para_e);
        h_x_e = (EditText) findViewById(R.id.h_para_e);
        btn_draw_x_para = (Button) findViewById(R.id.btn_draw_para_stand_y_sqr);
        btn_draw_x_para.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    k_x_para = Double.parseDouble(k_x_e.getText().toString());
                    a_x_para = Double.parseDouble(a_x_e.getText().toString());
                    h_x_para = Double.parseDouble(h_x_e.getText().toString());
                    Intent i = new Intent(parabola_act.this,Drawing_class.class);
                    i.putExtra("k",k_x_para);
                    i.putExtra("a",a_x_para);
                    i.putExtra("h",h_x_para);
                    i.putExtra("CURVE","parabola");
                    if(a_x_para == 0){
                        Toast.makeText(getBaseContext(),"Unable to draw",Toast.LENGTH_LONG).show();
                    }else{
                        startActivity(i);
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
