package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private float mRadius;
    private float[] firstXY;
    private float[] secondXY;
    private float[] thirdXY;
    private float[] fourthXY;
    private Paint paint;
    private boolean inited;
    private int viewWidth;
    private int viewHeight;
    private int mScreenWidth;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        firstXY = new float[2];
        secondXY = new float[2];
        thirdXY = new float[2];
        fourthXY = new float[2];
    }

    public Practice2DrawCircleView(Context context) {
        this(context, null);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("Practice2DrawCircleView", "View的宽：" + getWidth() + ",高：" + getHeight());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth = getWidth();
        viewHeight = getHeight();
        if (!inited){
            initLocation();
        }

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(firstXY[0], firstXY[1], mRadius, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(secondXY[0], secondXY[1], mRadius, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(thirdXY[0], thirdXY[1], mRadius, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(50);
        canvas.drawCircle(fourthXY[0], fourthXY[1], mRadius, paint);
    }

    private void initLocation() {
        inited = true;
        if (viewWidth == 0){
            viewWidth = mScreenWidth;
        }
        if (viewHeight == 0){
            viewHeight = mScreenWidth;
        }
        mRadius = (Math.min(viewWidth,viewHeight) >> 2) - 40;
        firstXY[0] = (viewWidth >> 2);
        firstXY[1] = (viewHeight >> 2);
        secondXY[0] = viewWidth - (viewWidth >> 2);
        secondXY[1] = (viewHeight >> 2);
        thirdXY[0] = (viewWidth >> 2);
        thirdXY[1] = viewHeight - (viewHeight >> 2);
        fourthXY[0] = viewWidth - (viewWidth >> 2);
        fourthXY[1] = viewHeight - (viewHeight >> 2);
    }
}
