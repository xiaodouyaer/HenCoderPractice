package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(20, 20);
    Point point2 = new Point(600, 20);
    Point point3 = new Point(20, 400);
    Point point4 = new Point(600, 400);
    Path path = new Path();
    int offset = 80;
    int radius = 140;
    private int right;
    private int bottom;

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        right = point1.x + bitmap.getWidth();
        bottom = point1.y + bitmap.getHeight();
        path.addCircle(right - offset, bottom - offset, radius, Path.Direction.CW);
        path.setFillType(Path.FillType.WINDING);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        right = point2.x + bitmap.getWidth();
        bottom = point2.y + bitmap.getHeight();
        path.addCircle(right - offset, bottom - offset, radius, Path.Direction.CW);//时针方向
        path.setFillType(Path.FillType.INVERSE_WINDING);//非0环绕原则
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

        canvas.save();
        right = point3.x + bitmap.getWidth();
        bottom = point3.y + bitmap.getHeight();
        path.addCircle(right - offset, bottom - offset, radius, Path.Direction.CCW);
        path.setFillType(Path.FillType.EVEN_ODD);//奇偶原则
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, point3.x, point3.y, paint);
        canvas.restore();

        canvas.save();
        right = point4.x + bitmap.getWidth();
        bottom = point4.y + bitmap.getHeight();
        path.addCircle(right - offset, bottom - offset, radius, Path.Direction.CCW);
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);//奇偶原则
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, point4.x, point4.y, paint);
        canvas.restore();
    }
}
