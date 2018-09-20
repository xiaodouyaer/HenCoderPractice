package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    private int viewWidth;
    private int viewHeight;
    private Rect secondRect;
    private Paint paint;
    private int firstX;
    private int firstY;
    private int firstR;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        secondRect = new Rect();
    }

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        viewWidth = getWidth();
        viewHeight = getHeight();
        if (viewWidth != 0 && viewHeight != 0) {
            int width = (viewWidth >> 2) - 20;

            firstX = viewWidth >> 2;
            firstY = viewHeight >> 1;
            int w = firstX;
            int h = firstY;
            firstR = Math.min(w, h) - 20;

            int secondX = viewWidth - (viewWidth >> 2);
            int secondY = viewHeight >> 1;
            secondRect.set(secondX - width, secondY - width, secondX + width, secondY + width);
        }


        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(firstX, firstY, firstR, paint);
        paint.setColor(Color.RED);
        canvas.drawRect(secondRect, paint);
    }
}
