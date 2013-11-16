package com.rolling.money;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;

public class SplashScreenActivity extends Activity {

	private final int SPLASHSCREEN_TIME = 5000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		new Handler().postDelayed(new Runnable(){
			
			public void run()
			{
				Intent i=new Intent(SplashScreenActivity.this,MainActivity.class);
				SplashScreenActivity.this.startActivity(i);
				SplashScreenActivity.this.finish();
				
			}
			
		}, SPLASHSCREEN_TIME);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
		//return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

}
