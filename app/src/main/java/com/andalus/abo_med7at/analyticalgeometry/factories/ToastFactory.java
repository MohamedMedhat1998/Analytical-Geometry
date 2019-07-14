package com.andalus.abo_med7at.analyticalgeometry.factories;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class ToastFactory {

    private ToastFactory(){

    }

    public static Toast create(Context context, String text){
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        TextView v = toast.getView().findViewById(android.R.id.message);
        if (v != null) v.setGravity(Gravity.CENTER);
        return toast;
    }
}
