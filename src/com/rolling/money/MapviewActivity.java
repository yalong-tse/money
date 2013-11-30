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
		
		textView.setText("�����ѯ");
		
		
		mBMapMan = new BMapManager(getApplication());
		mBMapMan.init("205114502786B06C4C95CEB0F55822F25E46AED2", null);
		
		mMKSearch = new MKSearch();   
		
		mMKSearch.init(mBMapMan, new MapSearchListener());//ע�⣬MKSearchListenerֻ֧��һ���������һ������Ϊ׼  
		
		// һ�����ӣ���ѯ����ptLB �� ptRT ��Χ�ڵ�������������
		// ������վ   
		GeoPoint ptLB = new GeoPoint( (int)(39.901375 * 1E6),(int)(116.329099 * 1E6));    
		// ������վ   
		GeoPoint ptRT = new GeoPoint( (int)(39.949404 * 1E6),(int)(116.360719 * 1E6));   
		mMKSearch.poiSearchInbounds("��������", ptLB, ptRT);  

		
		
		super.initMapActivity(mBMapMan);
		MapView mMapView = (MapView) findViewById(R.id.bmapsView);

		mMapView.setBuiltInZoomControls(true); // �����������õ����ſؼ�
		mMapView.setTraffic(true);

		MapController mMapController = mMapView.getController(); // �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����
		
		GeoPoint geoBeijing=new GeoPoint((int)(39.95*1000000), (int)(116.37*1000000));

		mMapController.setCenter(geoBeijing); // ���õ�ͼ���ĵ�
		mMapController.setZoom(12); // ���õ�ͼzoom����

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
