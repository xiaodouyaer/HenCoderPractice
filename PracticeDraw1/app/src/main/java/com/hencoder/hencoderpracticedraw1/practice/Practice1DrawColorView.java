package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice1DrawColorView extends View {

    private int color;

    public Practice1DrawColorView(Context context) {
        this(context,null);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Practice1DrawColorView);
        color = typedArray.getColor(R.styleable.Practice1DrawColorView_bg_color, Color.YELLOW);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
//        黄色： Color.YELLOW
        canvas.drawColor(color);
    }
}
