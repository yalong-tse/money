package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ProductDetailActivity extends Activity {

	// ���ɶ�̬���飬��������
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

	String[] productitems = { "ǬԪ��������2013���12����Ʋ�Ʒ(55��)",
			"��ϲϵ��2013���46����������Ͷ���ͷǱ�����Ʋ�Ʒ(182��)",
			"������ϵ��2013���46����Ԫ���м䱣֤������Ʋ�Ʒ(365��)", "��ͨ���2013�������2449����Ʋ�Ʒ(365��)",
			"�����ȸ�ZYWFSH042013097(170��)�������Ƽƻ�",
			"�߾�ֵ�ͻ�ר��240�������������Ʋ�Ʒ(ZL240D02)", "������Ƹ�ͨ2013079���������Ʋ�Ʒ(92��)",
			"��������֮�����ɽ�10015����Ƽƻ�(90��)", "��Կ�װ��ĵ���2013���1800���������Ʋ�Ʒ(36��)",
			"ƽ���Ƹ�-˽��ר��������A�ʲ�������2013��30���������Ʋ�Ʒ" };
	String[] items = { "�������", "�й�����", "��������", "ũҵ����", "��������", "ƽ������", "��������",
			"��������" };
	String[] profits = { "3.5%", "4.5%", "2.8%", "3.5%", "4.3%", "6.5%",
			"4.6%", "4.3%" };
	String[] startmoney = { "1��", "2��", "3��", "4��", "5��", "6��", "7��", "8��" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);

		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("��Ʒ����");
		
		
		// �����б���洫�ݹ����Ĳ���
		Bundle bundle = this.getIntent().getBundleExtra(Constants.PRODUCT_DETAIL);
		String product_name = bundle.getString(Constants.PRODUCT_NAME);
		String product_profit = bundle.getString(Constants.PRODUCT_PROFIT);
		String product_startbuy = bundle.getString(Constants.PRODUCT_START_BUY);
		

		TextView tv_product_name = (TextView) findViewById(R.id.product_detail_name_textview);
		TextView tv_product_profit = (TextView) findViewById(R.id.product_detail_profit_value);
		TextView tv_product_startbuy = (TextView) findViewById(R.id.product_detail_start_value);
		ImageView product_imageview = (ImageView) findViewById(R.id.product_detail_productimage_imageview);

		// ����ͼƬ
		Bitmap bitmap = this.getIntent().getParcelableExtra(Constants.PRODUCT_DRAWABLE);
		
		
		tv_product_name.setText(product_name);
		tv_product_profit.setText(product_profit);
		tv_product_startbuy.setText(product_startbuy);
		product_imageview.setImageBitmap(bitmap);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_detail, menu);
		return true;
	}

}
