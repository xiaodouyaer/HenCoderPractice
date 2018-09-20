package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private Path path;
    private int radius;//心瓣半径
    private RectF rectF;

    {
        radius = 1 << 7;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
        rectF = new RectF();
    }

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth = getWidth();
        viewHeight = getHeight();

        /*
         * 以心的两瓣交点处未起点，将此起点定到view中点
         * */
        float cX = viewWidth >> 1;
        float cY = viewHeight >> 1;

        /*
         * 心形每瓣均为（180+45） 度的圆弧，心尖儿点计算
         * */

        float hTineX = viewWidth >> 1;
        float hTineY = (float) (cY + radius * Math.tan(0.375 * Math.PI));// 3π/4 的一半

        rectF.set(cX - 2 * radius, cY - radius, cX, cY + radius);
        path.addArc(rectF, -225, 225);

        rectF.set(cX, cY - radius, cX + 2 * radius, cY + radius);
        path.arcTo(rectF, -180, 225,false);

        path.lineTo(hTineX, hTineY);


//        练习内容：使用 canvas.drawPath() 方法画心形

        canvas.drawPath(path, paint);
    }
}
