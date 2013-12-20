package com.rolling.money;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.MKAddrInfo;
import com.baidu.mapapi.search.MKBusLineResult;
import com.baidu.mapapi.search.MKDrivingRouteResult;
import com.baidu.mapapi.search.MKPoiInfo;
import com.baidu.mapapi.search.MKPoiResult;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.mapapi.search.MKShareUrlResult;
import com.baidu.mapapi.search.MKSuggestionResult;
import com.baidu.mapapi.search.MKTransitRouteResult;
import com.baidu.mapapi.search.MKWalkingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;

public class MapviewActivity extends BaseBarActivity {

	//private BMapManager mBMapMan;

	// my key  for baidumapapi_v2.3.0.jar 的key，自己注册的key
	String mStrKey = "VQlWYq291altvBQwTXMwzaZf";  

	private MKSearch mMKSearch = null;

	private MapView mMapView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		 MyApplication app = (MyApplication)this.getApplication();
         if (app.mBMapManager == null) {
             app.mBMapManager = new BMapManager(this);
             app.mBMapManager.init(MyApplication.strKey,new MyApplication.MyGeneralListener());
         }
         
		//mBMapMan = new BMapManager(getApplication());
		//mBMapMan.init("205114502786B06C4C95CEB0F55822F25E46AED2", new MyGeneralListener());
		
        //Log.d("mapview", "1111111111");
//		setContentView(R.layout.activity_mapview);
		mMapView = (MapView) findViewById(R.id.bmapsView);
		TextView textView = (TextView) findViewById(R.id.title);
		textView.setText("网点查询");
		
		mMapView.getController().enableClick(true);
		mMapView.getController().setZoom(16);
		//Log.d("mapview", "222222222222");
		
		GeoPoint xizhimen = new GeoPoint((int) (39.949404 * 1E6),(int) (116.360719 * 1E6));
		mMapView.getController().animateTo(xizhimen);
		mMKSearch = new MKSearch();
		mMKSearch.init(app.mBMapManager, new MapSearchListener());
		
		//Log.d("mapview", "3333333333333333333");
		// 搜索西直门地铁站500米范围的招商银行
		mMKSearch.poiSearchNearBy("银行", xizhimen, 5000);
		
		
		//Log.d("MAP TEST", "1111111111");
		
		
		// mMKSearch = new MKSearch();

		// mMKSearch.init(mBMapMan, new MapSearchListener());//
		// 注意，MKSearchListener只支持一个，以最后一次设置为准

		// 一个例子，查询所有ptLB 到 ptRT 范围内的所有招商银行
		// 北京西站
		GeoPoint ptLB = new GeoPoint((int) (39.901375 * 1E6),(int) (116.329099 * 1E6));
		// 北京北站
		GeoPoint ptRT = new GeoPoint((int) (39.949404 * 1E6),(int) (116.360719 * 1E6));
		// mMKSearch.poiSearchInbounds("招商银行", ptLB, ptRT);

		//super.initMapActivity(mBMapMan);

		

		// mMapView.setBuiltInZoomControls(true); // 设置启用内置的缩放控件
		// mMapView.setTraffic(true);

		// MapController mMapController = mMapView.getController(); //
		// 得到mMapView的控制权,可以用它控制和驱动平移和缩放

		// GeoPoint geoBeijing = new GeoPoint((int) (39.95 * 1000000),(int)
		// (116.37 * 1000000));

		// mMapController.setCenter(ptRT); // 设置地图中心点
		// mMapController.setZoom(12); // 设置地图zoom级别


		
		
		
		//MapController mapController = mMapView.getController();
		// 设置地图的中心
		//mapController.setCenter(xizhimen);
		// 设置地图默认的缩放级别
		//mapController.setZoom(16);
		// 初始化
//		MKSearch mMKSearch = new MKSearch();
//		mMKSearch.init(mBMapMan, new MapSearchListener());
//		// 搜索西直门地铁站500米范围的招商银行
//		mMKSearch.poiSearchNearBy("银行", xizhimen, 5000);
		
		
		// 添加定位图层
		//mLocationOverlay = new MyLocationOverlay(this, mMapView);
		//mMapView.getOverlays().add(mLocationOverlay);		

		// 注册定位事件
//		mLocationListener = new LocationListener() {
//			@Override
//			public void onLocationChanged(Location location) {
//				if (location != null) {
//					GeoPoint xizhimen = new GeoPoint((int) (39.949404 * 1E6),(int) (116.360719 * 1E6));
//					mMapView.getController().animateTo(xizhimen);
//					MapController mapController = mMapView.getController();
//					// 设置地图的中心
//					mapController.setCenter(xizhimen);
//					// 设置地图默认的缩放级别
//					mapController.setZoom(16);
//					// 初始化
//					MKSearch mMKSearch = new MKSearch();
//					mMKSearch.init(mBMapMan, new MapSearchListener());
//					// 搜索西直门地铁站500米范围的招商银行
//					mMKSearch.poiSearchNearBy("招商银行", xizhimen, 5000);
//				}
//			}
//
//		};

	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.mapview, menu);
		return true;
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		mMapView.destroy();
		mMKSearch.destory();
		super.onDestroy();
	}
	
	
	// 常用事件监听，用来处理通常的网络错误，授权验证错误等
    static class MyGeneralListener implements MKGeneralListener {
        
        @Override
        public void onGetNetworkState(int iError) {
           
        }

        @Override
        public void onGetPermissionState(int iError) {
            
        }
    }
	

	public class MapSearchListener implements MKSearchListener {

		@Override
		public void onGetAddrResult(MKAddrInfo arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onGetBusDetailResult(MKBusLineResult arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onGetDrivingRouteResult(MKDrivingRouteResult arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onGetPoiDetailSearchResult(int type, int error) {
			// TODO Auto-generated method stub
			
			

		}

		@Override
		public void onGetPoiResult(MKPoiResult res, int type, int error) {
			// TODO Auto-generated method stub

			
			// 错误号可参考MKEvent中的定义
            if (error != 0 || res == null) {
                Toast.makeText(MapviewActivity.this, "抱歉，未找到结果", Toast.LENGTH_LONG).show();
                return;
            }
            
            Log.d("MAP TEST", "222222222222222222");
            if (res.getCurrentNumPois() > 0) {
            	
            	MyPoiOverlay poiOverlay = new MyPoiOverlay(MapviewActivity.this, mMapView, mMKSearch);
            	Log.d("MAP TEST", "33333333333333333333");
                poiOverlay.setData(res.getAllPoi());
                mMapView.getOverlays().clear();
                mMapView.getOverlays().add(poiOverlay);
                mMapView.refresh();
                //当ePoiType为2（公交线路）或4（地铁线路）时， poi坐标为空
                for( MKPoiInfo info : res.getAllPoi() ){
                	if ( info.pt != null ){
                		mMapView.getController().animateTo(info.pt);
                		break;
                	}
                }
            }

		}


		@Override
		public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onGetTransitRouteResult(MKTransitRouteResult arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onGetWalkingRouteResult(MKWalkingRouteResult arg0, int arg1) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onGetShareUrlResult(MKShareUrlResult arg0, int arg1,
				int arg2) {
			// TODO Auto-generated method stub
			
		}

	}


	@Override
	public int getLayoutResourceId() {
		return R.layout.activity_mapview;
	}

}
