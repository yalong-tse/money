package com.rolling.money.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rolling.money.R;

public class CustomTitle extends RelativeLayout {
	private Context mContext;
	private LayoutInflater layoutInflater;
	private ImageView leftImage;
	private TextView textView;
	private ImageView rightImage;
	
	public CustomTitle(Context context) {
		super(context);
		this.mContext = context;
		inflate();
	    bindViews();
		
	}
	
	// 填充布局
	private void inflate() {
		if(layoutInflater == null) {
			layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		layoutInflater.inflate(R.layout.title, this, true);
			
	}
	
	// 绑定所有的view
	private void bindViews() {
		leftImage  = (ImageView)findViewById(R.id.title_img_left);
		textView = (TextView)findViewById(R.id.title);
		rightImage = (ImageView)findViewById(R.id.title_img_right);
	}
	
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.title_img_left:
			Toast.makeText(mContext, "left_image_clicked", Toast.LENGTH_SHORT).show();
			break;
		case R.id.title:
			Toast.makeText(mContext, "center_textview_clicked", Toast.LENGTH_SHORT).show();
			break;
		case R.id.title_img_right:
			Toast.makeText(mContext, "right_image_clicked", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
