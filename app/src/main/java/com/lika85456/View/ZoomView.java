package com.lika85456.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/***
 * Simple zoomview
 * zooming to/from center
 * has ONLY one child, wich is zoomed
 */
public class ZoomView extends LinearLayout {


    private final Matrix m = new Matrix();
    private float zoom = 0.3f;
    private boolean pinching;
    private float minZoom = 0.1f;
    private float maxZoom = 1f;
    private float lastd = 0;
    private float smoothZoom = 1f;
    private float startd = 0f;

    public ZoomView(Context context) {
        super(context);
    }

    public ZoomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZoomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int w, int h) {
        int width = MeasureSpec.getSize(w);
        int height = MeasureSpec.getSize(h);

        setMeasuredDimension(width, height);
    }

    public void onLayout(boolean c, int i, int i1, int i2, int i3) {
        if (c) {
            getChildAt(0).layout(i, i1, i2, i3);
        }
    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        // // double touch
        if (ev.getPointerCount() == 2) {
            processDoubleTouchEvent(ev);
        }

        // redraw
        getRootView().invalidate();
        invalidate();

        return true;
    }

    private void processDoubleTouchEvent(final MotionEvent ev) {
        final float x1 = ev.getX(0);
        final float y1 = ev.getY(0);
        final float x2 = ev.getX(1);
        final float y2 = ev.getY(1);


        // pointers distance
        final float d = (float) Math.hypot(x2 - x1, y2 - y1);
        float dd = d - lastd;
        if (startd == 0) startd = d;


        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                pinching = false;
                break;

            case MotionEvent.ACTION_MOVE:
                if (pinching || Math.abs(startd - d) > 10.0f) {
                    pinching = true;

                    smoothZoom = clamp(minZoom, smoothZoom * (d / (d - dd)), maxZoom);

                }


                break;

            case MotionEvent.ACTION_UP:
                pinching = false;
                startd = 0;
                lastd = 0;
                break;
            default:
                pinching = false;
                break;
        }
        lastd = d;
        ev.setAction(MotionEvent.ACTION_CANCEL);
        super.dispatchTouchEvent(ev);
    }

    @Override
    protected void dispatchDraw(final Canvas canvas) {
        zoom = lerp(bias(zoom, smoothZoom, 0.05f), smoothZoom, 0.2f);
        boolean redraw = false;
        if (zoom != smoothZoom) redraw = true;

        m.setTranslate(0.5f * getWidth(), 0.5f * getHeight());
        //m.setTranslate(0,0);
        m.preScale(zoom, zoom);
        final View v = getChildAt(0);
        m.preTranslate(-0.5f * getWidth(), -0.5f * getHeight());

        canvas.save();
        canvas.concat(m);
        v.draw(canvas);
        canvas.restore();
        if (redraw) {
            this.invalidate();
            this.getRootView().invalidate();
        }
    }


    private float clamp(final float min, final float value, final float max) {
        return Math.max(min, Math.min(value, max));
    }

    private float lerp(final float a, final float b, final float k) {
        return a + (b - a) * k;
    }

    private float bias(final float a, final float b, final float k) {
        return Math.abs(b - a) >= k ? a + k * Math.signum(b - a) : b;
    }
}
