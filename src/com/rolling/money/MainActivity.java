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
	
	// Gridview 中的菜单
	private List<HashMap<String,Object>> menuitems = new ArrayList<HashMap<String,Object>>();

	private String[] items = {"理财产品","我的账户","我的资产","每日推荐","风险测试","理财知道","计算器"};
	
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
				map.put("image", R.drawable.menu_calendar);
			else if(i==1)
				map.put("image", R.drawable.menu_chart);
			else
				map.put("image", R.drawable.menu_history);
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
		 * 点击事件的方法
		 * */
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.d("money", "the index is :" + arg2);
				switch (arg2)
				{
				// 理财产品
				case 0:
					Intent intent_product = new Intent();
					intent_product.setClass(MainActivity.this, ListProductActivity.class);
					startActivity(intent_product);
					break;
				case 1:
					Intent intent_person = new Intent();
					intent_person.setClass(MainActivity.this, PersonInfoActivity.class);
					startActivity(intent_person);
					break;
				case 2:
					break;
				case 3:
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
