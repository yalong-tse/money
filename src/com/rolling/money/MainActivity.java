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

	private String[] items = {
			"���ڳ���","�����Ѷ","ÿ���Ƽ�","���Ȧ��",
			"�ҵ��ʲ�","��������","�ʲ�����","�����ѯ",
			"ѭ��Ͷ��","����Ͷ��","Ůʿר��","��Ƽ�����",
			"��������","�ҵ��ղ�","�ͷ���ѯ"
			};
	
	private GridView gridview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridview = (GridView) findViewById(R.id.main_gridview);
		
		for(int i=0;i<items.length;i++)
		{
			HashMap<String,Object> map = new HashMap<String,Object>();
			if(items[i].equalsIgnoreCase("�ҵ��ʲ�"))
				map.put("image", R.drawable.module21);
			else if(items[i].equalsIgnoreCase("���ڳ���"))
				map.put("image", R.drawable.module13);
			else if(items[i].equalsIgnoreCase("�ʲ�����"))
				map.put("image", R.drawable.module20);
			else if(items[i].equalsIgnoreCase("���Ȧ��"))
				map.put("image", R.drawable.module6);
			else if (items[i].equalsIgnoreCase("ÿ���Ƽ�"))
				map.put("image", R.drawable.module1);
			else if(items[i].equalsIgnoreCase("�����ѯ"))
				map.put("image", R.drawable.module8);
			else if(items[i].equalsIgnoreCase("ÿ���Ƽ�"))
				map.put("image", R.drawable.module5);
			else if(items[i].equalsIgnoreCase("��������"))
				map.put("image", R.drawable.module3);
			else if(items[i].equalsIgnoreCase("��Ƽ�����"))
				map.put("image", R.drawable.module23);
			else if(items[i].equalsIgnoreCase("�����Ѷ"))
				map.put("image", R.drawable.module9);
			else if(items[i].equalsIgnoreCase("�ͷ���ѯ"))
				map.put("image", R.drawable.module15);
			else if(items[i].equalsIgnoreCase("����ɸѡ"))
				map.put("image", R.drawable.module10);
			else if(items[i].equalsIgnoreCase("�ҵ��ղ�"))
				map.put("image", R.drawable.module14);
			else if(items[i].equalsIgnoreCase("ѭ��Ͷ��"))
				map.put("image", R.drawable.module24);
			else if(items[i].equalsIgnoreCase("����Ͷ��"))
				map.put("image", R.drawable.module10);
			else
				map.put("image", R.drawable.module16);
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
				// ���ڳ���
				case 0:
					Intent intent_product = new Intent();
					intent_product.setClass(MainActivity.this, ListProductActivity.class);
					startActivity(intent_product);
					break;
				// �����ѯ
				case 1:
					Intent intent_news = new Intent();
					intent_news.setClass(MainActivity.this, NewsActivity.class);
					startActivity(intent_news);
					break;
				// ÿ���Ƽ�
				case 2:
					Intent intent_recommend = new Intent();
					intent_recommend.setClass(MainActivity.this,RecommendActivity.class);
					startActivity(intent_recommend);
					break;
					
				// ���Ȧ��
				case 3:
					Intent intent_circle = new Intent();
					intent_circle.setClass(MainActivity.this, CircleActivity.class);
					startActivity(intent_circle);
					break;
					
				// �ҵ��ʲ�
				case 4:
					Intent intent_property = new Intent();
					intent_property.setClass(MainActivity.this, PropertyActivity.class);
					startActivity(intent_property);
					break;
					
				// �������� 
				case 5:
					Intent intent_risktesting = new Intent();
					intent_risktesting.setClass(MainActivity.this, RiskTestingActivity.class);
					startActivity(intent_risktesting);
					break;
					
				// �ʲ�����
				case 6:
					Intent intent_property_config = new Intent();
					intent_property_config.setClass(MainActivity.this, PropertyConfigActivity.class);
					startActivity(intent_property_config);
					break;
				// �����ѯ
				case 7:
					Intent intent_map = new Intent();
					intent_map.setClass(MainActivity.this, MapviewActivity.class);
					startActivity(intent_map);
					
					break;
				// ѭ��Ͷ��
				case 8:
					
					break;
				// ����Ͷ��
				case 9:
					
					break;
				// Ůʿר��
				case 10:
					break;
				// ��Ƽ�����
				case 11:
					Intent intent_cal = new Intent();
					intent_cal.setClass(MainActivity.this, CalActivity.class);
					startActivity(intent_cal);
					break;
				// ��������
				case 12:
					Intent intent_person = new Intent();
					intent_person.setClass(MainActivity.this, PersonInfoActivity.class);
					startActivity(intent_person);
					break;
				// �ҵ��ղ�
				case 13:
					Intent intent_collection = new Intent(MainActivity.this, CollectionActivity.class);
					startActivity(intent_collection);
					break;
					// �ͷ���ѯ
				case 14:
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
