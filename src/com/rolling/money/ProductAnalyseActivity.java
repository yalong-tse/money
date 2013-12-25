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
		textView.setText("��Ʒ�ۺϷ���");
		
		float[] values = {8, 6, 8, 6, 6, 6};
		String[] titles = {"1ָ��","2ָ��","3ָ��","4ָ��","5ָ��","6ָ��"};
		radar = (RadarView) findViewById(R.id.radar);
//		radar.setValues(values); // ���ַ�ʽͬ�����Ըı�radarͼ��ֵ
//		radar.setTitles(titles);
		
		TextView config_description = (TextView) findViewById(R.id.product_description);
		String first = "<font color='#a3a3a3'>��������: </font>";
		String next = "��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������";
		config_description.setText(Html.fromHtml(first + next));
		
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_product_analyse;
	}

}
