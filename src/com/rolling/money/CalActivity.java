package com.rolling.money;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class CalActivity extends BaseBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_cal);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("¿Ì≤∆º∆À„∆˜");
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cal, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_cal;
	}

}
