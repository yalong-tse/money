package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class CollectionActivity extends Activity {

ListView listview;
	
	//���ɶ�̬���飬��������   
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		
	String[] productitems={"ǬԪ��������2013���12����Ʋ�Ʒ(55��)",
				"�����ȸ�ZYWFSH042013097(170��)�������Ƽƻ�","�߾�ֵ�ͻ�ר��240�������������Ʋ�Ʒ(ZL240D02)",
				"ƽ���Ƹ�-˽��ר��������A�ʲ�������2013��30���������Ʋ�Ʒ"};
	String[] items = {"�������","��������","��������"};
	String[] profits = {"3.5%","4.3%","4.3%"};
	String[] startmoney = {"1��","5��","8��"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collection);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("�ҵ��ղ�");
		
		listview = (ListView)findViewById(R.id.list_collection);
		
		for(int i=0;i<items.length;i++)
		{
			HashMap<String,Object> map = new HashMap<String,Object>();
			if(items[i].equalsIgnoreCase("�������"))
			{
				map.put("ItemImage", R.drawable.guangdayinhang);
			}
			else if(items[i].equalsIgnoreCase("�й�����"))
			{
				map.put("ItemImage", R.drawable.zhaoshangyinhang);
			}
			else if(items[i].equalsIgnoreCase("��������"))
			{
				map.put("ItemImage", R.drawable.jiansheyinhang);
			}
			else if(items[i].equalsIgnoreCase("ũҵ����"))
			{
				map.put("ItemImage", R.drawable.nongyeyinhang);
			}
			else if(items[i].equalsIgnoreCase("��������"))
			{
				map.put("ItemImage", R.drawable.zhaoshangyinhang);
			}
			else if(items[i].equalsIgnoreCase("��ͨ����"))
			{
				map.put("ItemImage", R.drawable.jiaotongyinhang);
			}
			else if(items[i].equalsIgnoreCase("��������"))
			{
				map.put("ItemImage", R.drawable.gongshangyinhang);
			}
			else if(items[i].equalsIgnoreCase("��������"))
			{
				map.put("ItemImage", R.drawable.huaxiayinhang);
			}
			
			map.put("ItemText", productitems[i]);
			map.put("ItemDetail", "�������У�" + items[i]);
			map.put("profit","Ԥ�������ʣ�" +  profits[i]);
			map.put("startmoney", "�𹻽�" + startmoney[i]);
			map.put("moreImage", R.drawable.ic_arrow);
			listItem.add(map);
		}
		
		
		SimpleAdapter listAdapter = new SimpleAdapter(this,listItem,R.layout.list_product_listview_item,
				new String[]{"ItemImage","ItemText","ItemDetail","profit","startmoney","moreImage"},
				new int[]{R.id.list_product_listview_imageview,
				R.id.list_product_listview_textview_title,
				R.id.list_product_listview_textview_detail,
				R.id.list_product_listview_textview_profit,
				R.id.list_product_listview_textview_startmoney,
				R.id.list_product_more_image});
		
		
		listview.setAdapter(listAdapter);
		
		
		// ѡ����Ŀ���������
		listview.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				LinearLayout line_layout = (LinearLayout) view;
				TextView tv_productname = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_title);
				TextView tv_productprofit = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_profit);
				TextView tv_productstartbuy = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_startmoney);
				ImageView iv_titleimage = (ImageView) line_layout.findViewById(R.id.list_product_listview_imageview);
				 
				// ���ݲ���
				String product_name = (String) tv_productname.getText();
				String product_profit = (String) tv_productprofit.getText();
				String product_startbuy = (String) tv_productstartbuy.getText();
				//Drawable drawable1 = iv_titleimage.getDrawable();
				
				iv_titleimage.setDrawingCacheEnabled(true);
				Bitmap obmp = Bitmap.createBitmap(iv_titleimage.getDrawingCache());
				iv_titleimage.setDrawingCacheEnabled(false);
				
				Bundle product_bundle = new Bundle();
				
				product_bundle.putString(Constants.PRODUCT_NAME, product_name);
				product_bundle.putString(Constants.PRODUCT_PROFIT, product_profit);
				product_bundle.putString(Constants.PRODUCT_START_BUY, product_startbuy);
				product_bundle.putString(Constants.PRODUCT_BANK_NAME, items[position]);
				
				
				Intent product_detail_intent = new Intent();
				product_detail_intent.putExtra(Constants.PRODUCT_DETAIL,product_bundle);
				
				product_detail_intent.putExtra(Constants.PRODUCT_DRAWABLE, obmp);
				
				product_detail_intent.setClass(CollectionActivity.this, ProductDetailActivity.class);
				startActivity(product_detail_intent);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.collection, menu);
		return true;
	}

}
