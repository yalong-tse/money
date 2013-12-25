package com.rolling.money;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.rolling.money.ui.RadarView;

public class ProductAnalyseActivity extends BaseBarActivity {

	private RadarView radar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("产品综合分析");
		
		float[] values = {8, 6, 8, 6, 6, 6};
		String[] titles = {"1指标","2指标","3指标","4指标","5指标","6指标"};
		radar = (RadarView) findViewById(R.id.radar);
//		radar.setValues(values); // 此种方式同样可以改变radar图的值
//		radar.setTitles(titles);
		
		TextView config_description = (TextView) findViewById(R.id.product_description);
		String first = "<font color='#a3a3a3'>分析点评: </font>";
		String next = "××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××××";
		config_description.setText(Html.fromHtml(first + next));
		
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_product_analyse;
	}

}
