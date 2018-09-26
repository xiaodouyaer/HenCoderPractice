package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private LinearGradient linearGradient1;
    private LinearGradient linearGradient2;

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        linearGradient1 = new LinearGradient(100, 100, 500, 500,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP);
        linearGradient2 = new LinearGradient(1000, 100, 600, 500,
                Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),
                Shader.TileMode.CLAMP);
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setShader(linearGradient1);
        canvas.drawCircle(300, 300, 200, paint);
        paint.setShader(linearGradient2);
        canvas.drawCircle(800, 300, 200, paint);

        paint.setShader(null);
        paint.setColor(Color.GREEN);
        drawL(canvas);
        paint.setColor(Color.RED);
        drawL(canvas);
        paint.setColor(Color.BLUE);
        drawL(canvas);
        paint.setColor(Color.YELLOW);
        drawL(canvas);

    }

    public void drawL(Canvas canvas){
        canvas.rotate(90, 300, 300);
        canvas.drawLine(300, 100, 100, 300, paint);
        canvas.drawLine(300, 100, 300, 300, paint);
    }
}
