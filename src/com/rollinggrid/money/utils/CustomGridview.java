package com.rollinggrid.money.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * ����Scrollview  Ƕ�� Gridview ���Զ������
 * */
public class CustomGridview extends GridView {

	public CustomGridview(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public CustomGridview(Context context, AttributeSet attrs) {   
        super(context, attrs);   
    }   
  
  
    public CustomGridview(Context context, AttributeSet attrs, int defStyle) {   
        super(context, attrs, defStyle);   
    }   
    
    
    /**
     * ���Զ���ؼ�ֻ����д��GridView��onMeasure������ʹ�䲻����ֹ�������
     * ScrollViewǶ��ListViewҲ��ͬ���ĵ�������׸����   
     * */
    @Override   
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {   
        int expandSpec = MeasureSpec.makeMeasureSpec(   
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);   
        super.onMeasure(widthMeasureSpec, expandSpec);   
    }   
}
