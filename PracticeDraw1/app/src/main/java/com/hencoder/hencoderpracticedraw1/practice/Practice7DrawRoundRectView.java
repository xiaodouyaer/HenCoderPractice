package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice7DrawRoundRectView extends View {

    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private RectF rect;

    {
        rect = new RectF();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth = getWidth();
        viewHeight = getHeight();

        rect.set(100, 100, viewWidth - 100, viewHeight - 100);
//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        paint.setColor(Color.parseColor("#303F9F"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(rect,50,200,paint);

        rect.set(200, 200, viewWidth - 200, viewHeight - 200);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(rect,100,100,paint);
    }
}
