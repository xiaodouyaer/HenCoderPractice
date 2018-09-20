package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private Path path;
    private String title;
    private Data[] titles;

    {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
        title = "直方图";
        titles = new Data[]{
                new Data("Froyo", 20),
                new Data("GB", 60),
                new Data("ICS", 60),
                new Data("JB", 200),
                new Data("KitKat", 320),
                new Data("L", 400),
                new Data("M", 200)};
    }

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        viewWidth = getWidth();
        viewHeight = getHeight();

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        /*
         * 线框
         * */
        paint.setColor(Color.WHITE);
        canvas.drawLine(200, 200, 200, viewHeight - 200, paint);
        canvas.drawLine(200, viewHeight - 200, viewWidth - 200, viewHeight - 200, paint);

        /*
         * 文字
         * */
        paint.setTextSize(40);
        int textLen = (int) paint.measureText(title);
        canvas.drawText(title, (viewWidth - textLen) >> 1, viewHeight - 50, paint);

        int space = 20;
        int pillarWidth = (viewWidth - 400 - space * (titles.length + 1)) / titles.length;

        int startX = 200;
        int startY = viewHeight - 200;
        paint.setTextSize(16);
        paint.setStyle(Paint.Style.FILL);
        startX += (space + (pillarWidth >> 1));
        for (Data s : titles) {
            /*
             * 小标题
             * */
            paint.setColor(Color.WHITE);
            textLen = (int) paint.measureText(s.title);
            canvas.drawText(s.title, startX - (textLen >> 1), startY + 20, paint);

            /*
             * 柱子
             * */
            paint.setColor(Color.GREEN);
            canvas.drawRect(startX - (pillarWidth >> 1), startY - s.num, startX + (pillarWidth >> 1), startY, paint);

            startX += (space + pillarWidth);
        }
    }

    private class Data {
        private String title;
        private int num;

        private Data(String title, int num) {
            this.title = title;
            this.num = num;
        }
    }
}
