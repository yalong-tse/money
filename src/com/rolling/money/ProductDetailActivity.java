package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.rolling.money.utils.CustomGridview;
import com.rolling.money.utils.ImageHelper;

public class ProductDetailActivity extends BaseBarActivity {

	// 生成动态数组，加入数据
	ArrayList<HashMap<String, Object>> menuitems = new ArrayList<HashMap<String, Object>>();

	private String[] items_fun = {"加入收藏","预约购买","网点查询","产品解读","关联产品","同行产品","用户评论","理财计算器"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_product_detail);

		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("产品详情");
		
		ImageView licaishi = (ImageView) findViewById(R.id.my_profile_licaishi);
		Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.person_profile);
		bmp = ImageHelper.getRoundedCornerBitmap(bmp, 10);
		
		licaishi.setImageBitmap(bmp);
		licaishi.setOnClickListener(licaishiClickListener);
		
		final ScrollView scroll = (ScrollView) findViewById(R.id.product_detail_scrollview);
		
		// http://stackoverflow.com/questions/4119441/how-to-scroll-to-top-of-long-scrollview-layout
		scroll.smoothScrollTo(0,0);  // 必须要有这句话，fullScroll(ScrollView.FOCUS_UP)是不起作用的；否则scrollview默认会显示在gridview的顶部
		
		// 处理列表界面传递过来的参数
		Bundle bundle = this.getIntent().getBundleExtra(Constants.PRODUCT_DETAIL);
		float item_ratingbar = bundle.getFloat(Constants.ITEM_RATINGBAR);
		String item_profit = bundle.getString(Constants.ITEM_PROFIT);
		String item_investperiod = bundle.getString(Constants.ITEM_INVESTPERIOD);
		String item_period = bundle.getString(Constants.ITEM_PERIOD);
		String item_type = bundle.getString(Constants.ITEM_TYPE);
		String item_startmoney = bundle.getString(Constants.ITEM_STARTMONEY);
		String item_productitem = bundle.getString(Constants.ITEM_PRODUCTITEM);
		String item_productType = bundle.getString(Constants.ITEM_PRODUCTTYPE);
		String item_attentionPeople = bundle.getString(Constants.ITEM_ATTENTIONPEOPLE);
		
		TextView product_detail_issuer = (TextView) findViewById(R.id.product_detail_issuer);
		RatingBar product_detail_ratingbar = (RatingBar) findViewById(R.id.product_detail_ratingbar);
		TextView product_detail_productitem = (TextView) findViewById(R.id.product_detail_productitem);
		ImageView product_detail_bankicon = (ImageView) findViewById(R.id.product_detail_bankicon);
		TextView product_detail_profit = (TextView) findViewById(R.id.product_detail_profit);
		TextView product_detail_producttype = (TextView) findViewById(R.id.product_detail_producttype);
		TextView product_detail_startmoney = (TextView) findViewById(R.id.product_detail_startmoney);
		TextView product_detail_period = (TextView) findViewById(R.id.product_detail_period);
		TextView product_detail_investperiod = (TextView) findViewById(R.id.product_detail_investperiod);
		
		product_detail_issuer.setText(item_productitem.substring(0, item_productitem.indexOf("|")).trim());
		product_detail_ratingbar.setRating(item_ratingbar);
		product_detail_productitem.setText(item_productitem.substring(item_productitem.indexOf("|")+1).trim());
		product_detail_profit.setText(item_profit);
		product_detail_producttype.setText(item_productType);
		product_detail_startmoney.setText(item_startmoney);
		product_detail_period.setText(item_period);
		product_detail_investperiod.setText(item_investperiod);
		
		// 处理图片
		Bitmap bitmap = this.getIntent().getParcelableExtra(Constants.ITEM_BANKICON);
		product_detail_bankicon.setImageBitmap(bitmap);
		
		CustomGridview grid_view = (CustomGridview) findViewById(R.id.product_detail_btngroups);
		
		for(int i=0;i<items_fun.length;i++)
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
			map.put("item", items_fun[i]);
			
			menuitems.add(map);
		}
		
		String[] from = {"image","item"};
		int[] to = {R.id.main_menuitem_image,R.id.main_menuitem_text};
		SimpleAdapter menuAdapter = new SimpleAdapter(this,
				menuitems,
				R.layout.main_items,
				from,to);
		
		grid_view.setAdapter(menuAdapter);
		
		grid_view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				switch(position) {
				// 加入收藏
				case 0:
					break;
				// 预约购买
				case 1:
					break;
				// 网点查询
				case 2:
					break;
				// 产品解读
				case 3:
					Intent intent = new Intent(ProductDetailActivity.this, ProductAnalyseActivity.class);
					startActivity(intent);
					break;
				// 关联产品
				case 4:
					break;
				// 同行产品
				case 5:
					break;
				// 用户评论
				case 6:
					break;
				// 理财计算器
				case 7:
					break;
				}
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.product_detail, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_product_detail_2;
	}
	
	private OnClickListener licaishiClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
				FragmentManager fm = getSupportFragmentManager();
			  	LicaiDialogFragment dialog = LicaiDialogFragment.newInstance();
			  	
			  	dialog.show(fm, "fragment_edit_name");
		}
	};
	
}
