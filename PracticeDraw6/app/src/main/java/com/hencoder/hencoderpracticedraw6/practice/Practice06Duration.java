package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice06Duration extends LinearLayout {
    SeekBar durationSb;
    TextView durationValueTv;
    Button animateBt;
    ImageView imageView;
    private final int P = 100, N = 101;
    private int expectAction = P;

    int duration = 300;

    private int mScreenWidth;

    public Practice06Duration(Context context) {
        this(context, null);
    }

    public Practice06Duration(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice06Duration(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        durationSb = findViewById(R.id.durationSb);
        durationValueTv = findViewById(R.id.durationValueTv);
        durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
        durationSb.setMax(10);
        durationSb.setProgress(1);
        durationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duration = progress * 300;
                durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        animateBt = findViewById(R.id.animateBt);
        imageView = findViewById(R.id.imageView);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，执行动画。记得使用 `setDuration(duration)` 来设置动画的时长。
                switch (expectAction) {
                    case P:
                        expectAction = N;
                        imageView.animate()
                                .translationX(mScreenWidth >> 1)
                                .setDuration(duration);
                        break;
                    case N:
                        expectAction = P;
                        imageView.animate()
                                .translationX(0)
                                .setDuration(duration);
                        break;
                }
            }
        });
    }
}
