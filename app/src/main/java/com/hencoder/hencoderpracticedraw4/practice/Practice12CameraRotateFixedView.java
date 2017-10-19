package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
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
    Point point3 = new Point(1000, 200);

    Matrix oMatrix = new Matrix();
    Camera oCamera = new Camera();

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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        int centerX1 = point1.x + bitmapWidth / 2;
        int centerY1 = point1.y + bitmapHeight / 2;
        int centerX2 = point2.x + bitmapWidth / 2;
        int centerY2 = point2.y + bitmapHeight / 2;
        int centerX3 = point3.x + bitmapWidth / 2;
        int centerY3 = point3.y = bitmapHeight / 2;


        oCamera.save();
        oMatrix.reset();
        oCamera.rotateX(30);
//        oCamera.rotateY(30);
//        oCamera.rotateZ(30);
        oCamera.getMatrix(oMatrix);
        oCamera.restore();

        oMatrix.preTranslate(-centerX1, -centerY1);
        oMatrix.postTranslate(centerX1, centerY1);
        canvas.save();
        canvas.concat(oMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        oCamera.save();
        oMatrix.reset();
        oCamera.rotateY(30);
        oCamera.getMatrix(oMatrix);
        oCamera.restore();

        oMatrix.preTranslate(-centerX2, -centerY2);
        oMatrix.postTranslate(centerX2, centerY2);

        canvas.save();
        canvas.concat(oMatrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

        oCamera.save();
        oMatrix.reset();
        oCamera.rotateZ(30);
        oCamera.getMatrix(oMatrix);
        oCamera.restore();

        oMatrix.preTranslate(-centerX3, -centerY3);
        oMatrix.postTranslate(centerX3, centerY3);

        canvas.save();
        canvas.concat(oMatrix);
        canvas.drawBitmap(bitmap, point3.x, point3.y, paint);
        canvas.restore();
    }
}
