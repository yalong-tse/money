package com.rolling.money;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.rolling.money.utils.ImageHelper;

public class PersonInfoActivity extends BaseBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_person_info);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("∏ˆ»À…Ë÷√");
		
		ImageView iv1 = (ImageView)findViewById(R.id.my_profile);
		
		Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.my_profile);
		bmp = ImageHelper.getRoundedCornerBitmap(bmp, 10);
		
		iv1.setImageBitmap(bmp);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_info, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_person_info;
	}

}
