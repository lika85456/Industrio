package com.lika85456.industrio.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lika85456.industrio.R;

import static com.lika85456.industrio.View.MapView.drawableToBitmap;

public class Joystick extends View {

    private Bitmap arrow = drawableToBitmap(ResourcesCompat.getDrawable(getResources(), R.drawable.triangle_menu_button_clicked, null));
    private Paint paint = new Paint();

    public Joystick(Context context) {
        super(context);
    }

    public Joystick(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Joystick(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        Rect rect1 = new Rect((int) (width / 3f), 0, (int) (width / 3f * 2f), (int) (height / 3f * 2f));
        Rect rect2 = new Rect(0, (int) (height / 3f), (int) (width / 3f), (int) (height / 3f * 2f));
        Rect rect3 = new Rect((int) (width / 3f * 2f), (int) (height / 3f), (int) (width / 3f), (int) (height / 3f * 2f));
        Rect rect4 = new Rect((int) (width / 3f), (int) (height / 3f * 2f), (int) (width / 3f * 2f), height);

        canvas.drawBitmap(arrow, null, rect1, paint);
        canvas.save();
        canvas.rotate(90f);
        canvas.translate(width / 2, height / 2);
        canvas.drawBitmap(arrow, null, rect2, paint);
        canvas.rotate(90f);
        canvas.drawBitmap(arrow, null, rect3, paint);
        canvas.rotate(90f);
        canvas.drawBitmap(arrow, null, rect4, paint);
        canvas.restore();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
