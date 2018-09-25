package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPair, btnCircle, btnParabola, btnEllipse, btnHyperbola, btnGeneral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    private void initialize(){
        btnPair = findViewById(R.id.btn_pair_of_line);
        btnCircle = findViewById(R.id.btn_circle);
        btnParabola = findViewById(R.id.btn_parabola);
        btnEllipse = findViewById(R.id.btn_ellipse);
        btnHyperbola = findViewById(R.id.btn_hyperbola);
        btnGeneral = findViewById(R.id.btn_general);
        //---------------------------------------------
        btnPair.setOnClickListener(this);
        btnCircle.setOnClickListener(this);
        btnParabola.setOnClickListener(this);
        btnEllipse.setOnClickListener(this);
        btnHyperbola.setOnClickListener(this);
        btnGeneral.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pair_of_line:
                startActivity(new Intent(MainActivity.this,PairActivity.class));
                break;
            case R.id.btn_circle:
                startActivity(new Intent(MainActivity.this,CircleActivity.class));
                break;
            case R.id.btn_parabola:
                startActivity(new Intent(MainActivity.this,ParabolaActivity.class));
                break;
            case R.id.btn_ellipse:
                startActivity(new Intent(MainActivity.this,EllipseActivity.class));
                break;
            case R.id.btn_hyperbola:
                startActivity(new Intent(MainActivity.this,HyperbolaActivity.class));
                break;
            case R.id.btn_general:
                startActivity(new Intent(MainActivity.this,GeneralActivity.class));
                break;
        }
    }
}
