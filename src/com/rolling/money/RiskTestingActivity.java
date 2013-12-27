package com.rolling.money;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rolling.money.data.MyPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class RiskTestingActivity extends BaseBarActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_risk_testing);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("风险评估");
		
		MyPagerAdapter pageAdapter = new MyPagerAdapter(getSupportFragmentManager());
		ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
		pager.setAdapter(pageAdapter);
		
		//Bind the title indicator to the adapter
		TabPageIndicator tabindicator = (TabPageIndicator) findViewById(R.id.titles);
		tabindicator.setViewPager(pager);
	
		// 客户风向评价
		LinearLayout risktest = (LinearLayout) findViewById(R.id.btn_risktest);
		risktest.setOnClickListener(startrisktest);
		
	}
	
	private OnClickListener startrisktest = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(RiskTestingActivity.this, PropertyConfigActivity.class);
			startActivity(intent);
		}
	};

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
