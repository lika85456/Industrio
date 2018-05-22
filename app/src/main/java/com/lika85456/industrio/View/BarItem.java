package com.lika85456.industrio.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lika85456.industrio.R;

public class BarItem extends View {

    public static int notFocusedResource = R.drawable.item_bar_slot;
    public static int focusedResource = R.drawable.item_bar_slot;

    public BarItem(Context context) {
        super(context);
        init();
    }

    public BarItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BarItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        this.setBackgroundResource(notFocusedResource);
    }

    protected void onMeasure(int wSpec, int hSpec) {
        setMeasuredDimension(MeasureSpec.getSize(wSpec), MeasureSpec.getSize(hSpec));
    }

    public void reset() {
        this.setBackgroundResource(notFocusedResource);
    }


    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.setBackgroundResource(focusedResource);
        return false;
    }
}
