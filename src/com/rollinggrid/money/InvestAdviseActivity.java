package com.rollinggrid.money;

import java.util.ArrayList;
import java.util.List;

import com.rollinggrid.money.R;
import com.rollinggrid.money.data.IProduct;
import com.rollinggrid.money.data.ProductAdapter2;
import com.rollinggrid.money.data.ProductEntry2;
import com.rollinggrid.money.data.ProductSection;
import com.rollinggrid.money.utils.ImageHelper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class InvestAdviseActivity extends BaseBarActivity {
	
	ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("投资建议");
		
		// 设置理财师头像
		ImageView licaishi = (ImageView) findViewById(R.id.invest_profile_licaishi);
		Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.person_profile);
		bmp = ImageHelper.getRoundedCornerBitmap(bmp, 10);
		
		licaishi.setImageBitmap(bmp);
		
		// 设置联系他
		Button button = (Button) findViewById(R.id.investadvise_contact);
		button.setOnClickListener(licaishiClickListener);
		
		// 设置listview
		listview = (ListView) findViewById(R.id.list_product_investadvise);
		
		List<IProduct> data = new ArrayList<IProduct>();
		data.add(new ProductSection("方案一"));
		data.add(new ProductEntry2(5F,"3.5", "2013/7/7~2014/7/6", "12个月","预售", "3万", R.drawable.guangdayinhang,"光大银行 | 乾元—尊享型2013年第12期理财产品(55天)", "保本浮动收益" , "25人关注"));
		data.add(new ProductEntry2(4F,"5", "2013/6/24~2013/7/5", "6个月","预售", "5万", R.drawable.huaxiayinhang, "华夏银行 | 金钥匙安心得利2013年第1800期人民币理财产品(36天)", "保本浮动收益", "24人关注"));
		
		data.add(new ProductSection("方案二"));
		data.add(new ProductEntry2(5F,"4.5", "2013/6/24~2013/7/5", "24个月","预售", "5万", R.drawable.gongshangyinhang, "工商银行 | 招银进宝之鼎鼎成金10015号理财计划(90天)", "保本浮动收益",  "30人关注"));
		data.add(new ProductEntry2(5F, "5", "2013/9/8~2013/9/20", "65天", "预售","10万",R.drawable.guangdayinhang, "光大银行 | 颐享阳光A", "保本浮动收益", "78人关注"));
		
		data.add(new ProductSection("方案三"));
		data.add(new ProductEntry2(3.5F, "8.2", "2013/8/8~2013/9/9", "6个月", "预售", "100万", R.drawable.fangzhengxintuo, "方正信托 | 华门控股集合资金信托产品", "非保本浮动收益", "5人关注"));
		
		listview = (ListView)findViewById(R.id.list_product_investadvise);
		
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
				
				product_detail_intent.setClass(InvestAdviseActivity.this, ProductDetailActivity.class);
				startActivity(product_detail_intent);
			}
			
		});
		
	}
	
	private OnClickListener licaishiClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
				FragmentManager fm = getSupportFragmentManager();
			  	LicaiDialogFragment dialog = LicaiDialogFragment.newInstance();
			  	
			  	dialog.show(fm, "fragment_edit_name");
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.invest_advise, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_invest_advise;
	}

}
