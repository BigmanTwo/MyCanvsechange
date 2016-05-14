package com.example.asus.mycanvsechange;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MatrixActivity extends AppCompatActivity {
    private ImageView imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        imageView1=(ImageView)findViewById(R.id.matrix_image);
        imageView2=(ImageView)findViewById(R.id.matrix_image2);
    }
    private void translate(){
        Bitmap bitmap=Bitmap.createBitmap(imageView1.getWidth(),imageView1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Matrix matrix=new Matrix();
        matrix.postTranslate(imageView1.getWidth()/5,0);
        canvas.drawBitmap(bitmap,matrix,null);
        imageView2.setImageBitmap(bitmap);
    }
}
