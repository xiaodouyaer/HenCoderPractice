package com.sunnyxibei.hencoderpractice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 整个动画被拆分成为三个部分
     * 1、绕Y轴3D旋转45度
     * 2、绕Z轴3D旋转270度
     * 3、不变的那一半（上半部分）绕Y轴旋转30度（注意，这里canvas已经旋转了270度，计算第三个动效参数时要注意）
     */
    private void initView() {
        mapView = (MapView) findViewById(R.id.map_layout);

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mapView, "degreeY", 0, -45);
        animator1.setDuration(1000);
        animator1.setStartDelay(500);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mapView, "degreeZ", 0, 270);
        animator2.setDuration(800);
        animator2.setStartDelay(500);

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mapView, "fixDegreeY", 0, 30);
        animator3.setDuration(500);
        animator3.setStartDelay(500);

        final AnimatorSet set = new AnimatorSet();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mapView.reset();
                                set.start();
                            }
                        });
                    }
                }, 500);
            }
        });
        set.playSequentially(animator1, animator2, animator3);
        set.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.google_map:
                mapView.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.google_map));
                break;
            case R.id.flip_board:
                mapView.setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.flip_board));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
