package com.zzu.rensiyu.point;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyRenderer myRenderer = new MyRenderer();
        GLSurfaceView surfaceView = new GLSurfaceView(this);
        surfaceView.setRenderer(myRenderer);
        setContentView(surfaceView);
    }
}
