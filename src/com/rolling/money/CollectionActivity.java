package com.rolling.money;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rolling.money.data.IProduct;
import com.rolling.money.data.ProductAdapter2;
import com.rolling.money.data.ProductEntry2;
import com.rolling.money.data.ProductSection;

public class CollectionActivity extends BaseBarActivity {

	ListView listview;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_collection);
		
		List<IProduct> data = new ArrayList<IProduct>();
		data.add(new ProductSection("������Ʋ�Ʒ"));
		data.add(new ProductEntry2(5F,"3.5", "2013/7/10~2013/7/30", "12����","Ԥ��", "3��", R.drawable.guangdayinhang,"������� | ǬԪ��������2013���12����Ʋ�Ʒ(55��)", "������������" , "25�˹�ע"));
		
		data.add(new ProductSection("�����ʲ��������Ʒ"));
		data.add(new ProductEntry2(5F, "5", "2013/9/8~2013/9/20", "65��", "Ԥ��","10��",R.drawable.guangdayinhang, "������� | ��������A", "������������", "78�˹�ע"));
		
		data.add(new ProductSection("�������Ʒ"));
		data.add(new ProductEntry2(3.5F, "11.2", "2013/9/8~2013/10/9", "12����", "Ԥ��", "100��", R.drawable.fangzhengxintuo, "�������� | ���ſعɼ����ʽ����в�Ʒ", "�Ǳ�����������", "5�˹�ע"));
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("�ҵ��ղ�");
		
		listview = (ListView)findViewById(R.id.list_mycollection);
		
		ProductAdapter2 adapter = new ProductAdapter2(this, data);
		
		listview.setAdapter(adapter);
		
		// ѡ����Ŀ���������
		listview.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
RelativeLayout item = (RelativeLayout) view;
				
				// ��ȡÿһ��listview��ֵ
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
								
				 
				// ���ݲ���
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

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_collection;
	}

}
