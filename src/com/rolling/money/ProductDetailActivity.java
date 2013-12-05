package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ProductDetailActivity extends Activity {

	// 生成动态数组，加入数据
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

	String[] productitems = { "乾元—尊享型2013年第12期理财产品(55天)",
			"心喜系列2013年第46期人民币组合投资型非保本理财产品(182天)",
			"本无忧系列2013年第46期美元银行间保证收益理财产品(365天)", "汇通理财2013年惠添利2449号理财产品(365天)",
			"中银稳富ZYWFSH042013097(170天)人民币理财计划",
			"高净值客户专属240天增利人民币理财产品(ZL240D02)", "鑫意理财福通2013079期人民币理财产品(92天)",
			"招银进宝之鼎鼎成金10015号理财计划(90天)", "金钥匙安心得利2013年第1800期人民币理财产品(36天)",
			"平安财富-私行专享尊贵组合A资产管理类2013年30期人民币理财产品" };
	String[] items = { "光大银行", "中国银行", "建设银行", "农业银行", "招商银行", "平安银行", "工商银行",
			"华夏银行" };
	String[] profits = { "3.5%", "4.5%", "2.8%", "3.5%", "4.3%", "6.5%",
			"4.6%", "4.3%" };
	String[] startmoney = { "1万", "2万", "3万", "4万", "5万", "6万", "7万", "8万" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_detail);

		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("产品详情");
		
		
		// 处理列表界面传递过来的参数
		Bundle bundle = this.getIntent().getBundleExtra(Constants.PRODUCT_DETAIL);
		String product_name = bundle.getString(Constants.PRODUCT_NAME);
		String product_profit = bundle.getString(Constants.PRODUCT_PROFIT);
		String product_startbuy = bundle.getString(Constants.PRODUCT_START_BUY);
		

		TextView tv_product_name = (TextView) findViewById(R.id.product_detail_name_textview);
		TextView tv_product_profit = (TextView) findViewById(R.id.product_detail_profit_value);
		TextView tv_product_startbuy = (TextView) findViewById(R.id.product_detail_start_value);
		ImageView product_imageview = (ImageView) findViewById(R.id.product_detail_productimage_imageview);

		// 处理图片
		Bitmap bitmap = this.getIntent().getParcelableExtra(Constants.PRODUCT_DRAWABLE);
		
		
		tv_product_name.setText(product_name);
		tv_product_profit.setText(product_profit);
		tv_product_startbuy.setText(product_startbuy);
		product_imageview.setImageBitmap(bitmap);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_detail, menu);
		return true;
	}

}
