package com.lika85456.industrio.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class ItemBarView extends ViewGroup {

    private static final int nItems = 5;


    private BarItem[] barItems;

    public ItemBarView(Context context) {
        super(context);
        init();
    }

    public ItemBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //notFocused = ResourcesCompat.getDrawable(getResources(), notFocusedResource, null);
        barItems = new BarItem[nItems];
        for (int i = 0; i < barItems.length; i++) {
            barItems[i] = new BarItem(getContext());
            addView(barItems[i]);
        }
    }

    public void onMeasure(int w, int h) {
        setMeasuredDimension(MeasureSpec.getSize(h) * nItems, MeasureSpec.getSize(h));
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        for (int x = 0; x < barItems.length; x++) {
            barItems[x].layout((int) ((i2 - i) / (float) nItems * x), 0, (int) ((i2 - i) / (float) nItems * (x + 1)), i3);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        for (int i = 0; i < barItems.length; i++) {
            barItems[i].reset();
        }
        super.dispatchTouchEvent(motionEvent);
        return false;
    }
}
