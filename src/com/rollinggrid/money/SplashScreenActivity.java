package com.rollinggrid.money;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rollinggrid.money.utils.CustomScrollLayout;
import com.rollinggrid.money.utils.OnViewChangeListener;

public class SplashScreenActivity extends Activity implements OnViewChangeListener{

	private final int SPLASHSCREEN_TIME = 5000;
	
	private CustomScrollLayout mScrollLayout;
	private LinearLayout pointLLayout;
	private TextView startBtn;
	private ImageView[] imgs;
	private int count;
	private int currentItem;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		
		// 暂时去掉，不采用 Handle 处理
//		new Handler().postDelayed(new Runnable(){
//			
//			public void run()
//			{
//				Intent i=new Intent(SplashScreenActivity.this,MainActivity.class);
//				SplashScreenActivity.this.startActivity(i);
//				SplashScreenActivity.this.finish();
//				
//			}
//			
//		}, SPLASHSCREEN_TIME);
		
		
		initview();
		
	}
	
	/**
	 * 初始化界面
	 * */
	private void initview()
	{
		this.mScrollLayout = (CustomScrollLayout) findViewById(R.id.splash_ScrollLayout);
		this.pointLLayout = (LinearLayout) findViewById(R.id.splash_linelayout);
		this.startBtn = (TextView) findViewById(R.id.splash_startBtn);
		count = mScrollLayout.getChildCount();
		imgs = new ImageView[count];
		for(int i = 0; i< count;i++) {
			imgs[i] = (ImageView) pointLLayout.getChildAt(i);
			imgs[i].setEnabled(true);
			imgs[i].setTag(i);
		}
		currentItem = 0;
		imgs[currentItem].setEnabled(false);
		mScrollLayout.SetOnViewChangeListener(this);
		
		startBtn.setOnClickListener(onClick);
		
		
		
	}

	
	private View.OnClickListener onClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.splash_startBtn:
				mScrollLayout.setVisibility(View.GONE);
				pointLLayout.setVisibility(View.GONE);
				Intent i=new Intent(SplashScreenActivity.this,MainActivity.class);
				SplashScreenActivity.this.startActivity(i);
				SplashScreenActivity.this.finish();
				break;
			}
		}
	};
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
		//return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

	@Override
	public void OnViewChange(int pos) {
		// TODO Auto-generated method stub
		setcurrentPoint(pos);
	}

	
	private void setcurrentPoint(int position) {
		if(position < 0 || position > count -1 || currentItem == position) {
			return;
		}
		imgs[currentItem].setEnabled(true);
		imgs[position].setEnabled(false);
		currentItem = position;
	}
}
