package com.rollinggrid.money;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import com.rollinggrid.money.R;
import com.rollinggrid.money.data.SimpleAdapter;
import com.rollinggrid.money.data.SimpleItem;

public class CalActivity extends BaseBarActivity {
	
	ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("��Ƽ�����");
		
		listview = (ListView) findViewById(R.id.activity_cal_listview);
		
		List<SimpleItem> list = new ArrayList<SimpleItem>();
		list.add(new SimpleItem(R.drawable.cal_deposit, "��������"));
		list.add(new SimpleItem(R.drawable.cal_loan, "����������"));
		list.add(new SimpleItem(R.drawable.cal_debt, "��ծ������"));
		
		SimpleAdapter adapter = new SimpleAdapter(this, list);
		listview.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.cal, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_cal;
	}

}
