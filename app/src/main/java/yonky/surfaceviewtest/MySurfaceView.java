package yonky.surfaceviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by Administrator on 2018/4/23.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    SurfaceHolder mHolder;
    Canvas mCanvas;
    Boolean mIsDrawing;
    int x,y;
    Path mPath;
    private Paint mPaint= new Paint(Paint.ANTI_ALIAS_FLAG);


    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, null);
    }

    private void init(){
        mHolder = getHolder();
        mHolder.addCallback(this);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPath=new Path();
        Log.d("mySurfaceView","init...");

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        Log.d("mySurfaceView","start the thread");
        while(mIsDrawing){

            draw();
            x+=1;
            y=(int)(100*Math.sin(x*Math.PI/180)+400);
            mPath.lineTo(x,y);
        }
    }

    private void draw(){
        try {

            mCanvas = mHolder.lockCanvas();
            mCanvas.drawColor(Color.WHITE);
            mCanvas.drawPath(mPath, mPaint);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(mCanvas !=null){
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }


    }
}
