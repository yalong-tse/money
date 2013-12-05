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
	
	   
	//���ɶ�̬���飬��������   
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
	
	String[] productitems={"ǬԪ��������2013���12����Ʋ�Ʒ(55��)","��ϲϵ��2013���46����������Ͷ���ͷǱ�����Ʋ�Ʒ(182��)","������ϵ��2013���46����Ԫ���м䱣֤������Ʋ�Ʒ(365��)",
			"��ͨ���2013�������2449����Ʋ�Ʒ(365��)","�����ȸ�ZYWFSH042013097(170��)�������Ƽƻ�","�߾�ֵ�ͻ�ר��240�������������Ʋ�Ʒ(ZL240D02)",
			"������Ƹ�ͨ2013079���������Ʋ�Ʒ(92��)","��������֮�����ɽ�10015����Ƽƻ�(90��)","��Կ�װ��ĵ���2013���1800���������Ʋ�Ʒ(36��)",
			"ƽ���Ƹ�-˽��ר��������A�ʲ�������2013��30���������Ʋ�Ʒ"};
	String[] items = {"�������","�й�����","��������","ũҵ����","��������","��ͨ����","��������","��������"};
	String[] profits = {"3.5%","4.5%","2.8%","3.5%","4.3%","6.5%","4.6%","4.3%"};
	String[] startmoney = {"1��","2��","3��","4��","5��","6��","7��","8��"};
	
	// topmenu ��ѯ����
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
		textView.setText("���ڳ���");
		
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
					Object obj = popupwindow_list.getAdapter().getItem(position);  // ��ȡlistview���������item����ֵ
					if(obj.toString().equals("����")){
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
