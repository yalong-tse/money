package com.rolling.money;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class CircleActivity extends BaseBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("¿Ì≤∆»¶");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.circle, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_circle;
	}

}
