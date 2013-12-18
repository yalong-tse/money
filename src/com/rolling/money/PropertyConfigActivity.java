package com.rolling.money;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
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
		textView.setText("×Ê²úÅäÖÃ");
		
		TextView contactme = (TextView)findViewById(R.id.config_consultant_contactme);
		
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
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.property_config, menu);
		return true;
	}

	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_property_config;
	}

}
