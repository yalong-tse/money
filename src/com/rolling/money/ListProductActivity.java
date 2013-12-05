package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ListProductActivity extends Activity {

	private ListView listview;
	
	   
	//生成动态数组，加入数据   
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
	
	String[] productitems={"乾元—尊享型2013年第12期理财产品(55天)","心喜系列2013年第46期人民币组合投资型非保本理财产品(182天)","本无忧系列2013年第46期美元银行间保证收益理财产品(365天)",
			"汇通理财2013年惠添利2449号理财产品(365天)","中银稳富ZYWFSH042013097(170天)人民币理财计划","高净值客户专属240天增利人民币理财产品(ZL240D02)",
			"鑫意理财福通2013079期人民币理财产品(92天)","招银进宝之鼎鼎成金10015号理财计划(90天)","金钥匙安心得利2013年第1800期人民币理财产品(36天)",
			"平安财富-私行专享尊贵组合A资产管理类2013年30期人民币理财产品"};
	String[] items = {"光大银行","中国银行","建设银行","农业银行","招商银行","交通银行","工商银行","华夏银行"};
	String[] profits = {"3.5%","4.5%","2.8%","3.5%","4.3%","6.5%","4.6%","4.3%"};
	String[] startmoney = {"1万","2万","3万","4万","5万","6万","7万","8万"};
	
	// topmenu 查询区域
	TextView menu_top1, menu_top2, menu_top3, menu_top4;
	LinearLayout layout1, layout2, layout3, layout4;
	private ListView popupwindow_list;
    private PopupWindow pwindo;
	ArrayAdapter<CharSequence> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_product);
		
		listview = (ListView) findViewById(R.id.list_product_listview);
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("金融超市");
		
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
				
				
				Intent product_detail_intent = new Intent();
				product_detail_intent.putExtra(Constants.PRODUCT_DETAIL,product_bundle);
				
				product_detail_intent.putExtra(Constants.PRODUCT_DRAWABLE, obmp);
				
				product_detail_intent.setClass(ListProductActivity.this, ProductDetailActivity.class);
				startActivity(product_detail_intent);
			}
			
		});
		
		menu_top1 = (TextView)findViewById(R.id.menu_top_1);
		menu_top2 = (TextView)findViewById(R.id.menu_top_2);
		menu_top3 = (TextView)findViewById(R.id.menu_top_3);
		menu_top4 = (TextView)findViewById(R.id.menu_top_4);
		layout1 = (LinearLayout) findViewById(R.id.layout_top_1);
		layout2 = (LinearLayout) findViewById(R.id.layout_top_2);
		layout3 = (LinearLayout) findViewById(R.id.layout_top_3);
		layout4 = (LinearLayout) findViewById(R.id.layout_top_4);
		
		layout1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				initiatePopupWindow(layout1, menu_top1, R.array.menu_top_1, R.string.menu_top_1);
			}
		});
		layout2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				initiatePopupWindow(layout2, menu_top2, R.array.menu_top_2, R.string.menu_top_2);
			}
		});
		layout3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				initiatePopupWindow(layout3, menu_top3, R.array.menu_top_3, R.string.menu_top_3);
			}
		});
		layout4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				initiatePopupWindow(layout4, menu_top4, R.array.menu_top_4, R.string.menu_top_4);
			}
		});
		
	}

	private void initiatePopupWindow(View view, final TextView menu_top, int popup_array, final int menu_top_string) {
		try {
			
			// We need to get the instance of the LayoutInflater
			LayoutInflater inflater = (LayoutInflater) ListProductActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//			View layout = inflater.inflate(R.layout.screen_popup, (ViewGroup) findViewById(R.id.popup_element));
			View layout = inflater.inflate(R.layout.common_topmenu_popup, null);
			popupwindow_list = (ListView) layout.findViewById(R.id.topmenu_list);
//			adapter = ArrayAdapter.createFromResource(this, R.array.popupwindow_array, android.R.layout.simple_list_item_1);
			adapter = ArrayAdapter.createFromResource(this, popup_array, R.layout.commom_topmenu_textview);
			popupwindow_list.getLayoutParams().width = (int) (getWidestView(this, adapter)*1.5);
			popupwindow_list.setAdapter(adapter);
			popupwindow_list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View v, int position,
						long id) {
					Object obj = popupwindow_list.getAdapter().getItem(position);  // 获取listview中所点击的item的数值
					if(obj.toString().equals("不限")){
						menu_top.setText(getResources().getString(menu_top_string));
					} else {
						menu_top.setText(obj.toString());
					}
					pwindo.dismiss();
			        Log.d("ListProductActivity", obj.toString());
				};
			});
			
			
//			pwindo = new PopupWindow(layout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
			pwindo = new PopupWindow(layout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
			pwindo.setBackgroundDrawable(new BitmapDrawable());
			pwindo.showAsDropDown(view, 2, 0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Computes the widest view in an adapter, best used when you need to wrap_content on a ListView, please be careful
	 * and don't use it on an adapter that is extremely numerous in items or it will take a long time.
	 *
	 * http://stackoverflow.com/questions/6547154/wrap-content-for-a-listviews-width
	 * 
	 * @param context Some context
	 * @param adapter The adapter to process
	 * @return The pixel width of the widest View
	 */
	public static int getWidestView(Context context, Adapter adapter) {
	    int maxWidth = 0;
	    View view = null;
	    FrameLayout fakeParent = new FrameLayout(context);
	    for (int i=0, count=adapter.getCount(); i<count; i++) {
	        view = adapter.getView(i, view, fakeParent);
	        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
	        int width = view.getMeasuredWidth();
	        if (width > maxWidth) {
	            maxWidth = width;
	        }
	    }
	    return maxWidth;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_product, menu);
		return true;
	}

}
