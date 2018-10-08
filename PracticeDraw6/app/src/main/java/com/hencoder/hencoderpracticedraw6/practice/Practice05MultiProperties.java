package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    private final int P = 100, N = 101;
    private int expectAction = P;
    private int mScreenWidth;

    public Practice05MultiProperties(Context context) {
        this(context, null);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                switch (expectAction) {
                    case P:
                        expectAction = N;
                        imageView.animate()
                                .translationX(mScreenWidth >> 1)
                        .alpha(1)
                        .scaleX(1)
                        .scaleY(1)
                        .rotation(360);
                        break;
                    case N:
                        expectAction = P;
                        imageView.animate()
                                .translationX(0)
                                .alpha(0)
                                .scaleX(0)
                                .scaleY(0)
                                .rotation(0);
                        break;
                }
            }
        });
    }
}
