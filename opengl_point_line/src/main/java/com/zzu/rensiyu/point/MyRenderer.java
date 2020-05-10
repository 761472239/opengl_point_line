package com.zzu.rensiyu.point;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * @author 76147
 */
public class MyRenderer implements GLSurfaceView.Renderer {

    float[] point = new float[]{
            0f, 0f, 0f
    };
    float[] line = new float[]{
            0f, 0.6f, 0f,
            0f,0f,0f,
            0.6f, 0f, 0f,
    };

    /*float[] line = new float[]{
           -0.6f,0.6f,0f,
            -0.2f,0f,0f,
            0.2f,0.6f,0f,
            0.6f,0f,0f
    };
*/

    private FloatBuffer pointData;
    private FloatBuffer lineData;

    public MyRenderer() {
        pointData = floatBufferUtil(point);
        lineData = floatBufferUtil(line);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glClearColor(0, 0, 1, 0);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // 启用顶点坐标数据1
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);


        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, pointData);
        gl.glColor4f(0, 1, 0, 0);
        gl.glPointSize(50f);
        gl.glDrawArrays(GL10.GL_POINTS, 0, 1);

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, lineData);
        gl.glColor4f(0, 1, 0, 0);
        gl.glLineWidth(5f);
        gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, 3);

        gl.glFinish();
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    // 定义一个工具方法，将int[]数组转换为OpenGL ES所需的IntBuffer
    private IntBuffer intBufferUtil(int[] arr) {
        IntBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        // 数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());
        mBuffer = qbb.asIntBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }

    // 定义一个工具方法，将float[]数组转换为OpenGL ES所需的FloatBuffer
    private FloatBuffer floatBufferUtil(float[] arr) {
        FloatBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        // 数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());
        mBuffer = qbb.asFloatBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }
}
