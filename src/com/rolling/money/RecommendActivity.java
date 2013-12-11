package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rolling.money.data.IProduct;
import com.rolling.money.data.ProductAdapter;
import com.rolling.money.data.ProductEntry;
import com.rolling.money.data.ProductSection;

public class RecommendActivity extends Activity {

	ListView listview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommend);
		
		List<IProduct> data = new ArrayList<IProduct>();
		data.add(new ProductSection("������Ʋ�Ʒ"));
		data.add(new ProductEntry(R.drawable.guangdayinhang, "ǬԪ��������2013���12����Ʋ�Ʒ(55��)", "�������У��������", "Ԥ�������ʣ�3.5%", "�𹺽�1��"));
		data.add(new ProductEntry(R.drawable.zhaoshangyinhang, "�����ȸ�ZYWFSH042013097(170��)�������Ƽƻ�", "�������У���������", "Ԥ�������ʣ�4.3%", "�𹺽�5��"));
		data.add(new ProductEntry(R.drawable.jiaotongyinhang, "�߾�ֵ�ͻ�ר��240�������������Ʋ�Ʒ(ZL240D02)", "�������У���ͨ����", "Ԥ�������ʣ�6.5%", "�𹺽�6��"));
		data.add(new ProductEntry(R.drawable.gongshangyinhang, "��������֮�����ɽ�10015����Ƽƻ�(90��)", "�������У���������", "Ԥ�������ʣ�4.6%", "�𹺽�7��"));
		data.add(new ProductEntry(R.drawable.huaxiayinhang, "��Կ�װ��ĵ���2013���1800���������Ʋ�Ʒ(36��)", "�������У���������", "Ԥ�������ʣ�4.3%", "�𹺽�8��"));
		
		data.add(new ProductSection("�����ʲ��������Ʒ"));
		data.add(new ProductEntry(R.drawable.guangdayinhang, "��������A", "�������У��������", "Ԥ�������ʣ�5%", "�𹺽�10��"));
		
		data.add(new ProductSection("�������Ʒ"));
		data.add(new ProductEntry(R.drawable.fangzhengxintuo, "���ſعɼ����ʽ����в�Ʒ", "���л�������������", "Ԥ�������ʣ�9.8%��11.2%", "�𹺽�100��"));
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("ÿ���Ƽ�");
		
		listview = (ListView)findViewById(R.id.list_recommend);
		
		ProductAdapter adapter = new ProductAdapter(this, data);
		
		listview.setAdapter(adapter);
		
		
		// ѡ����Ŀ���������
		listview.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				LinearLayout line_layout = (LinearLayout) view;
				TextView tv_productname = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_title);
				TextView tv_productprofit = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_profit);
				TextView tv_productstartbuy = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_startmoney);
				TextView tv_productdetail = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_detail); //  ��������
				ImageView iv_titleimage = (ImageView) line_layout.findViewById(R.id.list_product_listview_imageview);
				 
				// ���ݲ���
				String product_name = (String) tv_productname.getText();
				String product_profit = (String) tv_productprofit.getText();
				String product_startbuy = (String) tv_productstartbuy.getText();
				String product_detail = tv_productdetail.getText().toString();
				//Drawable drawable1 = iv_titleimage.getDrawable();
				
				iv_titleimage.setDrawingCacheEnabled(true);
				Bitmap obmp = Bitmap.createBitmap(iv_titleimage.getDrawingCache());
				iv_titleimage.setDrawingCacheEnabled(false);
				
				Bundle product_bundle = new Bundle();
				
				product_bundle.putString(Constants.PRODUCT_NAME, product_name);
				product_bundle.putString(Constants.PRODUCT_PROFIT, product_profit);
				product_bundle.putString(Constants.PRODUCT_START_BUY, product_startbuy);
				product_bundle.putString(Constants.PRODUCT_BANK_NAME, product_detail.substring(product_detail.indexOf("��")+1));
				
				
				Intent product_detail_intent = new Intent();
				product_detail_intent.putExtra(Constants.PRODUCT_DETAIL,product_bundle);
				
				product_detail_intent.putExtra(Constants.PRODUCT_DRAWABLE, obmp);
				
				product_detail_intent.setClass(RecommendActivity.this, ProductDetailActivity.class);
				startActivity(product_detail_intent);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recommend, menu);
		return true;
	}

}
