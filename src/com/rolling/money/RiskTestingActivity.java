package com.rolling.money;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.TextView;

import com.rolling.money.data.MyPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class RiskTestingActivity extends BaseBarActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_risk_testing);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("∑Áœ’∆¿π¿");
		
		MyPagerAdapter pageAdapter = new MyPagerAdapter(getSupportFragmentManager());
		ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
		pager.setAdapter(pageAdapter);
		
		//Bind the title indicator to the adapter
		TabPageIndicator tabindicator = (TabPageIndicator) findViewById(R.id.titles);
		tabindicator.setViewPager(pager);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.risk_testing, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_risk_testing2;
	}

}
