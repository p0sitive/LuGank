package com.lee.lugank.ui.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;

/**
 * Created by Lee on 2017/5/3.
 */

public class MultiAnimDrawable extends Drawable implements Animatable,Drawable.Callback{
    private static final String TAG = "MultiAnimDrawable";

    public static final long PART_DURATION = 200L;

    private SparseArray<AnimDrawable> array;

    public MultiAnimDrawable() {
        array = new SparseArray<>();
        array.append(0, new AnimDrawable());
        array.append(1, new AnimDrawable());
        array.append(2, new AnimDrawable());

        for (int i = 0; i < 3; i++) {

            array.get(i).setDelayStart(PART_DURATION * i);
            array.get(i).setCallback(this);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < 3; i++) {
            AnimDrawable animDrawable = array.get(i);
            int count = canvas.save();
            animDrawable.draw(canvas);
            canvas.restoreToCount(count);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.RGBA_8888;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        for (int i = 0; i < 3; i++) {
            AnimDrawable drawable = array.get(i);
            drawable.onBoundsChange(bounds);
        }
    }

    @Override
    public void start() {
        for (int i = 0; i < 3; i++) {
            AnimDrawable drawable = array.get(i);
            drawable.start();
        }
    }

    @Override
    public void stop() {
        for (int i = 0; i < 3; i++) {
            AnimDrawable drawable = array.get(i);
            drawable.stop();
        }
    }

    @Override
    public boolean isRunning() {
        for (int i = 0; i < 3; i++) {
            AnimDrawable drawable = array.get(i);
            if(drawable.isRunning()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    @Override
    public void scheduleDrawable(Drawable who, Runnable what, long when) {

    }

    @Override
    public void unscheduleDrawable(Drawable who, Runnable what) {

    }
}
