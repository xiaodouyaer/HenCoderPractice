package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice14GetFontMetricsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Rect rect = new Rect();
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;
    private Paint.FontMetrics fontMetrics;
    private float yOffsets;

    public Practice14GetFontMetricsView(Context context) {
        super(context);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        //本练习每个字位置移动的距离为每个字的ascent(建议不超过的上边界)和descent(建议不超过的下边界)所求出的中线距离，
        // 这对每一个字来说都是一样的
        //因为所有的字在文字线谱中的占用空间都是一样的，只是显示不一样而已
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(0);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        fontMetrics = paint2.getFontMetrics();
        yOffsets = -(fontMetrics.ascent + fontMetrics.descent) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);
        paint1.setStrokeWidth(0);
        canvas.drawLine(50, 300, getWidth() - 50, 300, paint1);

        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

        paint2.getTextBounds(texts[0], 0, texts[0].length(), rect);
        paint1.setColor(Color.GREEN);
        canvas.drawRect(rect, paint1);

        int middle = (top + bottom) / 2;
        canvas.drawText(texts[0], 100, middle + yOffsets, paint2);
        canvas.drawText(texts[1], 200, middle + yOffsets, paint2);
        canvas.drawText(texts[2], 300, middle + yOffsets, paint2);
        canvas.drawText(texts[3], 400, middle + yOffsets, paint2);
        canvas.drawText(texts[4], 500, middle + yOffsets, paint2);
        canvas.drawText(texts[5], 600, middle + yOffsets, paint2);
    }
}
