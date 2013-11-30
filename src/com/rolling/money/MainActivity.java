package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter; 

public class MainActivity extends Activity {
	
	// Gridview �еĲ˵�
	private List<HashMap<String,Object>> menuitems = new ArrayList<HashMap<String,Object>>();

	private String[] items = {"�ҵ��ʲ�","���ڳ���","�ʲ�����","���Ȧ","��������","�����ѯ","ÿ���Ƽ�","���ղ���","��Ƽ�����","�����Ѷ","�ͷ���ѯ","Ůʿר��","�ҵ��ղ�"};
	
	private GridView gridview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridview = (GridView) findViewById(R.id.main_gridview);
		
		for(int i=0;i<items.length;i++)
		{
			HashMap<String,Object> map = new HashMap<String,Object>();
			if(i==0)
				map.put("image", R.drawable.module21);
			else if(i==1)
				map.put("image", R.drawable.module13);
			else if(i==2)
				map.put("image", R.drawable.module20);
			else if(i==3)
				map.put("image", R.drawable.module6);
			else if (i==4)
				map.put("image", R.drawable.module1);
			else if(i==5)
				map.put("image", R.drawable.module8);
			else if(i==6)
				map.put("image", R.drawable.module5);
			else if(i==7)
				map.put("image", R.drawable.module3);
			else if(i==8)
				map.put("image", R.drawable.module23);
			else if(i==9)
				map.put("image", R.drawable.module9);
			else if(i==10)
				map.put("image", R.drawable.module15);
			else if(i==11)
				map.put("image", R.drawable.module10);
			else if(i==12)
				map.put("image", R.drawable.module14);
			map.put("item", items[i]);
			
			menuitems.add(map);
		}
		
		String[] from = {"image","item"};
		int[] to = {R.id.main_menuitem_image,R.id.main_menuitem_text};
		SimpleAdapter menuAdapter = new SimpleAdapter(this,
				menuitems,
				R.layout.main_items,
				from,to);
		
		
		gridview.setAdapter(menuAdapter);
		
		
		/**
		 * ����¼��ķ���
		 * */
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.d("money", "the index is :" + arg2);
				switch (arg2)
				{
				// �ҵ��ʲ�
				case 0:
					Intent intent_property = new Intent();
					intent_property.setClass(MainActivity.this, PropertyActivity.class);
					startActivity(intent_property);
					break;
				// ���ڳ���
				case 1:
					Intent intent_product = new Intent();
					intent_product.setClass(MainActivity.this, ListProductActivity.class);
					startActivity(intent_product);
					break;
				// �ʲ�����
				case 2:
					Intent intent_property_config = new Intent();
					intent_property_config.setClass(MainActivity.this, PropertyConfigActivity.class);
					startActivity(intent_property_config);
					break;
					
				// ���Ȧ
				case 3:
					Intent intent_circle = new Intent();
					intent_circle.setClass(MainActivity.this, CircleActivity.class);
					startActivity(intent_circle);
					break;
					
				// ��������
				case 4:
					Intent intent_person = new Intent();
					intent_person.setClass(MainActivity.this, PersonInfoActivity.class);
					startActivity(intent_person);
					break;
					
				// �����ѯ
				case 5:
					Intent intent_map = new Intent();
					intent_map.setClass(MainActivity.this, MapviewActivity.class);
					startActivity(intent_map);
					
					break;
					
				// ÿ���Ƽ�
				case 6:
					Intent intent_recommend = new Intent();
					intent_recommend.setClass(MainActivity.this,RecommendActivity.class);
					startActivity(intent_recommend);
					
					break;
				//���ղ���
				case 7:
					Intent intent_risktesting = new Intent();
					intent_risktesting.setClass(MainActivity.this, RiskTestingActivity.class);
					startActivity(intent_risktesting);
					break;
				// ��Ƽ�����
				case 8:
					Intent intent_cal = new Intent();
					intent_cal.setClass(MainActivity.this, CalActivity.class);
					startActivity(intent_cal);
					break;
				// �����Ѷ
				case 9:
					Intent intent_news = new Intent();
					intent_news.setClass(MainActivity.this, NewsActivity.class);
					startActivity(intent_news);
					
					break;
				// �ͷ���ѯ
				case 10:
					break;
				// Ůʿר��
				case 11:
					break;
				// �ҵ��ղ�
				case 12:
					break;
				// 
				case 13:
					break;
					
				}
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
