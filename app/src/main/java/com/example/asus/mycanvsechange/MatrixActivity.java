package com.example.asus.mycanvsechange;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MatrixActivity extends AppCompatActivity {
    private TestView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        testView = (TestView) findViewById(R.id.testview);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ttt);
        testView.setmBitmap(bitmap);

        ((Button) findViewById(R.id.button_rotate))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        testView.rotate(15);
                    }
                });
        ((Button) findViewById(R.id.button_scale))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        testView.scale(0.8f, 0.8f);
                    }
                });
        ((Button) findViewById(R.id.button_translate))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        testView.translate(1, 1);
                    }
                });
        ((Button) findViewById(R.id.button_skew))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        testView.skew(-0.3f, 0.3f);
                    }
                });
        ((Button) findViewById(R.id.button_mirror))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        testView.mirror();
                    }
                });
        ((Button) findViewById(R.id.button_shadow))
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        testView.shadow();
                    }
                });
    }


}



