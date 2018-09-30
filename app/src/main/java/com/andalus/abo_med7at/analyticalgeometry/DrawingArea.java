package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by Abo_Med7at on 18/04/2017.
 */

public class DrawingArea extends View {
    private double a,h,b,g,f,c,k,r,d,e;
    private String curve;
    float x_coor , y_coor;
    private Paint red = new Paint();

    public DrawingArea(Context context, AttributeSet attributeSet){
        super(context,attributeSet);

    }

    public DrawingArea(Context context , double a_val , double h_val , double b_val) {
        super(context);
        a = a_val;
        h = h_val;
        b = b_val;
        curve = "homo-pair";
    }
    public DrawingArea(Context context , double a_val , double h_val , double b_val, double g_val , double f_val , double c_val , char ch) {
        super(context);
        a = a_val;
        h = h_val;
        b = b_val;
        g = g_val;
        f = f_val;
        c = c_val;
        if(ch == 'n'){
            curve = "non-homo-pair";
        }else if(ch == 'g'){
            curve = "general";
        }

    }

    public DrawingArea(Context context, double h, double k, double r, char c) {
        super(context);
        if(c == 'c'){
            curve = "circle";
            this.h = h;
            this.k = k;
            this.r = r;
        }else if( c == 'p'){
            curve = "xparabola";
            this.k = h;
            this.a = k;
            this.h = r;
        }else if( c == 'y'){
            curve = "yparabola";
            this.k = h;
            this.a = k;
            this.h = r;
        }else if( c == '*'){
            curve = "gen_x_parabola";
            this.d = h;
            this.e = k;
            this.f = r;
        }else if( c == '-'){
            curve = "gen_y_parabola";
            this.d = h;
            this.e = k;
            this.f = r;
        }

    }
    public DrawingArea(Context context, double a, double b, char c) {
        super(context);
        this.a = a;
        this.b = b;
        if(c == 'e'){
            curve = "standard_ellipse";
        }else if( c == 'h'){
            curve = "hyperbola";
        }else if( c == 'H'){
            curve = "hyperbola2";
        }

    }
    public DrawingArea(Context context, double a, double b, double d, double e , double f) {
        super(context);
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.f = f;
        curve = "general_ellipse";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        red.setColor(Color.RED);
        draw_axes(canvas);
        switch (curve){
            case "homo-pair":
                draw_pair(canvas);
                break;
            case "non-homo-pair":
                draw_non_pair(canvas);
                break;
            case "circle":
                draw_circle(canvas);
                break;
            case "xparabola":
                draw_x_parabola(canvas);
                break;
            case "yparabola":
                draw_y_parabola(canvas);
                break;
            case "gen_x_parabola":
                draw_gen_x_para(canvas);
                break;
            case "gen_y_parabola":
                draw_gen_y_para(canvas);
                break;
            case "standard_ellipse":
                draw_standard_ellipse(canvas);
                break;
            case "general_ellipse":
                draw_general_ellipse(canvas);
                break;
            case "hyperbola":
                draw_hyperbola(canvas);
                break;
            case "hyperbola2":
                draw_hyperbola2(canvas);
                break;
            case "general":
                draw_general(canvas);
                break;
        }
        draw_circle(canvas);
    }
    private float invertY(float coor){
        float f;
        f = coor*40;
        return coor*20 + getHeight()/2 -f;
    }
    /*private float invertY(float coor){
        float f;
        f = coor*2;
        return coor + getHeight()/2 -f;
    }*/
    private void draw_pair(Canvas canvas){
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            x_coor = i;
            y_coor = (float) ((x_coor)*((-h+Math.sqrt(h*h-a*b))/b));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            x_coor = i;
            y_coor = (float) ((x_coor)*((-h-Math.sqrt(h*h-a*b))/b));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }

    }
    private void draw_axes(Canvas canvas){
        Paint p = new Paint();
        p.setColor(getResources().getColor(R.color.Gray_300));
        for(int i = getWidth()/2 ; i < getWidth() ; i+=20){
            Rect y_ = new Rect();
            y_.set(i,0,i+1,getHeight());
            canvas.drawRect(y_,p);
        }
        for(int i = getWidth()/2 ; i >0 ; i-=20){
            Rect y_ = new Rect();
            y_.set(i,0,i+1,getHeight());
            canvas.drawRect(y_,p);
        }
        for(int i = getHeight()/2 ; i < getHeight() ; i+=20){
            Rect x_ = new Rect();
            x_.set(0,i,getWidth(),i+1);
            canvas.drawRect(x_,p);
        }
        for(int i = getHeight()/2 ; i > 0 ; i-=20){
            Rect x_ = new Rect();
            x_.set(0,i,getWidth(),i+1);
            canvas.drawRect(x_,p);
        }
        Rect y = new Rect();
        Rect x = new Rect();
        y.set(getWidth()/2-1,0,getWidth()/2+1,getHeight());
        x.set(0,getHeight()/2 -1,getWidth(),getHeight()/2 +1);
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(y,p);
        canvas.drawRect(x,p);
    }
    private void draw_non_pair(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) ((-(2.0*h*i+2.0*g)+Math.sqrt((2.0*h*i+2.0*g)*(2.0*h*i+2.0*g)-4.0*a*(b*i*i+2.0*f*i+c)))/(2.0*a));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) ((-(2.0*h*i+2.0*g)-Math.sqrt((2.0*h*i+2.0*g)*(2.0*h*i+2.0*g)-4.0*a*(b*i*i+2.0*f*i+c)))/(2.0*a));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
    }
    private void draw_circle(Canvas canvas){
        red.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((float) (getWidth()/2 +h*20),invertY((float) k), (float) r*20,red);
    }
    //--------------------------------------------------------------------------------------
    private void draw_x_parabola(Canvas canvas){
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            x_coor = i;
            y_coor = (float) (k + Math.sqrt(a*x_coor-a*h));
            canvas.drawPoint((x_coor*20+ getWidth()/2),invertY(y_coor),red);
        }
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            x_coor = i;
            y_coor = (float) (k - Math.sqrt(a*x_coor-a*h));
            canvas.drawPoint((x_coor*20+ getWidth()/2),invertY(y_coor),red);
        }
    }
    private void draw_y_parabola(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (h + Math.sqrt(a*y_coor-a*k));
            canvas.drawPoint((x_coor*20+ getWidth()/2),invertY(y_coor),red);
        }
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (h - Math.sqrt(a*y_coor-a*k));
            canvas.drawPoint((x_coor*20+ getWidth()/2),invertY(y_coor),red);
        }
    }
    private void draw_gen_x_para(Canvas canvas){
        for(float i = -getWidth() ; i < getWidth() ; i+= 0.05){
            x_coor = i;
            y_coor = (float) (0.5*(-e + Math.sqrt(e*e-4*(d*x_coor+f))));
            canvas.drawPoint((x_coor*20 + getWidth()/2),invertY(y_coor),red);
        }
        for(float i = -getWidth() ; i < getWidth() ; i+= 0.05){
            x_coor = i;
            y_coor = (float) (0.5*(-e - Math.sqrt(e*e-4*(d*x_coor+f))));
            canvas.drawPoint((x_coor*20 + getWidth()/2),invertY(y_coor),red);
        }
    }
    private void draw_gen_y_para(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (0.5*(-d+Math.sqrt(d*d-4*(e*y_coor+f))));
            canvas.drawPoint((x_coor*20 + getWidth()/2),invertY(y_coor),red);
        }
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (0.5*(-d-Math.sqrt(d*d-4*(e*y_coor+f))));
            canvas.drawPoint((x_coor*20 + getWidth()/2),invertY(y_coor),red);
        }
    }
    //-------------------------------------------------------------------------------
    private void draw_standard_ellipse(Canvas canvas){
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (a*Math.sqrt(1-(y_coor*y_coor)/(b*b)));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (-a*Math.sqrt(1-(y_coor*y_coor)/(b*b)));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
    }
    private void draw_general_ellipse(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) ((-d-Math.sqrt(d*d-4*a*(b*y_coor*y_coor+e*y_coor+f)))/(2*a));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
        for(float i = -getHeight() ; i < getHeight(); i+=0.05){
            y_coor = i;
            x_coor = (float) ((-d+Math.sqrt(d*d-4*a*(b*y_coor*y_coor+e*y_coor+f)))/(2*a));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
    }
    private void draw_hyperbola(Canvas canvas){
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (a*Math.sqrt(1+(y_coor*y_coor)/(b*b)));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            y_coor = i;
            x_coor = (float) (-a*Math.sqrt(1+(y_coor*y_coor)/(b*b)));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
    }
    private void draw_hyperbola2(Canvas canvas){
        for (float i = -getWidth() ; i < getWidth() ; i+=0.05){
            x_coor = i;
            y_coor = (float) (b*Math.sqrt(1+(x_coor*x_coor)/(a*a)));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
        for (float i = -getWidth() ; i < getWidth() ; i+=0.05){
            x_coor = i;
            y_coor = (float) (-b*Math.sqrt(1+(x_coor*x_coor)/(a*a)));
            canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
        }
    }
    private void draw_general(Canvas canvas){
        if(a!=0){
            for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
                y_coor = i;
                x_coor = (float) ((-(h*i+g)+Math.sqrt((h*i+g)*(h*i+g)-4.0*a*(b*i*i+f*i+c)))/(2.0*a));
                canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
            }
            for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
                y_coor = i;
                x_coor = (float) ((-(h*i+g)-Math.sqrt((h*i+g)*(h*i+g)-4.0*a*(b*i*i+f*i+c)))/(2.0*a));
                canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
            }
        }else if(b != 0){
            for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
                x_coor = i;
                y_coor = (float) ((-(h*i+f)+Math.sqrt((h*i+f)*(h*i+f)-4.0*b*(a*i*i+g*i+c)))/(2.0*b));
                canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
            }
            for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
                x_coor = i;
                y_coor = (float) ((-(h*i+f)-Math.sqrt((h*i+f)*(h*i+f)-4.0*b*(a*i*i+g*i+c)))/(2.0*b));
                canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
            }
        }else{
            for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
                y_coor = i;
                x_coor = (float) (-(f*i+c)/(h*i+g));
                canvas.drawPoint(x_coor *20+ getWidth()/2, invertY(y_coor) ,red);
            }
        }

    }
}
