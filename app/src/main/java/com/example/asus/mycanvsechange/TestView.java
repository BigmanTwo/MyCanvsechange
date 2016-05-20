package com.example.asus.mycanvsechange;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Asus on 2016/5/20.
 */
public class TestView extends View {
    private Bitmap mBitmap;
    private Matrix matrix;
    public TestView(Context context) {
        super(context);
        matrix=new Matrix();
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        matrix=new Matrix();
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        matrix=new Matrix();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TestView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        matrix=new Matrix();
    }
    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, matrix, null);
        }
    }

    public void rotate(float degree) {
        if (mBitmap != null) {
            matrix.preRotate(degree, mBitmap.getWidth() / 2,
                    mBitmap.getHeight() / 2);
            invalidate();
        }

    }

    public void translate(float dx, float dy) {
        if (mBitmap != null) {
            matrix.postTranslate(dx, dy);
            invalidate();
        }
    }

    public void scale(float sx, float sy) {
        if (mBitmap != null) {
            matrix.postScale(sx, sy);
            invalidate();
        }
    }

    public void mirror() {
        if (mBitmap != null) {
            matrix.postScale(-1, 1);
            matrix.postTranslate(mBitmap.getWidth(), 0);
            invalidate();
        }
    }

    public void shadow() {
        if (mBitmap != null) {
            matrix.postScale(1, -1);
            matrix.postTranslate(0, mBitmap.getHeight());
            invalidate();
        }
    }

    public void skew(float kx, float ky){
        if (mBitmap != null) {
            matrix.postSkew(kx, ky);
            invalidate();
        }
    }
}
