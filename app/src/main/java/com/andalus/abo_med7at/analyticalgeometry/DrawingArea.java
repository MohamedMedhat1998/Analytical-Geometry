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
    private float xCoor, yCoor;
    private Paint red = new Paint();
    private double hPair, aPair, bPair;
    private double hNonPair,gNonPair,aNonPair,bNonPair,fNonPair,cNonPair;
    private double hCircle,kCircle,rCircle;
    private double kXParabola,aXParabola,hXParabola;
    private double hYParabola,aYParabola,kYParabola;

    public DrawingArea(Context context, AttributeSet attributeSet){
        super(context,attributeSet);

    }

    public DrawingArea(Context context , double a_val , double h_val , double b_val) {
        super(context);
        aPair = a_val;
        hPair = h_val;
        bPair = b_val;
        curve = "homo-pair";
    }
    public DrawingArea(Context context , double a_val , double h_val , double b_val, double g_val , double f_val , double c_val , char ch) {
        super(context);
        if(ch == 'n'){
            aNonPair = a_val;
            hNonPair = h_val;
            bNonPair = b_val;
            gNonPair = g_val;
            fNonPair = f_val;
            cNonPair = c_val;
            curve = "non-homo-pair";
        }else if(ch == 'g'){
            curve = "general";
        }

    }

    public DrawingArea(Context context, double h, double k, double r, char c) {
        super(context);
        if(c == 'c'){
            curve = "circle";
            hCircle = h;
            kCircle = k;
            rCircle = r;
        }else if( c == 'p'){
            curve = "xparabola";
            kXParabola = h;
            aXParabola = k;
            hXParabola = r;
        }else if( c == 'y'){
            curve = "yparabola";
            kYParabola = h;
            aYParabola = k;
            hYParabola = r;
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
        drawAxes(canvas);
        switch (curve){
            case "homo-pair":
                drawPair(canvas);
                break;
            case "non-homo-pair":
                drawNonPair(canvas);
                break;
            case "circle":
                drawCircle(canvas);
                break;
            case "xparabola":
                drawXParabola(canvas);
                break;
            case "yparabola":
                drawYParabola(canvas);
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
        drawCircle(canvas);
    }
    private float invertY(float coor){
        float f;
        f = coor*40;
        return coor*20 + getHeight()/2f -f;
    }
    /*private float invertY(float coor){
        float f;
        f = coor*2;
        return coor + getHeight()/2 -f;
    }*/
    private void drawPair(Canvas canvas){
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            xCoor = i;
            yCoor = (float) ((xCoor)*((-hPair+Math.sqrt(hPair*hPair-aPair*bPair))/bPair));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            xCoor = i;
            yCoor = (float) ((xCoor)*((-hPair-Math.sqrt(hPair*hPair-aPair*bPair))/bPair));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }

    }
    private void drawAxes(Canvas canvas){
        Paint p = new Paint();
        p.setColor(getResources().getColor(R.color.Gray_300));
        Paint p2 = new Paint();
        p2.setColor(Color.GREEN);
        int count = 0;
        //+ve x axis
        for(int i = getWidth()/2 ; i < getWidth() ; i+=20){
            Rect y_ = new Rect();
            y_.set(i,0,i+1,getHeight());
            canvas.drawRect(y_,p);
            if(count!=0)
                canvas.drawText(count+"",i-2.5f,getHeight()/2.0f + 15.0f,p2);
            count++;
        }
        count = 0;
        //-ve x axis
        for(int i = getWidth()/2 ; i >0 ; i-=20){
            Rect y_ = new Rect();
            y_.set(i,0,i+1,getHeight());
            canvas.drawRect(y_,p);
            if(count!=0)
                canvas.drawText(count+"",i-5.0f,getHeight()/2.0f + 15.0f,p2);
            count--;
        }
        count = 0;
        //-ve y axis
        for(int i = getHeight()/2 ; i < getHeight() ; i+=20){
            Rect x_ = new Rect();
            x_.set(0,i,getWidth(),i+1);
            canvas.drawRect(x_,p);
            if(count!=0)
                canvas.drawText(count+"",getWidth()/2.0f+2.5f,i+4.0f,p2);
            count--;
        }
        count = 0;
        //+ve y axis
        for(int i = getHeight()/2 ; i > 0 ; i-=20){
            Rect x_ = new Rect();
            x_.set(0,i,getWidth(),i+1);
            canvas.drawRect(x_,p);
            if(count!=0)
                canvas.drawText(count+"",getWidth()/2.0f+2.5f,i+4.0f,p2);
            count++;
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
    private void drawNonPair(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) ((-(2.0*hNonPair*i+2.0*gNonPair)+Math.sqrt((2.0*hNonPair*i+2.0*gNonPair)*(2.0*hNonPair*i+2.0*gNonPair)-4.0*aNonPair*(bNonPair*i*i+2.0*fNonPair*i+cNonPair)))/(2.0*aNonPair));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) ((-(2.0*hNonPair*i+2.0*gNonPair)-Math.sqrt((2.0*hNonPair*i+2.0*gNonPair)*(2.0*hNonPair*i+2.0*gNonPair)-4.0*aNonPair*(bNonPair*i*i+2.0*fNonPair*i+cNonPair)))/(2.0*aNonPair));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
    }
    private void drawCircle(Canvas canvas){
        red.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((float) (getWidth()/2 +hCircle*20),invertY((float) kCircle), (float) rCircle*20,red);
    }
    //--------------------------------------------------------------------------------------
    private void drawXParabola(Canvas canvas){
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            xCoor = i;
            yCoor = (float) (kXParabola + Math.sqrt(aXParabola* xCoor -aXParabola*hXParabola));
            canvas.drawPoint((xCoor *20+ getWidth()/2f),invertY(yCoor),red);
        }
        for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
            xCoor = i;
            yCoor = (float) (kXParabola - Math.sqrt(aXParabola* xCoor -aXParabola*hXParabola));
            canvas.drawPoint((xCoor *20+ getWidth()/2f),invertY(yCoor),red);
        }
    }
    private void drawYParabola(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (hYParabola + Math.sqrt(aYParabola* yCoor -aYParabola*kYParabola));
            canvas.drawPoint((xCoor *20+ getWidth()/2f),invertY(yCoor),red);
        }
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (hYParabola - Math.sqrt(aYParabola* yCoor -aYParabola*kYParabola));
            canvas.drawPoint((xCoor *20+ getWidth()/2f),invertY(yCoor),red);
        }
    }
    private void draw_gen_x_para(Canvas canvas){
        for(float i = -getWidth() ; i < getWidth() ; i+= 0.05){
            xCoor = i;
            yCoor = (float) (0.5*(-e + Math.sqrt(e*e-4*(d* xCoor +f))));
            canvas.drawPoint((xCoor *20 + getWidth()/2f),invertY(yCoor),red);
        }
        for(float i = -getWidth() ; i < getWidth() ; i+= 0.05){
            xCoor = i;
            yCoor = (float) (0.5*(-e - Math.sqrt(e*e-4*(d* xCoor +f))));
            canvas.drawPoint((xCoor *20 + getWidth()/2f),invertY(yCoor),red);
        }
    }
    private void draw_gen_y_para(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (0.5*(-d+Math.sqrt(d*d-4*(e* yCoor +f))));
            canvas.drawPoint((xCoor *20 + getWidth()/2f),invertY(yCoor),red);
        }
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (0.5*(-d-Math.sqrt(d*d-4*(e* yCoor +f))));
            canvas.drawPoint((xCoor *20 + getWidth()/2f),invertY(yCoor),red);
        }
    }
    //-------------------------------------------------------------------------------
    private void draw_standard_ellipse(Canvas canvas){
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (a*Math.sqrt(1-(yCoor * yCoor)/(b*b)));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (-a*Math.sqrt(1-(yCoor * yCoor)/(b*b)));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
    }
    private void draw_general_ellipse(Canvas canvas){
        for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) ((-d-Math.sqrt(d*d-4*a*(b* yCoor * yCoor +e* yCoor +f)))/(2*a));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
        for(float i = -getHeight() ; i < getHeight(); i+=0.05){
            yCoor = i;
            xCoor = (float) ((-d+Math.sqrt(d*d-4*a*(b* yCoor * yCoor +e* yCoor +f)))/(2*a));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
    }
    private void draw_hyperbola(Canvas canvas){
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (a*Math.sqrt(1+(yCoor * yCoor)/(b*b)));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
        for (float i = -getHeight() ; i < getHeight() ; i+=0.05){
            yCoor = i;
            xCoor = (float) (-a*Math.sqrt(1+(yCoor * yCoor)/(b*b)));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
    }
    private void draw_hyperbola2(Canvas canvas){
        for (float i = -getWidth() ; i < getWidth() ; i+=0.05){
            xCoor = i;
            yCoor = (float) (b*Math.sqrt(1+(xCoor * xCoor)/(a*a)));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
        for (float i = -getWidth() ; i < getWidth() ; i+=0.05){
            xCoor = i;
            yCoor = (float) (-b*Math.sqrt(1+(xCoor * xCoor)/(a*a)));
            canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
        }
    }
    private void draw_general(Canvas canvas){
        if(a!=0){
            for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
                yCoor = i;
                xCoor = (float) ((-(h*i+g)+Math.sqrt((h*i+g)*(h*i+g)-4.0*a*(b*i*i+f*i+c)))/(2.0*a));
                canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
            }
            for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
                yCoor = i;
                xCoor = (float) ((-(h*i+g)-Math.sqrt((h*i+g)*(h*i+g)-4.0*a*(b*i*i+f*i+c)))/(2.0*a));
                canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
            }
        }else if(b != 0){
            for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
                xCoor = i;
                yCoor = (float) ((-(h*i+f)+Math.sqrt((h*i+f)*(h*i+f)-4.0*b*(a*i*i+g*i+c)))/(2.0*b));
                canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
            }
            for(float i = -getWidth() ; i < getWidth() ; i+=0.05){
                xCoor = i;
                yCoor = (float) ((-(h*i+f)-Math.sqrt((h*i+f)*(h*i+f)-4.0*b*(a*i*i+g*i+c)))/(2.0*b));
                canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
            }
        }else{
            for(float i = -getHeight() ; i < getHeight() ; i+=0.05){
                yCoor = i;
                xCoor = (float) (-(f*i+c)/(h*i+g));
                canvas.drawPoint(xCoor *20+ getWidth()/2f, invertY(yCoor) ,red);
            }
        }

    }
}
