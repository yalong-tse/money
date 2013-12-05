package com.rolling.money;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class PropertyConfigActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_config);
		
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

}
