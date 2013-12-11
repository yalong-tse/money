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
		data.add(new ProductSection("银行理财产品"));
		data.add(new ProductEntry(R.drawable.guangdayinhang, "乾元—尊享型2013年第12期理财产品(55天)", "发行银行：光大银行", "预期收益率：3.5%", "起购金额：1万"));
		data.add(new ProductEntry(R.drawable.zhaoshangyinhang, "中银稳富ZYWFSH042013097(170天)人民币理财计划", "发行银行：招商银行", "预期收益率：4.3%", "起购金额：5万"));
		data.add(new ProductEntry(R.drawable.jiaotongyinhang, "高净值客户专属240天增利人民币理财产品(ZL240D02)", "发行银行：交通银行", "预期收益率：6.5%", "起购金额：6万"));
		data.add(new ProductEntry(R.drawable.gongshangyinhang, "招银进宝之鼎鼎成金10015号理财计划(90天)", "发行银行：工商银行", "预期收益率：4.6%", "起购金额：7万"));
		data.add(new ProductEntry(R.drawable.huaxiayinhang, "金钥匙安心得利2013年第1800期人民币理财产品(36天)", "发行银行：华夏银行", "预期收益率：4.3%", "起购金额：8万"));
		
		data.add(new ProductSection("银行资产管理类产品"));
		data.add(new ProductEntry(R.drawable.guangdayinhang, "颐享阳光A", "发行银行：光大银行", "预期收益率：5%", "起购金额：10万"));
		
		data.add(new ProductSection("信托类产品"));
		data.add(new ProductEntry(R.drawable.fangzhengxintuo, "华门控股集合资金信托产品", "发行机构：方正信托", "预期收益率：9.8%至11.2%", "起购金额：100万"));
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("每日推荐");
		
		listview = (ListView)findViewById(R.id.list_recommend);
		
		ProductAdapter adapter = new ProductAdapter(this, data);
		
		listview.setAdapter(adapter);
		
		
		// 选择条目打开详情界面
		listview.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				LinearLayout line_layout = (LinearLayout) view;
				TextView tv_productname = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_title);
				TextView tv_productprofit = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_profit);
				TextView tv_productstartbuy = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_startmoney);
				TextView tv_productdetail = (TextView) line_layout.findViewById(R.id.list_product_listview_textview_detail); //  发行银行
				ImageView iv_titleimage = (ImageView) line_layout.findViewById(R.id.list_product_listview_imageview);
				 
				// 传递参数
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
				product_bundle.putString(Constants.PRODUCT_BANK_NAME, product_detail.substring(product_detail.indexOf("：")+1));
				
				
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
