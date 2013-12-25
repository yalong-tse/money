package com.rolling.money.ui;

import junit.framework.Assert;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.rolling.money.R;

public class RadarView extends View {
	
	private int count = 6;
	private float angle = 360 / count;
	private int point_radius = 5; // 画点的半径
	private int valueRulingCount = 5; // 画等分值线
	private int radius;
	private int centerX;
	private int centerY;
	private String[] titles = { "本金安全性", "风险性", "收益性", "流动性", "指标5", "指标6" };

	private Point[] pts; // 维度端点
	private Path valuePath;
	private float[] values = { 8, 6, 8, 6, 6, 6}; // 各维度分值
	private int maxValue = 10;
	private Point[] value_pts; // 维度端点
	private Paint paint;
	private Paint valuePaint;

	public float[] getValues() {
		return values;
	}

	public void setValues(float[] values) {
		Assert.assertTrue("传递的values数组大小不是" + count, values.length == count);
		this.values = values;
	}
	
	public void setTitles(String[] titles) {
		this.titles = titles;
	}
	
	public RadarView(Context context) {
		super(context);
	}

	public RadarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	public RadarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}
	
	private void init(AttributeSet attrs) {
		paint = new Paint();
		valuePaint = new Paint();
		pts = new Point[count];
		value_pts = new Point[count];
		valuePath = new Path();
		for (int i = 0; i < count; i++) {
			pts[i] = new Point();
			value_pts[i] = new Point();
		}

		TypedArray arr = getContext().obtainStyledAttributes(attrs, R.styleable.radar);
		
		int titleid = arr.getResourceId(R.styleable.radar_key_array, 0);
		int valueid = arr.getResourceId(R.styleable.radar_value_array, 0);
		
		if(titleid != 0) {
			titles = getResources().getStringArray(titleid);
		} 
		
		if(valueid != 0) {
			String[] valuesStr = getResources().getStringArray(valueid);
			try {
	            float[] values = new float[valuesStr.length];
	            for(int i = 0; i <valuesStr.length; i++) {
	                values[i] = Float.parseFloat(valuesStr[i]);
	            }
	        } catch (Exception e) {
	        }
		}
		
		int color = arr.getColor(R.styleable.radar_android_color, Color.BLUE);
		
		// Remember to call this when finished
		arr.recycle();
		valuePaint.setColor(color);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

	    int desiredWidth = 300;
	    int desiredHeight = 300;

	    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
	    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
	    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
	    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

	    int width;
	    int height;

	    //Measure Width
	    if (widthMode == MeasureSpec.EXACTLY) {
	        //Must be this size
	        width = widthSize;
	    } else if (widthMode == MeasureSpec.AT_MOST) {
	        //Can't be bigger than...
	        width = Math.min(desiredWidth, widthSize);
	    } else {
	        //Be whatever you want
	        width = desiredWidth;
	    }

	    //Measure Height
	    if (heightMode == MeasureSpec.EXACTLY) {
	        //Must be this size
	        height = heightSize;
	    } else if (heightMode == MeasureSpec.AT_MOST) {
	        //Can't be bigger than...
	        height = Math.min(desiredHeight, heightSize);
	    } else {
	        //Be whatever you want
	        height = desiredHeight;
	    }

	    Log.i("Radar", "onMeasure():width-"+width+";height-"+height);
	    //MUST CALL THIS
	    setMeasuredDimension(width, height);
	}

	/**
	 * From Doc:
	 * 
	 * onLayout (boolean changed, int left, int top, int right, int bottom)
	 * Called from layout when this view should assign a size and position to each of its children. 
	 * Derived classes with children should override this method and call layout on each of their children.
	 * Parameters
	 * changed	This is a new size or position for this view
     * left	Left position, relative to parent
     * top	Top position, relative to parent
     * right	Right position, relative to parent
     * bottom	Bottom position, relative to parent
	 * 
	 * onSizeChanged(int w, int h, int oldw, int oldh)
	 * This is called during layout when the size of this view has changed. If you were just added to the view hierarchy,
	 * you're called with the old values of 0.
	 * @param w Current width of this view
	 * @param h Current height of this view
	 * @param oldw Old width of this view
	 * @param oldh Old height of this view
	 * 
	 * The main call to onSizeChanged() is done after the construction of your view but before the drawing. 
	 * At this time the system will calculate the size of your view and notify you by calling onSizeChanged()
	 */
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		radius = Math.min(h, w) / 2 - 60; 
		centerX = w / 2;
		centerY = h / 2;
