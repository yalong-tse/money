package com.rolling.money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rolling.money.data.IProduct;
import com.rolling.money.data.ProductAdapter2;
import com.rolling.money.data.ProductEntry2;
import com.rolling.money.ui.MtitlePopupWindow;
import com.rolling.money.ui.MtitlePopupWindow.OnPopupWindowClickListener;

public class ListProductActivity extends BaseBarActivity {

	private ListView listview;
	
	MtitlePopupWindow mtitlePopupWindow;
	String [] titles = {"理财类产品", "资管类产品", "信托类产品"};
	private int screenWidth = 0; 
    private int screenHeight = 0; 
    private int popupWindowWidth = 0; 
    private int popupWindowHeight = 0;
    private int mLinearLayoutWidth = 0;
	// topmenu 查询区域
	TextView menu_top1, menu_top2, menu_top3, menu_top4;
	LinearLayout layout1, layout2, layout3, layout4;
	private ListView popupwindow_list;
    private PopupWindow pwindo;
	ArrayAdapter<CharSequence> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_list_product);
		
		initListProductActionBar();
		
		List<IProduct> data = new ArrayList<IProduct>();
		data.add(new ProductEntry2(5F,"3.5", "2013/7/10~2013/7/30", "12个月","预售", "3万", R.drawable.guangdayinhang,"光大银行 | 乾元—尊享型2013年第12期理财产品(55天)", "保本浮动收益" , "25人关注"));
		data.add(new ProductEntry2(4.5F,"3.5", "2013/6/24~2013/7/5", "24天","预售", "5万", R.drawable.zhaoshangyinhang, "招商银行 | 中银稳富ZYWFSH042013097(170天)人民币理财计划", "非保本浮动收益", "25人关注"));
		data.add(new ProductEntry2(5F,"6", "2013/9/24~2013/10/5", "11天","预售", "10万", R.drawable.jiaotongyinhang, "交通银行 | 高净值客户专属240天增利人民币理财产品(ZL240D02)", "非保本浮动收益", "300人关注"));
		data.add(new ProductEntry2(5F,"4.5", "2013/6/24~2013/7/5", "24个月","预售", "5万", R.drawable.gongshangyinhang, "工商银行 | 招银进宝之鼎鼎成金10015号理财计划(90天)", "保本浮动收益",  "30人关注"));
		data.add(new ProductEntry2(4F,"5", "2013/6/24~2013/7/5", "6个月","预售", "5万", R.drawable.huaxiayinhang, "华夏银行 | 金钥匙安心得利2013年第1800期人民币理财产品(36天)", "保本浮动收益", "24人关注"));
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("理财类产品");
		
		listview = (ListView)findViewById(R.id.list_product_listview);
		
		ProductAdapter2 adapter = new ProductAdapter2(this, data);
		
		listview.setAdapter(adapter);
		
		
		// 选择条目打开详情界面
		listview.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				RelativeLayout item = (RelativeLayout) view;
				
				// 获取每一个listview的值
				ImageView item_bankIcon = (ImageView) item.findViewById(R.id.item_bankIcon);
				RatingBar item_ratingbar = (RatingBar) item.findViewById(R.id.item_ratingBar);
				TextView item_profit = (TextView) item.findViewById(R.id.item_profit);
				TextView item_investperiod = (TextView) item.findViewById(R.id.item_investperiod);
				TextView item_period = (TextView) item.findViewById(R.id.item_period);
				TextView item_type = (TextView) item.findViewById(R.id.item_type);
				TextView item_startmoney = (TextView) item.findViewById(R.id.item_startmoney);
				TextView item_productitem = (TextView) item.findViewById(R.id.item_productitem);
				TextView item_productType = (TextView) item.findViewById(R.id.item_productType);
				TextView item_attentionPeople = (TextView) item.findViewById(R.id.item_attentionPeople);
								
				 
				// 传递参数
				item_bankIcon.setDrawingCacheEnabled(true);
				Bitmap obmp = Bitmap.createBitmap(item_bankIcon.getDrawingCache());
				item_bankIcon.setDrawingCacheEnabled(false);
				
				Bundle product_bundle = new Bundle();
				
				product_bundle.putFloat(Constants.ITEM_RATINGBAR, item_ratingbar.getRating());
				product_bundle.putString(Constants.ITEM_PROFIT, item_profit.getText().toString());
				product_bundle.putString(Constants.ITEM_INVESTPERIOD, item_investperiod.getText().toString());
				product_bundle.putString(Constants.ITEM_PERIOD, item_period.getText().toString());
				product_bundle.putString(Constants.ITEM_TYPE, item_type.getText().toString());
				product_bundle.putString(Constants.ITEM_STARTMONEY, item_startmoney.getText().toString());
				product_bundle.putString(Constants.ITEM_PRODUCTITEM, item_productitem.getText().toString());
				product_bundle.putString(Constants.ITEM_PRODUCTTYPE, item_productType.getText().toString());
				product_bundle.putString(Constants.ITEM_ATTENTIONPEOPLE, item_attentionPeople.getText().toString());
				
				Intent product_detail_intent = new Intent();
				product_detail_intent.putExtra(Constants.PRODUCT_DETAIL,product_bundle);
				product_detail_intent.putExtra(Constants.ITEM_BANKICON, obmp);
				
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

	private void initListProductActionBar() {
			//得到屏幕的宽度和高度 
	       screenWidth = this.getWindowManager().getDefaultDisplay().getWidth(); 
	       screenHeight = this.getWindowManager().getDefaultDisplay().getHeight(); 
	       mTitleTextView.measure(MeasureSpec.UNSPECIFIED,MeasureSpec.UNSPECIFIED);
//	       Log.d("title width", String.valueOf(mTitleTextView.getMeasuredWidth()));
	       
	       LinearLayout layout = (LinearLayout)findViewById(R.id.title_layout);
	       ImageView image = new ImageView(this);
	       image.setBackgroundResource(R.drawable.top_m);
	       LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
	       params.gravity=Gravity.CENTER_VERTICAL;
	       image.setLayoutParams(params);
	       layout.addView(image);
	       
	       mLinearLayout.setOnClickListener(mLinearLayoutClick);
			
			mtitlePopupWindow = new MtitlePopupWindow(this);
			mtitlePopupWindow.changeData(Arrays.asList(titles));
			mtitlePopupWindow.setOnPopupWindowClickListener(new OnPopupWindowClickListener() {
				@Override
				public void onPopupWindowItemClick(int position) {
					mTitleTextView.setText(titles[position]);
//					Toast.makeText(getApplication(), items[position], Toast.LENGTH_SHORT).show();
				}
			});
			popupWindowHeight = mtitlePopupWindow.getHeight(); 
		    popupWindowWidth = mtitlePopupWindow.getWidth(); 	
	       
	       
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
//		getMenuInflater().inflate(R.menu.list_product, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_list_product;
	}
	
	private OnClickListener mLinearLayoutClick = new OnClickListener() {
		public void onClick(View v) {
			mLinearLayoutWidth = mLinearLayout.getWidth();
			mtitlePopupWindow.showAsDropDown(v,(mLinearLayoutWidth-popupWindowWidth)/2,0);
		}
	};

}
