package com.rolling.money;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

/**
 * 我的资产
 *
 */
public class PropertyActivity extends BaseBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_property);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("我的资产");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.property, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_property;
	}

}
