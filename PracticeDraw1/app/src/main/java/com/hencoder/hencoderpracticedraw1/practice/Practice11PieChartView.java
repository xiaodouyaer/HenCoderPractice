package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private Path path;
    private Data[] titles;
    private RectF rectF;

    {
        titles = new Data[]{
                new Data("Froyo", "#00ff00", 0.01),
                new Data("Gingerbread", "#8000FF", 0.05),
                new Data("Ice Cream Sandwich", "#C0C0C0", 0.05),
                new Data("Jelly Bean", "#008000", 0.15),
                new Data("KitKat", "#0000ff", 0.28),
                new Data("Lollipop", "#ff0000", 0.14),
                new Data("Marshmallow", "#ffff00", 0.32),
        };
        rectF = new RectF();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
    }

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth = getWidth();
        viewHeight = getHeight();

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        int cX = viewWidth >> 1;
        int cY = viewHeight >> 1;

        rectF.set(cX - 200, cY - 200, cX + 200, cY + 200);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, 0, 360, true, paint);
    }

    private class Data {
        private String title;
        private String color;
        private double percent;

        public Data(String title, String color, double percent) {
            this.title = title;
            this.color = color;
            this.percent = percent;
        }
    }
}
