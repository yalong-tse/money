package com.rollinggrid.money;

import com.rollinggrid.money.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class NewsActivity extends BaseBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_news);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("理财资讯");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.news, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_news;
	}

}
