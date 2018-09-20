package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice6DrawLineView extends View {

    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private float[] firstPoint;
    private float[] secondPoint;
    private float[] thirdPoint;
    private float[] fourthPoint;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        firstPoint = new float[2];
        secondPoint = new float[2];
        thirdPoint = new float[2];
        fourthPoint = new float[2];

    }

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth = getWidth();
        viewHeight = getHeight();
//        练习内容：使用 canvas.drawLine() 方法画直线
        setPoint();

        paint.setColor(Color.RED);
        canvas.drawLine(firstPoint[0], firstPoint[1], secondPoint[0], secondPoint[1], paint);

        paint.setColor(Color.YELLOW);
        canvas.drawLine(secondPoint[0], secondPoint[1], thirdPoint[0], thirdPoint[1], paint);

        paint.setColor(Color.GREEN);
        canvas.drawLine(thirdPoint[0], thirdPoint[1], fourthPoint[0], fourthPoint[1], paint);

        paint.setColor(Color.BLUE);
        canvas.drawLine(fourthPoint[0], fourthPoint[1], firstPoint[0], firstPoint[1], paint);

    }

    private void setPoint() {
        firstPoint[0] = viewWidth >> 1;
        firstPoint[1] = viewHeight >> 2;

        secondPoint[0] = (viewWidth >> 1) + (viewWidth >> 2);
        secondPoint[1] = viewHeight >> 1;

        thirdPoint[0] = viewWidth >> 1;
        thirdPoint[1] = (viewHeight >> 1) + (viewHeight >> 2);

        fourthPoint[0] = viewWidth >> 2;
        fourthPoint[1] = viewHeight >> 1;
    }
}
