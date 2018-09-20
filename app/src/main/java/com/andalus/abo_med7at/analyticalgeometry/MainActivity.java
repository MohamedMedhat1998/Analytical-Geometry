package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_pair,btn_circle,btn_parabola,btn_ellips,btn_hyperbola,btn_general,btn_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    private void initialize(){
        btn_pair = (Button) findViewById(R.id.pair);
        btn_circle = (Button) findViewById(R.id.circle);
        btn_parabola = (Button) findViewById(R.id.parabola);
        btn_ellips = (Button) findViewById(R.id.ellipse);
        btn_hyperbola = (Button) findViewById(R.id.Hyperpola);
        btn_general = (Button) findViewById(R.id.btn_general);
        btn_about = (Button) findViewById(R.id.btn_about);
        //---------------------------------------------
        btn_pair.setOnClickListener(this);
        btn_circle.setOnClickListener(this);
        btn_parabola.setOnClickListener(this);
        btn_ellips.setOnClickListener(this);
        btn_hyperbola.setOnClickListener(this);
        btn_general.setOnClickListener(this);
        btn_about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pair:
                startActivity(new Intent(MainActivity.this,pair_act.class));
                break;
            case R.id.circle:
                startActivity(new Intent(MainActivity.this,Circle_act.class));
                break;
            case R.id.parabola:
                startActivity(new Intent(MainActivity.this,parabola_act.class));
                break;
            case R.id.ellipse:
                startActivity(new Intent(MainActivity.this,Ellipse_act.class));
                break;
            case R.id.Hyperpola:
                startActivity(new Intent(MainActivity.this,Hyperbola_act.class));
                break;
            case R.id.btn_general:
                startActivity(new Intent(MainActivity.this,general_act.class));
                break;
            case R.id.btn_about:
                startActivity(new Intent(MainActivity.this,about_act.class));
                break;
        }
    }
}
