package com.andalus.abo_med7at.analyticalgeometry;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.andalus.abo_med7at.analyticalgeometry.utils.Constants;


/**
 * Created by Abo_Med7at on 18/04/2017.
 */

public class DrawingArea extends View {
    private double aGeneral, hGeneral, bGeneral, gGeneral, fGeneral, cGeneral;
    private String curve;
    private float xCoor, yCoor;
    private Paint red = new Paint();
    private double hPair, aPair, bPair;
    private double hNonPair, gNonPair, aNonPair, bNonPair, fNonPair, cNonPair;
    private double hCircle, kCircle, rCircle;
    private double kXParabola, aXParabola, hXParabola;
    private double hYParabola, aYParabola, kYParabola;
    private double eGenXPara, dGenXPara, fGenXPara;
    private double dGenYPara, eGenYPara, fGenYPara;
    private double aStandardEllipse, bStandardEllipse;
    private double dGeneralEllipse, aGeneralEllipse, bGeneralEllipse, eGeneralEllipse, fGeneralEllipse;
    private double dGeneralHyperbola, aGeneralHyperbola, bGeneralHyperbola, eGeneralHyperbola, fGeneralHyperbola;
    private double aXHyperbola, bXHyperbola;
    private double bYHyperbola, aYHyperbola;

