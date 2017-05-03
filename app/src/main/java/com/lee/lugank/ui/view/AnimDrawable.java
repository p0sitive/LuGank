package com.lee.lugank.ui.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;

/**
 * Created by Lee on 2017/5/3.
 */

public class AnimDrawable extends Drawable implements Animatable{

    private Paint paint;
    private ValueAnimator valueAnimator;
    private int mRadius;
    private RectF rectF = new RectF();
    private long delayStart = 0L;

    public AnimDrawable(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(rectF.centerX(),rectF.centerY(),mRadius,paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.RGBA_8888;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        rectF.set(_clipSquare(bounds));
        if(isRunning()){
            stop();
        }
        int maxRadius = (int) ((rectF.right - rectF.left)/2);
        PropertyValuesHolder radiusHolder =
                PropertyValuesHolder.ofInt(mRadiusProperty,0,maxRadius);
        PropertyValuesHolder alphaHolder =
                PropertyValuesHolder.ofInt("alpha",255,0);
        valueAnimator = ObjectAnimator.ofPropertyValuesHolder(this,radiusHolder,alphaHolder);
        valueAnimator.setStartDelay(delayStart);
        valueAnimator.setDuration(2000L);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidateSelf();
            }
        });

        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        start();
    }

    public void setDelayStart(long delayStart) {
        this.delayStart = delayStart;
    }

    /**
     * 裁剪Rect为正方形
     * @param rect
     * @return
     */
    private Rect _clipSquare(Rect rect) {
        int w = rect.width();
        int h = rect.height();
        int min = Math.min(w, h);
        int cx = rect.centerX();
        int cy = rect.centerY();
        int r = min / 2;
        return new Rect(
                cx - r,
                cy - r,
                cx + r,
                cy + r
        );
    }
    @Override
    public void start() {
        valueAnimator.start();
    }

    @Override
    public void stop() {
        valueAnimator.end();
    }

    @Override
    public boolean isRunning() {
        return valueAnimator!=null&&valueAnimator.isRunning();
    }

    public int getmRadius() {
        return mRadius;
    }

    public void setmRadius(int mRadius) {
        this.mRadius = mRadius;
    }

    Property<AnimDrawable,Integer> mRadiusProperty = new Property<AnimDrawable, Integer>(Integer.class,"radius") {
        @Override
        public Integer get(AnimDrawable object) {
            return object.getmRadius();
        }

        @Override
        public void set(AnimDrawable object, Integer value) {
            object.setmRadius(value);
        }
    };
}
