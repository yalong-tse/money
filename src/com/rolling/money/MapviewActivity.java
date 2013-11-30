package com.rolling.money;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MKSearch;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MapviewActivity extends MapActivity {

	private BMapManager mBMapMan;
	
	// my key
	String mStrKey = "02AD0B51770522AB1EECE64CB3ED44B6B930364F";
	
	private MKSearch mMKSearch = null;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapview);
		
		TextView textView = (TextView)findViewById(R.id.title);
		
		textView.setText("网点查询");
		
		
		mBMapMan = new BMapManager(getApplication());
		mBMapMan.init("205114502786B06C4C95CEB0F55822F25E46AED2", null);
		
		mMKSearch = new MKSearch();   
		
		mMKSearch.init(mBMapMan, new MapSearchListener());//注意，MKSearchListener只支持一个，以最后一次设置为准  
		
		// 一个例子，查询所有ptLB 到 ptRT 范围内的所有招商银行
		// 北京西站   
		GeoPoint ptLB = new GeoPoint( (int)(39.901375 * 1E6),(int)(116.329099 * 1E6));    
		// 北京北站   
		GeoPoint ptRT = new GeoPoint( (int)(39.949404 * 1E6),(int)(116.360719 * 1E6));   
		mMKSearch.poiSearchInbounds("招商银行", ptLB, ptRT);  

		
		
		super.initMapActivity(mBMapMan);
		MapView mMapView = (MapView) findViewById(R.id.bmapsView);

		mMapView.setBuiltInZoomControls(true); // 设置启用内置的缩放控件
		mMapView.setTraffic(true);

		MapController mMapController = mMapView.getController(); // 得到mMapView的控制权,可以用它控制和驱动平移和缩放
		
		GeoPoint geoBeijing=new GeoPoint((int)(39.95*1000000), (int)(116.37*1000000));

		mMapController.setCenter(geoBeijing); // 设置地图中心点
		mMapController.setZoom(12); // 设置地图zoom级别

	}

	@Override
	protected void onPause() {
		if (mBMapMan != null) {
			mBMapMan.stop();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		if (mBMapMan != null) {
			mBMapMan.start();
		}
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapview, menu);
		return true;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		if(mBMapMan!=null)
		{
			mBMapMan.destroy();
			mBMapMan = null;
		}
		super.onDestroy();
	}

}
