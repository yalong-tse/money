package com.rollinggrid.money;

import com.rollinggrid.money.R;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class BaseBarActivity extends ActionBarActivity {
	// Action bar
    ActionBar mActionBar;
    LayoutInflater mInflater;
    View mCustomView;
    TextView mTitleTextView;
    ImageView loginaction;
    LinearLayout mLinearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResourceId());
		initActionBar();
	}
	
	private void initActionBar() {
		mActionBar = getSupportActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		mInflater = LayoutInflater.from(this);
		mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
		mTitleTextView = (TextView) mCustomView.findViewById(R.id.title);
		mLinearLayout = (LinearLayout) mCustomView.findViewById(R.id.title_layout);
//        mTitleTextView.setText("理财类产品");
        loginaction = (ImageView) mCustomView.findViewById(R.id.loginaction);
		loginaction.setOnTouchListener(touchListener);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
        // mActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.at_header_bg));
	}
	
	private OnClickListener loginListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startActivity(new Intent(BaseBarActivity.this, LoginActivity.class));
			//startLoginActivity();
		}
		
	};
	
	private OnTouchListener touchListener = new OnTouchListener(){

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                ImageView view = (ImageView) v;
                view.getDrawable().setColorFilter(0xFFFF8800, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
            	ImageView view = (ImageView) v;
                //clear the overlay
                view.getDrawable().clearColorFilter();
                view.invalidate();
            	startActivity(new Intent(BaseBarActivity.this, LoginActivity.class));
            }
            case MotionEvent.ACTION_CANCEL: {
                ImageView view = (ImageView) v;
                //clear the overlay
                view.getDrawable().clearColorFilter();
                view.invalidate();
                break;
            }
        }

        return true;
		}
		
	};
	
	/**
	 * 每个activity单独的layout文件
	 */
	public abstract int getLayoutResourceId();
}
