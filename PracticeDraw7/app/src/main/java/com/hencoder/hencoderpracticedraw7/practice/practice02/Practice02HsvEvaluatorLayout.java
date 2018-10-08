package com.hencoder.hencoderpracticedraw7.practice.practice02;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

public class Practice02HsvEvaluatorLayout extends RelativeLayout {
    Practice02HsvEvaluatorView view;
    Button animateBt;

    public Practice02HsvEvaluatorLayout(Context context) {
        super(context);
    }

    public Practice02HsvEvaluatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02HsvEvaluatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
                ObjectAnimator animator = ObjectAnimator.ofInt(view, "color", 0xffff0000, 0xff00ff00);
                animator.setEvaluator(new HsvEvaluator()); // 使用自定义的 HsvEvaluator
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(2000);
                animator.start();
            }
        });
    }

    private class HsvEvaluator implements TypeEvaluator<Integer> {
        float[] startHSV = new float[3];
        float[] endHSV = new float[3];
        float[] outHSV = new float[3];

        // 重写 evaluate() 方法，让颜色按照 HSV 来变化
        //1、HSV(Hue, Saturation, Value)是根据颜色的直观特性由
        // A. R. Smith在1978年创建的一种颜色空间, 也称六角锥体模型(Hexcone Model)。
        // 这个模型中颜色的参数分别是：色调（H），饱和度（S），明度（V）。

        //色调H
        //用角度度量，取值范围为0°～360°，从红色开始按逆时针方向计算，
        // 红色为0°，绿色为120°,蓝色为240°。它们的补色是：黄色为60°，
        // 青色为180°,品红为300°；

        //饱和度S
        //饱和度S表示颜色接近光谱色的程度。一种颜色，
        // 可以看成是某种光谱色与白色混合的结果。其中光谱色所占的比例愈大，
        // 颜色接近光谱色的程度就愈高，颜色的饱和度也就愈高。饱和度高，颜色则深而艳。
        // 光谱色的白光成分为0，饱和度达到最高。通常取值范围为0%～100%，值越大，颜色越饱和。

        //明度V
        //明度表示颜色明亮的程度，对于光源色，明度值与发光体的光亮度有关；对于物体色，此值和物体的透射比或反射比有关。通常取值范围为0%（黑）到100%（白）。
        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            Color.colorToHSV(startValue, startHSV);
            Color.colorToHSV(endValue, endHSV);

            outHSV[0] = (endHSV[0] - startHSV[0]) * fraction + startHSV[0];
            outHSV[1] = (endHSV[1] - startHSV[1]) * fraction + startHSV[1];
            outHSV[2] = (endHSV[2] - startHSV[2]) * fraction + startHSV[2];

            // 计算当前动画完成度（fraction）所对应的透明度
            int alpha = startValue >> 24 + (int) ((endValue >> 24 - startValue >> 24) * fraction);

            return Color.HSVToColor(alpha, outHSV);
        }
    }
}
