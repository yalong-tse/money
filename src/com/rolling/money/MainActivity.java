package com.rolling.money;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rolling.money.ui.CircleImageView;
import com.rolling.money.ui.CircleLayout;
import com.rolling.money.ui.CircleLayout.OnCenterClickListener;
import com.rolling.money.ui.CircleLayout.OnItemClickListener;
import com.rolling.money.ui.CircleLayout.OnItemSelectedListener;
import com.rolling.money.ui.CircleLayout.OnRotationFinishedListener;

public class MainActivity extends Activity implements OnItemSelectedListener,
		OnItemClickListener, OnRotationFinishedListener, OnCenterClickListener {
	TextView selectedTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		CircleLayout circleMenu = (CircleLayout) findViewById(R.id.main_circle_layout);
		circleMenu.setOnItemSelectedListener(this);
		circleMenu.setOnItemClickListener(this);
		circleMenu.setOnRotationFinishedListener(this);
		circleMenu.setOnCenterClickListener(this);

		selectedTextView = (TextView) findViewById(R.id.main_selected_textView);
		selectedTextView.setText(((CircleImageView) circleMenu
				.getSelectedItem()).getName());
		
		LinearLayout bottom_menu1 = (LinearLayout) findViewById(R.id.bottom_menu1);
		LinearLayout bottom_menu2 = (LinearLayout) findViewById(R.id.bottom_menu2);
		LinearLayout bottom_menu3 = (LinearLayout) findViewById(R.id.bottom_menu3);
		LinearLayout bottom_menu4 = (LinearLayout) findViewById(R.id.bottom_menu4);
		
		bottom_menu1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_recommend = new Intent();
				intent_recommend.setClass(MainActivity.this,RecommendActivity.class);
				startActivity(intent_recommend);
			}
		});
		bottom_menu2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_property_config = new Intent();
				intent_property_config.setClass(MainActivity.this, PropertyConfigActivity.class);
				startActivity(intent_property_config);
			}
		});
		bottom_menu3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_product = new Intent();
				intent_product.setClass(MainActivity.this, ListProductActivity.class);
				startActivity(intent_product);
			}
		});
		bottom_menu4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_collection = new Intent(MainActivity.this, CollectionActivity.class);
				startActivity(intent_collection);
			}
		});
		
	}

	@Override
	public void onItemSelected(View view, String name) {
		selectedTextView.setText(name);

		switch (view.getId()) {
			case R.id.main_facebook_image:
				// Handle facebook selection
				break;
			case R.id.main_google_image:
				// Handle google selection
				break;
			case R.id.main_linkedin_image:
				// Handle linkedin selection
				break;
			case R.id.main_myspace_image:
				// Handle myspace selection
				break;
			case R.id.main_twitter_image:
				// Handle twitter selection
				break;
			case R.id.main_wordpress_image:
				// Handle wordpress selection
				break;
		}
	}

	@Override
	public void onItemClick(View view, String name) {
//		Toast.makeText(getApplicationContext(),
//				getResources().getString(R.string.start_app) + " " + name,
//				Toast.LENGTH_SHORT).show();

		switch (view.getId()) {
			case R.id.main_facebook_image:
				// 个人设置
				Intent intent_person = new Intent();
				intent_person.setClass(MainActivity.this, PersonInfoActivity.class);
				startActivity(intent_person);
				break;
			case R.id.main_google_image:
				// 风险评估
				Intent intent_risktesting = new Intent();
				intent_risktesting.setClass(MainActivity.this, RiskTestingActivity.class);
				startActivity(intent_risktesting);
				break;
			case R.id.main_linkedin_image:
				// 资产配置
				Intent intent_property_config = new Intent();
				intent_property_config.setClass(MainActivity.this, PropertyConfigActivity.class);
				startActivity(intent_property_config);
				break;
			case R.id.main_myspace_image:
				// 理财资讯
				Intent intent_news = new Intent();
				intent_news.setClass(MainActivity.this, NewsActivity.class);
				startActivity(intent_news);
				break;
			case R.id.main_twitter_image:
				// 我的资产
				Intent intent_property = new Intent();
				intent_property.setClass(MainActivity.this, PropertyActivity.class);
				startActivity(intent_property);
				break;
			case R.id.main_wordpress_image:
				// 金融超市
				Intent intent_product = new Intent();
				intent_product.setClass(MainActivity.this, ListProductActivity.class);
				startActivity(intent_product);
				break;
		}
	}

	@Override
	public void onCenterClick() {
//		Toast.makeText(getApplicationContext(), R.string.center_click,
//				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onRotationFinished(View view, String name) {
		Animation animation = new RotateAnimation(0, 360, view.getWidth() / 2,
				view.getHeight() / 2);
		animation.setDuration(250);
		view.startAnimation(animation);
	}

}
