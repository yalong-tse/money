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
	
	//生成动态数组，加入数据   
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		
	String[] productitems={"乾元—尊享型2013年第12期理财产品(55天)",
				"中银稳富ZYWFSH042013097(170天)人民币理财计划","高净值客户专属240天增利人民币理财产品(ZL240D02)",
				"平安财富-私行专享尊贵组合A资产管理类2013年30期人民币理财产品"};
	String[] items = {"光大银行","招商银行","华夏银行"};
	String[] profits = {"3.5%","4.3%","4.3%"};
	String[] startmoney = {"1万","5万","8万"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_collection);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("我的收藏");
		
		listview = (ListView)findViewById(R.id.list_collection);
		
		for(int i=0;i<items.length;i++)
		{
			HashMap<String,Object> map = new HashMap<String,Object>();
			if(items[i].equalsIgnoreCase("光大银行"))
			{
				map.put("ItemImage", R.drawable.guangdayinhang);
			}
			else if(items[i].equalsIgnoreCase("中国银行"))
			{
				map.put("ItemImage", R.drawable.zhaoshangyinhang);
			}
			else if(items[i].equalsIgnoreCase("建设银行"))
			{
				map.put("ItemImage", R.drawable.jiansheyinhang);
			}
			else if(items[i].equalsIgnoreCase("农业银行"))
			{
				map.put("ItemImage", R.drawable.nongyeyinhang);
			}
			else if(items[i].equalsIgnoreCase("招商银行"))
			{
				map.put("ItemImage", R.drawable.zhaoshangyinhang);
			}
			else if(items[i].equalsIgnoreCase("交通银行"))
			{
				map.put("ItemImage", R.drawable.jiaotongyinhang);
			}
			else if(items[i].equalsIgnoreCase("工商银行"))
			{
				map.put("ItemImage", R.drawable.gongshangyinhang);
			}
			else if(items[i].equalsIgnoreCase("华夏银行"))
			{
				map.put("ItemImage", R.drawable.huaxiayinhang);
			}
			
			map.put("ItemText", productitems[i]);
			map.put("ItemDetail", "发行银行：" + items[i]);
			map.put("profit","预期收益率：" +  profits[i]);
			map.put("startmoney", "起够金额：" + startmoney[i]);
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
		
		
		// 选择条目打开详情界面
		listview.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				LinearLayout line_layout = (LinearLayout) view;
				TextView tv_productname = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_title);
				TextView tv_productprofit = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_profit);
				TextView tv_productstartbuy = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_startmoney);
				ImageView iv_titleimage = (ImageView) line_layout.findViewById(R.id.list_product_listview_imageview);
				 
				// 传递参数
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
