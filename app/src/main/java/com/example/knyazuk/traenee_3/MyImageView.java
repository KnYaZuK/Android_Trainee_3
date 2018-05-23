package com.example.knyazuk.traenee_3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyImageView extends View {

    private Paint paint;

    private int startX;
    private int startY;
    private int startSize;

    public MyImageView(Context context) {
        super(context);

        initView();
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (startX == 0 || startY == 0) {
            startX = canvas.getWidth() / 2;
            startY = canvas.getHeight() / 2;
        }

        drawFigure(canvas, startX, startY, startSize);
    }

    public void setStartPoint(int x, int y) {
        startX = x;
        startY = y;

        invalidate();
        requestLayout();
    }

    public void incSize() {
        startSize *= 1.05;

        invalidate();
        requestLayout();
    }

    public void decSize() {
        startSize *= 0.95;

        invalidate();
        requestLayout();
    }

    private void initView() {
        paint = new Paint();

        startSize = 150;
    }

    private void drawFigure(Canvas canvas, int x, int y, int size) {
        canvas.drawLine(x, y, x, y - size, paint);
        canvas.drawLine(x, y, x - size, y + size, paint);
        canvas.drawLine(x, y, x + size, y + size, paint);

        if (size > 5) {
            drawFigure(canvas, x, y - size, size / 2);
            drawFigure(canvas, x - size, y + size, size / 2);
            drawFigure(canvas, x + size, y + size, size / 2);
        }
    }
}
