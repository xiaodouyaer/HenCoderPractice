package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice02Rotation extends RelativeLayout {
    Button animateBt;
    Button animateBt2;
    ImageView imageView;

    private final int PX = 100, NX = 101, PY = 102, NY = 103, PZ = 104, NZ = 105;
    private int expectAction = PX;

    public Practice02Rotation(Context context) {
        super(context);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02Rotation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        animateBt2 = findViewById(R.id.animateBt2);
        imageView = findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (expectAction) {
                    case PX:
                        expectAction = NX;
                        imageView.animate().rotationX(180);
                        break;
                    case NX:
                        expectAction = PY;
                        imageView.animate().rotationX(0);
                        break;
                    case PY:
                        expectAction = NY;
                        imageView.animate().rotationY(180);
                        break;
                    case NY:
                        expectAction = PZ;
                        imageView.animate().rotationY(0);
                        break;
                    case PZ:
                        expectAction = NZ;
                        imageView.animate().rotation(180);//这个实际是绕Z轴旋转
                        break;
                    case NZ:
                        expectAction = PX;
                        imageView.animate().rotation(0);
                        break;
                }
            }
        });

        animateBt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                switch (expectAction) {
                    case PX:
                        expectAction = NX;
                        imageView.animate().rotationXBy(60);
                        break;
                    case NX:
                        expectAction = PY;
                        imageView.animate().rotationXBy(60);
                        break;
                    case PY:
                        expectAction = NY;
                        imageView.animate().rotationYBy(60);
                        break;
                    case NY:
                        expectAction = PZ;
                        imageView.animate().rotationYBy(60);
                        break;
                    case PZ:
                        expectAction = NZ;
                        imageView.animate().rotationBy(60);//这个实际是绕Z轴旋转
                        break;
                    case NZ:
                        expectAction = PX;
                        imageView.animate().rotationBy(60);
                        break;
                }
            }
        });
    }
}