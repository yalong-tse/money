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

	private String[] items = {
			"金融超市","理财资讯","每日推荐","理财圈子",
			"我的资产","风险评估","资产配置","网点查询",
			"循环投资","境外投资","女士专区","理财计算器",
			"个人设置","我的收藏","客服咨询"
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
			if(items[i].equalsIgnoreCase("我的资产"))
				map.put("image", R.drawable.module21);
			else if(items[i].equalsIgnoreCase("金融超市"))
				map.put("image", R.drawable.module13);
			else if(items[i].equalsIgnoreCase("资产配置"))
				map.put("image", R.drawable.module20);
			else if(items[i].equalsIgnoreCase("理财圈子"))
				map.put("image", R.drawable.module6);
			else if (items[i].equalsIgnoreCase("每日推荐"))
				map.put("image", R.drawable.module1);
			else if(items[i].equalsIgnoreCase("网点查询"))
				map.put("image", R.drawable.module8);
			else if(items[i].equalsIgnoreCase("每日推荐"))
				map.put("image", R.drawable.module5);
			else if(items[i].equalsIgnoreCase("风险评估"))
				map.put("image", R.drawable.module3);
			else if(items[i].equalsIgnoreCase("理财计算器"))
				map.put("image", R.drawable.module23);
			else if(items[i].equalsIgnoreCase("理财资讯"))
				map.put("image", R.drawable.module9);
			else if(items[i].equalsIgnoreCase("客服咨询"))
				map.put("image", R.drawable.module15);
			else if(items[i].equalsIgnoreCase("智能筛选"))
				map.put("image", R.drawable.module10);
			else if(items[i].equalsIgnoreCase("我的收藏"))
				map.put("image", R.drawable.module14);
			else if(items[i].equalsIgnoreCase("循环投资"))
				map.put("image", R.drawable.module24);
			else if(items[i].equalsIgnoreCase("境外投资"))
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
		 * 点击事件的方法
		 * */
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.d("money", "the index is :" + arg2);
				switch (arg2)
				{
				// 金融超市
				case 0:
					Intent intent_product = new Intent();
					intent_product.setClass(MainActivity.this, ListProductActivity.class);
					startActivity(intent_product);
					break;
				// 理财咨询
				case 1:
					Intent intent_news = new Intent();
					intent_news.setClass(MainActivity.this, NewsActivity.class);
					startActivity(intent_news);
					break;
				// 每日推荐
				case 2:
					Intent intent_recommend = new Intent();
					intent_recommend.setClass(MainActivity.this,RecommendActivity.class);
					startActivity(intent_recommend);
					break;
					
				// 理财圈子
				case 3:
					Intent intent_circle = new Intent();
					intent_circle.setClass(MainActivity.this, CircleActivity.class);
					startActivity(intent_circle);
					break;
					
				// 我的资产
				case 4:
					Intent intent_property = new Intent();
					intent_property.setClass(MainActivity.this, PropertyActivity.class);
					startActivity(intent_property);
					break;
					
				// 风险评估 
				case 5:
					Intent intent_risktesting = new Intent();
					intent_risktesting.setClass(MainActivity.this, RiskTestingActivity.class);
					startActivity(intent_risktesting);
					break;
					
				// 资产配置
				case 6:
					Intent intent_property_config = new Intent();
					intent_property_config.setClass(MainActivity.this, PropertyConfigActivity.class);
					startActivity(intent_property_config);
					break;
				// 网点查询
				case 7:
					Intent intent_map = new Intent();
					intent_map.setClass(MainActivity.this, MapviewActivity.class);
					startActivity(intent_map);
					
					break;
				// 循环投资
				case 8:
					
					break;
				// 境外投资
				case 9:
					
					break;
				// 女士专区
				case 10:
					break;
				// 理财计算器
				case 11:
					Intent intent_cal = new Intent();
					intent_cal.setClass(MainActivity.this, CalActivity.class);
					startActivity(intent_cal);
					break;
				// 个人设置
				case 12:
					Intent intent_person = new Intent();
					intent_person.setClass(MainActivity.this, PersonInfoActivity.class);
					startActivity(intent_person);
					break;
				// 我的收藏
				case 13:
					Intent intent_collection = new Intent(MainActivity.this, CollectionActivity.class);
					startActivity(intent_collection);
					break;
					// 客服咨询
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
