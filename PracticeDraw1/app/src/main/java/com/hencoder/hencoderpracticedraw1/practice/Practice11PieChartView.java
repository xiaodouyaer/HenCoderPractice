package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Arith;

public class Practice11PieChartView extends View {

    private final String TAG = getClass().getSimpleName();
    private int viewWidth;
    private int viewHeight;
    private Paint paint;
    private Path path;
    private Data[] titles;
    private RectF rectF;
    private int radius;

    {
        titles = new Data[]{
                new Data("Marshmallow", "#F9C100", 50),
                new Data("Froyo", "#00ff00", 4),
                new Data("Gingerbread", "#9726B3", 8),
                new Data("Ice Cream Sandwich", "#9E9E9E", 8),
                new Data("Jelly Bean", "#309688", 60),
                new Data("KitKat", "#4096F7", 100),
                new Data("Lollipop", "#EA422D", 130),
        };
        rectF = new RectF();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
        radius = 200;
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

        rectF.set(cX - radius, cY - radius, cX + radius, cY + radius);


        int startAngle = -titles[0].angle;
        for (Data data : titles) {
            paint.setColor(Color.parseColor(data.color));
            paint.setStyle(Paint.Style.FILL);
            if ("Lollipop".equals(data.title)) {
                double centerRadian = Math.PI * (startAngle + ((data.angle - 2) >> 1) - 180) / 180;//中心弧度
                double offsetX = 10;
                double offsetY = (int) (offsetX * Math.tan(centerRadian));
                rectF.offset(-(float) offsetX, -(float) offsetY);
                canvas.drawArc(rectF, startAngle, data.angle - 2, true, paint);
                startAngle += data.angle;

                double hypotenuse = Arith.div(offsetX, Math.cos(centerRadian), 9);
                double scale = Arith.div(hypotenuse, Arith.add(hypotenuse, radius), 9);
                double radianX = cX - Arith.div(offsetX, scale);
                double radianY = cY - Arith.div(offsetY, scale);

                paint.setColor(Color.WHITE);
                paint.setStyle(Paint.Style.STROKE);
                path.moveTo((float) (radianX - 3), (float) (radianY - 3));
                path.lineTo((float) (radianX - offsetX), (float) (radianY - offsetY));
                path.lineTo((float) (radianX - offsetX - 100), (float) (radianY - offsetY));
                canvas.drawPath(path, paint);

                paint.setTextSize(16);
                float measureText = paint.measureText(data.title);
                canvas.drawText(data.title, (float) (radianX - offsetX - 100 - measureText - 20), (float) (radianY - offsetY), paint);


                //测试一下drawText的x，y到底是什么坐标
                String test = "这是个测试位置的字符串";
                float testLen = paint.measureText(test);
                paint.setTextSize(30);
                Paint.FontMetrics fontMetrics0 = paint.getFontMetrics();
                Log.d(TAG, String.format(
                        "Paint.FontMetrics0{%f，%f，%f，%f，%f}",
                        fontMetrics0.top,
                        fontMetrics0.ascent,
                        fontMetrics0.descent,
                        fontMetrics0.bottom,
                        fontMetrics0.leading
                ));
                canvas.drawText(test, 0, 0, paint);
                canvas.drawText(test, 0, 100, paint);
                continue;
            }
            canvas.drawArc(rectF, startAngle, data.angle - 2, true, paint);
            startAngle += data.angle;
        }
    }

    private class Data {
        private String title;
        private String color;
        private int angle;

        public Data(String title, String color, int angle) {
            this.title = title;
            this.color = color;
            this.angle = angle;
        }
    }
}
