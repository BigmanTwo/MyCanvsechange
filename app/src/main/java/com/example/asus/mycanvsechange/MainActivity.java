package com.example.asus.mycanvsechange;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private Button mButton1,mButton2,mButton3,mButton4,mButton5,mButton6;
    private  RadialGradient radialGradient;
    private SweepGradient sweepGradient;
    private BitmapShader bitmapShader;
    private  LinearGradient linearGradient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1=(Button)findViewById(R.id.linear_but);
        mButton2=(Button)findViewById(R.id.redia_but);
        mButton3=(Button)findViewById(R.id.sweep_but);
        mButton4=(Button)findViewById(R.id.bitmap_but);
        mButton5=(Button)findViewById(R.id.compose_but);
        mButton6=(Button)findViewById(R.id.picture_but);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        imageView=(ImageView)findViewById(R.id.image);
        radialGradient=new RadialGradient(100,100,20,Color.BLUE,Color.BLACK, Shader.TileMode.REPEAT);
        sweepGradient=new SweepGradient(100,100,Color.GREEN,Color.RED);
        bitmapShader=new BitmapShader( ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap(), Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
         linearGradient=new LinearGradient(0,0,100,0, Color.BLUE,Color.GREEN, Shader.TileMode.CLAMP);
    }
    private void getGradient(){

        Bitmap bitmap=Bitmap.createBitmap(imageView.getWidth()/2,imageView.getHeight()/2, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint();
        paint.setStrokeWidth(50);
        paint.setShader(linearGradient);
        canvas.drawLine(0,0,imageView.getWidth(),0,paint);
        imageView.setImageBitmap(bitmap);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.linear_but:
                getGradient();
                break;
            case R.id.redia_but:
                getRadial();
                break;
            case R.id.sweep_but:
                getSweep();
                break;
            case R.id.bitmap_but:
                getShader();
                break;
            case R.id.compose_but:
                getCompose();
               break;
            case R.id.picture_but:
                Intent intent=new Intent(MainActivity.this,MatrixActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void getCompose() {
        ComposeShader composeShader=new ComposeShader(radialGradient, linearGradient, PorterDuff.Mode.MULTIPLY);
        Bitmap bitmap=Bitmap.createBitmap(imageView.getWidth()/2,imageView.getHeight()/2, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint();
        paint.setStrokeWidth(50);
        paint.setShader(composeShader);
        canvas.drawCircle(100,100,100,paint);
        imageView.setImageBitmap(bitmap);
    }

    private void getRadial() {

        Bitmap bitmap=Bitmap.createBitmap(imageView.getWidth()/2,imageView.getHeight()/2, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint();
        paint.setStrokeWidth(50);
        paint.setShader(radialGradient);
        canvas.drawCircle(100,100,100,paint);
        imageView.setImageBitmap(bitmap);
    }
    private void getSweep(){

        Bitmap bitmap=Bitmap.createBitmap(imageView.getWidth()/2,imageView.getHeight()/2, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint();
        paint.setStrokeWidth(50);
        paint.setShader(sweepGradient);
        canvas.drawCircle(100,100,100,paint);
        imageView.setImageBitmap(bitmap);
    }
    private void getShader(){

        Bitmap bitmap=Bitmap.createBitmap(imageView.getWidth()/2,imageView.getHeight()/2, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint();
        paint.setStrokeWidth(20);
        paint.setShader(bitmapShader);
        canvas.drawCircle(100,100,100,paint);
        imageView.setImageBitmap(bitmap);
    }

}
