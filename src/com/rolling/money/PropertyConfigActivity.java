package com.rolling.money;

import com.rolling.money.utils.ImageHelper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

// http://stackoverflow.com/questions/18451575/action-bar-fragment-activity
// Extend Activity classes from ActionBarCompat: ActionBarCompat contains one Activity class 
// which all of your Activity classes should extend: ActionBarActivity. This class itself extends from 
// FragmentActivity so you can continue to use Fragments in your application. There is not a 
// ActionBarCompat Fragment class that you need to extend, so you should continue using 
// android.support.v4.Fragment as the base class for your Fragments.

//public class PropertyConfigActivity extends FragmentActivity {
public class PropertyConfigActivity extends BaseBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_property_config);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("资产配置");
		
		ImageView iv1 = (ImageView)findViewById(R.id.config_invest_profile);
		
		Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.my_profile_2);
		bmp = ImageHelper.getRoundedCornerBitmap(bmp, 10);
		
		iv1.setImageBitmap(bmp);
		
		TextView config_description = (TextView) findViewById(R.id.config_description);
		String first = "<font color='#a3a3a3'>投资者描述：</font>";
		String next = "青年男士，事业有成家庭幸福，有房有车，收入稳定，无房贷压力，可用于投资的财富相对宽松，有一定投资经验。专家建议可选用银行理财产品，基金类产品进行周期性投资实现长期财富增值。";
		config_description.setText(Html.fromHtml(first + next));
		
		
		/*TextView contactme = (TextView)findViewById(R.id.config_consultant_contactme);
		
		contactme.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showMyDialog();
			}

			private void showMyDialog() {
				FragmentManager fm = getSupportFragmentManager();
			  	LicaiDialogFragment dialog = LicaiDialogFragment.newInstance();
			  	
			  	dialog.show(fm, "fragment_edit_name");
			}
		});*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.property_config, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_property_config_2;
	}

}
