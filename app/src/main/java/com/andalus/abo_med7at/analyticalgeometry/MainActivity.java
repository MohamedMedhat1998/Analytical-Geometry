package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPair, btnCircle, btnParabola, btnEllipse, btnHyperbola, btnGeneral;
    private static AdView mAdView;

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
        MobileAds.initialize(this,getString(R.string.app_ad_id));
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_privacy_policy){
            Intent privacyPolicyIntent = new Intent(Intent.ACTION_VIEW);
            privacyPolicyIntent.setData(Uri.parse(getString(R.string.privacy_policy_link)));
            startActivity(privacyPolicyIntent);
        }
        return true;
    }
}
