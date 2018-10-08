package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;
    private final int PX = 100, NX = 101, PY = 102, NY = 103;
    private int expectAction = PX;

    public Practice03Scale(Context context) {
        super(context);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);

        animateBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO 在这里处理点击事件，通过 View.animate().scaleX/Y() 来让 View 放缩
                animateBt.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
                        switch (expectAction) {
                            case PX:
                                expectAction = NX;
                                imageView.animate().scaleX(2);
                                break;
                            case NX:
                                expectAction = PY;
                                imageView.animate().scaleX(1);
                                break;
                            case PY:
                                expectAction = NY;
                                imageView.animate().scaleY(2);
                                break;
                            case NY:
                                expectAction = PX;
                                imageView.animate().scaleY(1);
                                break;
                        }
                    }
                });
            }
        });
    }
}
