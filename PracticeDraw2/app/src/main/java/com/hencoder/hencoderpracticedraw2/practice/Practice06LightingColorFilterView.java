package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    private LightingColorFilter colorFilter1;
    private LightingColorFilter colorFilter2;

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);

        /**计算规则，见{@link LightingColorFilter}
         * R' = R * colorMultiply.R + colorAdd.R
         * G' = G * colorMultiply.G + colorAdd.G
         * B' = B * colorMultiply.B + colorAdd.B
         * */
        colorFilter1 = new LightingColorFilter(0x00ffff, 0x000000);

        colorFilter2 = new LightingColorFilter(0xffffff, 0x009900);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        paint.setColorFilter(colorFilter1);
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap, 0, 0, paint);

        paint.setColorFilter(colorFilter2);
        // 第二个 LightingColorFilter：增强绿色部分
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
