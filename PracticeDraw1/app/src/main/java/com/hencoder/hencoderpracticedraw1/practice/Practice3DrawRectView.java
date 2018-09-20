package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    private int viewWidth;
    private int viewHeight;
    private Rect firstRect;
    private Rect secondRect;
    private Paint paint;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        firstRect = new Rect();
        secondRect = new Rect();
    }

    public Practice3DrawRectView(Context context) {
        this(context, null);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth = getWidth();
        viewHeight = getHeight();
        if (viewWidth != 0 && viewHeight != 0) {
            int width = (viewWidth >> 2) - 20;

            int firstX = viewWidth >> 2;
            int firstY = viewHeight >> 1;
            firstRect.set(firstX - width, firstY - width, firstX + width, firstY + width);

            int secondX = viewWidth - (viewWidth >> 2);
            int secondY = viewHeight >> 1;
            secondRect.set(secondX - width, secondY - width, secondX + width, secondY + width);
        }
//        练习内容：使用 canvas.drawRect() 方法画矩形

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawRect(firstRect, paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(secondRect, paint);
    }
}
