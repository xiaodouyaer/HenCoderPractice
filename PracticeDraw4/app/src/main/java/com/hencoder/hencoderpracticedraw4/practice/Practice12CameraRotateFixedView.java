package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    private Camera camera;
    private int cx;
    private int cy;

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        camera = new Camera();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        camera.save();
        cx = point1.x + (bitmap.getWidth() >> 1);
        cy = point1.y + (bitmap.getHeight() >> 1);
        canvas.translate(cx, cy);//将画布中心移动到图中心进行变换操作
        camera.rotateX(30);
        camera.applyToCanvas(canvas);
        canvas.translate(-cx, -cy);//操作完成后再将画布中心移回原点
        camera.restore();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        camera.save();
        cx = point2.x + (bitmap.getWidth() >> 1);
        cy = point2.y + (bitmap.getHeight() >> 1);
        canvas.translate(cx, cy);//将画布中心移动到图中心进行变换操作
        camera.rotateY(30);
        camera.applyToCanvas(canvas);
        canvas.translate(-cx, -cy);//操作完成后再将画布中心移回原点
        camera.restore();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
