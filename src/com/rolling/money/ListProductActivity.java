package com.rolling.money;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListProductActivity extends Activity {

	private ListView listview;
	
	   
	//生成动态数组，加入数据   
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
	
	String[] productitems={"乾元—尊享型2013年第12期理财产品(55天)","心喜系列2013年第46期人民币组合投资型非保本理财产品(182天)","本无忧系列2013年第46期美元银行间保证收益理财产品(365天)",
			"汇通理财2013年惠添利2449号理财产品(365天)","中银稳富ZYWFSH042013097(170天)人民币理财计划","高净值客户专属240天增利人民币理财产品(ZL240D02)",
			"鑫意理财福通2013079期人民币理财产品(92天)","招银进宝之鼎鼎成金10015号理财计划(90天)","金钥匙安心得利2013年第1800期人民币理财产品(36天)",
			"平安财富-私行专享尊贵组合A资产管理类2013年30期人民币理财产品"};
	String[] items = {"光大银行","中国银行","建设银行","农业银行","招商银行","平安银行","工商银行","华夏银行"};
	String[] profits = {"3.5%","4.5%","2.8%","3.5%","4.3%","6.5%","4.6%","4.3%"};
	String[] startmoney = {"1万","2万","3万","4万","5万","6万","7万","8万"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_product);
		
		listview = (ListView) findViewById(R.id.list_product_listview);
		
		for(int i=0;i<items.length;i++)
		{
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("ItemImage", R.drawable.bank_account_gold);
			map.put("ItemText", productitems[i]);
			map.put("ItemDetail", "发行银行：" + items[i]);
			map.put("profit","预期收益率：" +  profits[i]);
			map.put("startmoney", "起够金额：" + startmoney[i]);
			listItem.add(map);
		}
		
		
		SimpleAdapter listAdapter = new SimpleAdapter(this,listItem,R.layout.list_product_listview_item,
				new String[]{"ItemImage","ItemText","ItemDetail","profit","startmoney"},
				new int[]{R.id.list_product_listview_imageview,
				R.id.list_product_listview_textview_title,
				R.id.list_product_listview_textview_detail,
				R.id.list_product_listview_textview_profit,
				R.id.list_product_listview_textview_startmoney});
		
		
		listview.setAdapter(listAdapter);
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_product, menu);
		return true;
	}

}
