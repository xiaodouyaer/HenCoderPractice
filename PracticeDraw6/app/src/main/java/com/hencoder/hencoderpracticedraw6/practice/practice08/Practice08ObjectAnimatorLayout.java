package com.hencoder.hencoderpracticedraw6.practice.practice08;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice08ObjectAnimatorLayout extends RelativeLayout {
    Practice08ObjectAnimatorView view;
    Button animateBt;

    private final int P = 100, N = 101;
    private int expectAction = P;
    private ObjectAnimator objectAnimator;

    public Practice08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = findViewById(R.id.objectAnimatorView);
        animateBt = findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，用 ObjectAnimator 播放动画
                // 1. 用 ObjectAnimator 创建 Animator 对象
                // 2. 用 start() 执行动画
                // *. 记得在 Practice08ObjectAnimatorView 中为 progress 添加 setter/ getter 方法！
                switch (expectAction) {
                    case P:
                        expectAction = N;
                        objectAnimator = ObjectAnimator.ofFloat(view, "progress", 0, 75);
                        break;
                    case N:
                        expectAction = P;
                        objectAnimator = ObjectAnimator.ofFloat(view, "progress", 75, 0);
                        break;
                }
                objectAnimator.setDuration(500);
                objectAnimator.setInterpolator(new FastOutSlowInInterpolator());
                objectAnimator.start();
            }
        });
    }
}