    public DrawingArea(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DrawingArea(Context context, double a_val, double h_val, double b_val) {
        super(context);
        aPair = a_val;
        hPair = h_val;
        bPair = b_val;
        curve = Constants.HOMO_PAIR;
    }

    public DrawingArea(Context context, double a_val, double h_val, double b_val, double g_val, double f_val, double c_val, char ch) {
        super(context);
        if (ch == 'n') {
            aNonPair = a_val;
            hNonPair = h_val;
            bNonPair = b_val;
            gNonPair = g_val;
            fNonPair = f_val;
            cNonPair = c_val;
            curve = Constants.NON_HOMO_PAIR;
        } else if (ch == 'g') {
            curve = Constants.GENERAL;
            aGeneral = a_val;
            hGeneral = h_val;
            bGeneral = b_val;
            gGeneral = g_val;
            fGeneral = f_val;
            cGeneral = c_val;
        }

    }

    public DrawingArea(Context context, double h, double k, double r, char c) {
        super(context);
        switch (c) {
            case 'c':
                curve = Constants.Keys.CIRCLE;
                hCircle = h;
                kCircle = k;
                rCircle = r;
                break;
            case 'p':
                curve = Constants.X_PARABOLA;
                kXParabola = h;
                aXParabola = k;
                hXParabola = r;
                break;
            case 'y':
                curve = Constants.Y_PARABOLA;
                kYParabola = h;
                aYParabola = k;
                hYParabola = r;
                break;
            case '*':
                curve = Constants.GENERAL_X_PARABOLA;
                dGenXPara = h;
                eGenXPara = k;
                fGenXPara = r;
                break;
            case '-':
                curve = Constants.GENERAL_Y_PARABOLA;
                dGenYPara = h;
                eGenYPara = k;
                fGenYPara = r;
                break;
        }

    }

    public DrawingArea(Context context, double a, double b, char c) {
        super(context);
        switch (c) {
            case 'e':
                curve = Constants.STANDARD_ELLIPSE;
                aStandardEllipse = a;
                bStandardEllipse = b;
                break;
            case 'h':
                curve = Constants.X_HYPERBOLA;
                aXHyperbola = a;
                bXHyperbola = b;
                break;
            case 'H':
                curve = Constants.Y_HYPERBOLA;
                aYHyperbola = a;
                bYHyperbola = b;
                break;
        }

    }

    public DrawingArea(Context context, double a, double b, double d, double e, double f, String givenCurve) {
        super(context);
        switch (givenCurve) {
            case Constants.GENERAL_ELLIPSE:
                aGeneralEllipse = a;
                bGeneralEllipse = b;
                dGeneralEllipse = d;
                eGeneralEllipse = e;
                fGeneralEllipse = f;
                curve = Constants.GENERAL_ELLIPSE;
                break;
            case Constants.GENERAL_HYPERBOLA:
                aGeneralHyperbola = a;
                bGeneralHyperbola = b;
                dGeneralHyperbola = d;
                eGeneralHyperbola = e;
                fGeneralHyperbola = f;
                curve = Constants.GENERAL_HYPERBOLA;
                break;
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        red.setColor(Color.RED);
        drawAxes(canvas);
        switch (curve) {
            case Constants.HOMO_PAIR:
                drawPair(canvas);
                break;
            case Constants.NON_HOMO_PAIR:
                drawNonPair(canvas);
                break;
            case Constants.Keys.CIRCLE:
                drawCircle(canvas);
                break;
            case Constants.X_PARABOLA:
                drawXParabola(canvas);
                break;
            case Constants.Y_PARABOLA:
                drawYParabola(canvas);
                break;
            case Constants.GENERAL_X_PARABOLA:
                drawGenXPara(canvas);
                break;
            case Constants.GENERAL_Y_PARABOLA:
                drawGenYPara(canvas);
                break;
            case Constants.STANDARD_ELLIPSE:
                drawStandardEllipse(canvas);
                break;
            case Constants.GENERAL_ELLIPSE:
                drawGeneralEllipse(canvas);
                break;
            case Constants.GENERAL_HYPERBOLA:
                drawGeneralHyperbola(canvas);
                break;
            case Constants.X_HYPERBOLA:
                drawXHyperbola(canvas);
                break;
            case Constants.Y_HYPERBOLA:
                drawYHyperbola(canvas);
                break;
            case Constants.GENERAL:
                drawGeneral(canvas);
                break;
        }
    }

    private float invertY(float coor) {
        float f = coor * 40;
        return coor * 20 + getHeight() / 2f - f;
    }

    /*private float invertY(float coor){
        float f;
        f = coor*2;
        return coor + getHeight()/2 -f;
    }*/
    private void drawPair(Canvas canvas) {
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) ((xCoor) * ((-hPair + Math.sqrt(hPair * hPair - aPair * bPair)) / bPair));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) ((xCoor) * ((-hPair - Math.sqrt(hPair * hPair - aPair * bPair)) / bPair));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }

    }

    private void drawAxes(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(getResources().getColor(R.color.Gray_300));
        Paint p2 = new Paint();
        p2.setColor(Color.GREEN);
        int count = 0;
        //+ve x axis
        for (int i = getWidth() / 2; i < getWidth(); i += 20) {
            Rect y_ = new Rect();
            y_.set(i, 0, i + 1, getHeight());
            canvas.drawRect(y_, p);
            if (count != 0)
                canvas.drawText(count + "", i - 2.5f, getHeight() / 2.0f + 15.0f, p2);
            count++;
        }
        count = 0;
        //-ve x axis
        for (int i = getWidth() / 2; i > 0; i -= 20) {
            Rect y_ = new Rect();
            y_.set(i, 0, i + 1, getHeight());
            canvas.drawRect(y_, p);
            if (count != 0)
                canvas.drawText(count + "", i - 5.0f, getHeight() / 2.0f + 15.0f, p2);
            count--;
        }
        count = 0;
        //-ve y axis
        for (int i = getHeight() / 2; i < getHeight(); i += 20) {
            Rect x_ = new Rect();
            x_.set(0, i, getWidth(), i + 1);
            canvas.drawRect(x_, p);
            if (count != 0)
                canvas.drawText(count + "", getWidth() / 2.0f + 2.5f, i + 4.0f, p2);
            count--;
        }
        count = 0;
        //+ve y axis
        for (int i = getHeight() / 2; i > 0; i -= 20) {
            Rect x_ = new Rect();
            x_.set(0, i, getWidth(), i + 1);
            canvas.drawRect(x_, p);
            if (count != 0)
                canvas.drawText(count + "", getWidth() / 2.0f + 2.5f, i + 4.0f, p2);
            count++;
        }
        Rect y = new Rect();
        Rect x = new Rect();
        y.set(getWidth() / 2 - 1, 0, getWidth() / 2 + 1, getHeight());
        x.set(0, getHeight() / 2 - 1, getWidth(), getHeight() / 2 + 1);
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(y, p);
        canvas.drawRect(x, p);
    }

    private void drawNonPair(Canvas canvas) {
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) ((-(2.0 * hNonPair * i + 2.0 * gNonPair) + Math.sqrt((2.0 * hNonPair * i + 2.0 * gNonPair) * (2.0 * hNonPair * i + 2.0 * gNonPair) - 4.0 * aNonPair * (bNonPair * i * i + 2.0 * fNonPair * i + cNonPair))) / (2.0 * aNonPair));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) ((-(2.0 * hNonPair * i + 2.0 * gNonPair) - Math.sqrt((2.0 * hNonPair * i + 2.0 * gNonPair) * (2.0 * hNonPair * i + 2.0 * gNonPair) - 4.0 * aNonPair * (bNonPair * i * i + 2.0 * fNonPair * i + cNonPair))) / (2.0 * aNonPair));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
    }

    private void drawCircle(Canvas canvas) {
        red.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((float) (getWidth() / 2 + hCircle * 20), invertY((float) kCircle), (float) rCircle * 20, red);
    }

    //--------------------------------------------------------------------------------------
    private void drawXParabola(Canvas canvas) {
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) (kXParabola + Math.sqrt(aXParabola * xCoor - aXParabola * hXParabola));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) (kXParabola - Math.sqrt(aXParabola * xCoor - aXParabola * hXParabola));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
    }

    private void drawYParabola(Canvas canvas) {
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (hYParabola + Math.sqrt(aYParabola * yCoor - aYParabola * kYParabola));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (hYParabola - Math.sqrt(aYParabola * yCoor - aYParabola * kYParabola));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
    }

    private void drawGenXPara(Canvas canvas) {
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) (0.5 * (-eGenXPara + Math.sqrt(eGenXPara * eGenXPara - 4 * (dGenXPara * xCoor + fGenXPara))));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) (0.5 * (-eGenXPara - Math.sqrt(eGenXPara * eGenXPara - 4 * (dGenXPara * xCoor + fGenXPara))));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
    }

    private void drawGenYPara(Canvas canvas) {
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (0.5 * (-dGenYPara + Math.sqrt(dGenYPara * dGenYPara - 4 * (eGenYPara * yCoor + fGenYPara))));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (0.5 * (-dGenYPara - Math.sqrt(dGenYPara * dGenYPara - 4 * (eGenYPara * yCoor + fGenYPara))));
            canvas.drawPoint((xCoor * 20 + getWidth() / 2f), invertY(yCoor), red);
        }
    }

    //-------------------------------------------------------------------------------
    private void drawStandardEllipse(Canvas canvas) {
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (aStandardEllipse * Math.sqrt(1 - (yCoor * yCoor) / (bStandardEllipse * bStandardEllipse)));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (-aStandardEllipse * Math.sqrt(1 - (yCoor * yCoor) / (bStandardEllipse * bStandardEllipse)));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
    }

    private void drawGeneralEllipse(Canvas canvas) {
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) ((-dGeneralEllipse - Math.sqrt(dGeneralEllipse * dGeneralEllipse - 4 * aGeneralEllipse * (bGeneralEllipse * yCoor * yCoor + eGeneralEllipse * yCoor + fGeneralEllipse))) / (2 * aGeneralEllipse));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) ((-dGeneralEllipse + Math.sqrt(dGeneralEllipse * dGeneralEllipse - 4 * aGeneralEllipse * (bGeneralEllipse * yCoor * yCoor + eGeneralEllipse * yCoor + fGeneralEllipse))) / (2 * aGeneralEllipse));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
    }

    private void drawGeneralHyperbola(Canvas canvas) {
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) ((-dGeneralHyperbola - Math.sqrt(dGeneralHyperbola * dGeneralHyperbola - 4 * aGeneralHyperbola * (bGeneralHyperbola * yCoor * yCoor + eGeneralHyperbola * yCoor + fGeneralHyperbola))) / (2 * aGeneralHyperbola));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) ((-dGeneralHyperbola + Math.sqrt(dGeneralHyperbola * dGeneralHyperbola - 4 * aGeneralHyperbola * (bGeneralHyperbola * yCoor * yCoor + eGeneralHyperbola * yCoor + fGeneralHyperbola))) / (2 * aGeneralHyperbola));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
    }

    private void drawXHyperbola(Canvas canvas) {
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (aXHyperbola * Math.sqrt(1 + (yCoor * yCoor) / (bXHyperbola * bXHyperbola)));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
        for (float i = -getHeight(); i < getHeight(); i += 0.05) {
            yCoor = i;
            xCoor = (float) (-aXHyperbola * Math.sqrt(1 + (yCoor * yCoor) / (bXHyperbola * bXHyperbola)));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
    }

    private void drawYHyperbola(Canvas canvas) {
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) (bYHyperbola * Math.sqrt(1 + (xCoor * xCoor) / (aYHyperbola * aYHyperbola)));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
        for (float i = -getWidth(); i < getWidth(); i += 0.05) {
            xCoor = i;
            yCoor = (float) (-bYHyperbola * Math.sqrt(1 + (xCoor * xCoor) / (aYHyperbola * aYHyperbola)));
            canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
        }
    }

    private void drawGeneral(Canvas canvas) {
        if (aGeneral != 0) {
            for (float i = -getHeight(); i < getHeight(); i += 0.05) {
                yCoor = i;
                xCoor = (float) ((-(hGeneral * i + gGeneral) + Math.sqrt((hGeneral * i + gGeneral) * (hGeneral * i + gGeneral) - 4.0 * aGeneral * (bGeneral * i * i + fGeneral * i + cGeneral))) / (2.0 * aGeneral));
                canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
            }
            for (float i = -getHeight(); i < getHeight(); i += 0.05) {
                yCoor = i;
                xCoor = (float) ((-(hGeneral * i + gGeneral) - Math.sqrt((hGeneral * i + gGeneral) * (hGeneral * i + gGeneral) - 4.0 * aGeneral * (bGeneral * i * i + fGeneral * i + cGeneral))) / (2.0 * aGeneral));
                canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
            }
        } else if (bGeneral != 0) {
            for (float i = -getWidth(); i < getWidth(); i += 0.05) {
                xCoor = i;
                yCoor = (float) ((-(hGeneral * i + fGeneral) + Math.sqrt((hGeneral * i + fGeneral) * (hGeneral * i + fGeneral) - 4.0 * bGeneral * (aGeneral * i * i + gGeneral * i + cGeneral))) / (2.0 * bGeneral));
                canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
            }
            for (float i = -getWidth(); i < getWidth(); i += 0.05) {
                xCoor = i;
                yCoor = (float) ((-(hGeneral * i + fGeneral) - Math.sqrt((hGeneral * i + fGeneral) * (hGeneral * i + fGeneral) - 4.0 * bGeneral * (aGeneral * i * i + gGeneral * i + cGeneral))) / (2.0 * bGeneral));
                canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
            }
        } else {
            for (float i = -getHeight(); i < getHeight(); i += 0.05) {
                yCoor = i;
                xCoor = (float) (-(fGeneral * i + cGeneral) / (hGeneral * i + gGeneral));
                canvas.drawPoint(xCoor * 20 + getWidth() / 2f, invertY(yCoor), red);
            }
        }

    }
}
