package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GeneralActivity extends AppCompatActivity {
    double a , h , b , g , f , c ;
    EditText a_val , h_val , b_val , g_val , f_val, c_val;
    Button btn_draw_general;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_act);
        initialize();
    }
    private void initialize(){
        a_val = (EditText) findViewById(R.id.general_a);
        h_val = (EditText) findViewById(R.id.general_h);
        b_val = (EditText) findViewById(R.id.general_b);
        g_val = (EditText) findViewById(R.id.general_g);
        f_val = (EditText) findViewById(R.id.general_f);
        c_val = (EditText) findViewById(R.id.general_c);

        btn_draw_general = (Button) findViewById(R.id.general_btn_draw);
        btn_draw_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    a = Double.parseDouble(a_val.getText().toString());
                    h = Double.parseDouble(h_val.getText().toString());
                    b = Double.parseDouble(b_val.getText().toString());
                    g = Double.parseDouble(g_val.getText().toString());
                    f = Double.parseDouble(f_val.getText().toString());
                    c = Double.parseDouble(c_val.getText().toString());
                    Intent i = new Intent(GeneralActivity.this,Drawing_class.class);
                    i.putExtra("a",a);
                    i.putExtra("h",h);
                    i.putExtra("b",b);
                    i.putExtra("g",g);
                    i.putExtra("f",f);
                    i.putExtra("c",c);
                    i.putExtra("CURVE","general");
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Missing some data",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
