package com.rollinggrid.money.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 方便Scrollview  嵌套 Gridview 的自定义组件
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
     * 该自定义控件只是重写了GridView的onMeasure方法，使其不会出现滚动条，
     * ScrollView嵌套ListView也是同样的道理，不再赘述。   
     * */
    @Override   
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {   
        int expandSpec = MeasureSpec.makeMeasureSpec(   
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);   
        super.onMeasure(widthMeasureSpec, expandSpec);   
    }   
}