//		centerY  = radius + 10;

		for (int i = 0; i < count; i++) {
			pts[i].x = centerX
					+ (int) (radius * Math.cos(Math.toRadians(angle * i)));
			pts[i].y = centerY
					- (int) (radius * Math.sin(Math.toRadians(angle * i)));
			Log.i("Radar Point", "(x, y)=(" + pts[i].x + "," + pts[i].y + ")");
		}
		postInvalidate();
		super.onSizeChanged(w, h, oldw, oldh);
		Log.i("Radar", "onSizeChanged():width-"+w+";height-"+h);
	}

	/*@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		float x = event.getX();
		float y = event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			for (int i = 0; i < regions.length; i++) {
				if (regions[i].contains((int) x, (int) y)) {
					values[(int) (i / (valueRulingCount * 2))] = regionValues[i];
					break;
				}
			}
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:

			break;
		case MotionEvent.ACTION_UP:

			break;
		}
		return super.onTouchEvent(event);
	}*/

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return super.onKeyLongPress(keyCode, event);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		/* 设置画布的颜色 */ /*可以通过android:background="@color/#FF0000"来设定画布颜色*/
//		canvas.drawColor(Color.WHITE);

		paint.setAntiAlias(true); // 抗锯齿
		// 画边框线
		paint.setColor(Color.GRAY);
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		for (int i = 0; i < count; i++) {
			int end = i + 1 == count ? 0 : i + 1;

			for (int j = 1; j <= valueRulingCount; j++) {
				canvas.drawLine(centerX + (pts[i].x - centerX) / 5 * j, centerY
						+ (pts[i].y - centerY) / 5 * j, centerX
						+ (pts[end].x - centerX) / 5 * j, centerY
						+ (pts[end].y - centerY) / 5 * j, paint);
			}

			canvas.drawLine(centerX, centerY, pts[i].x, pts[i].y, paint);
		}

		// 写文字
		paint.setTextSize(20);
		paint.setColor(Color.BLACK);
		FontMetrics fontMetrics = paint.getFontMetrics();
		float fontHegiht = -fontMetrics.ascent;
		for (int i = 0; i < count; i++) {
			if ((angle * i == 90.0) || (angle * i == 270.0))
				paint.setTextAlign(Align.CENTER);
			else if ((angle * i < 90) || (angle * i > 270))
				paint.setTextAlign(Align.LEFT);
			else if ((angle * i > 90) || (angle * i < 270))
				paint.setTextAlign(Align.RIGHT);

			if (angle * i == 270.0)
				canvas.drawText(titles[i], pts[i].x, pts[i].y + fontHegiht,
						paint);
			else
				canvas.drawText(titles[i], pts[i].x, pts[i].y, paint);
		}

		// 画方向盘分值区域
		for (int i = 0; i < count; i++) {
			value_pts[i].x = (int) (centerX + (pts[i].x - centerX) * values[i]
					/ maxValue);
			value_pts[i].y = (int) (centerY + (pts[i].y - centerY) * values[i]
					/ maxValue);
		}

		valuePath.reset();
		valuePaint.setAntiAlias(true);
//		valuePaint.setColor(Color.BLUE);  // 可以通过在xml中设置 android:color="@color/red"来改变颜色
		valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
		for (int i = 0; i < pts.length; i++) {
			// 给valuePath赋值
			if (i == 0)
				valuePath.moveTo(value_pts[i].x, value_pts[i].y);
			else
				valuePath.lineTo(value_pts[i].x, value_pts[i].y);
			// 画取分圆圈
			canvas.drawCircle(value_pts[i].x, value_pts[i].y, point_radius,
					paint);
		}
		valuePaint.setAlpha(150);// 透明度
		canvas.drawPath(valuePath, valuePaint);
	}

	
}
