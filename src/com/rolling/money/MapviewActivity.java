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

	// my key  for baidumapapi_v2.3.0.jar ��key���Լ�ע���key
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
		textView.setText("�����ѯ");
		
		mMapView.getController().enableClick(true);
		mMapView.getController().setZoom(16);
		//Log.d("mapview", "222222222222");
		
		GeoPoint xizhimen = new GeoPoint((int) (39.949404 * 1E6),(int) (116.360719 * 1E6));
		mMapView.getController().animateTo(xizhimen);
		mMKSearch = new MKSearch();
		mMKSearch.init(app.mBMapManager, new MapSearchListener());
		
		//Log.d("mapview", "3333333333333333333");
		// ������ֱ�ŵ���վ500�׷�Χ����������
		mMKSearch.poiSearchNearBy("����", xizhimen, 5000);
		
		
		//Log.d("MAP TEST", "1111111111");
		
		
		// mMKSearch = new MKSearch();

		// mMKSearch.init(mBMapMan, new MapSearchListener());//
		// ע�⣬MKSearchListenerֻ֧��һ���������һ������Ϊ׼

		// һ�����ӣ���ѯ����ptLB �� ptRT ��Χ�ڵ�������������
		// ������վ
		GeoPoint ptLB = new GeoPoint((int) (39.901375 * 1E6),(int) (116.329099 * 1E6));
		// ������վ
		GeoPoint ptRT = new GeoPoint((int) (39.949404 * 1E6),(int) (116.360719 * 1E6));
		// mMKSearch.poiSearchInbounds("��������", ptLB, ptRT);

		//super.initMapActivity(mBMapMan);

		

		// mMapView.setBuiltInZoomControls(true); // �����������õ����ſؼ�
		// mMapView.setTraffic(true);

		// MapController mMapController = mMapView.getController(); //
		// �õ�mMapView�Ŀ���Ȩ,�����������ƺ�����ƽ�ƺ�����

		// GeoPoint geoBeijing = new GeoPoint((int) (39.95 * 1000000),(int)
		// (116.37 * 1000000));

		// mMapController.setCenter(ptRT); // ���õ�ͼ���ĵ�
		// mMapController.setZoom(12); // ���õ�ͼzoom����


		
		
		
		//MapController mapController = mMapView.getController();
		// ���õ�ͼ������
		//mapController.setCenter(xizhimen);
		// ���õ�ͼĬ�ϵ����ż���
		//mapController.setZoom(16);
		// ��ʼ��
//		MKSearch mMKSearch = new MKSearch();
//		mMKSearch.init(mBMapMan, new MapSearchListener());
//		// ������ֱ�ŵ���վ500�׷�Χ����������
//		mMKSearch.poiSearchNearBy("����", xizhimen, 5000);
		
		
		// ��Ӷ�λͼ��
		//mLocationOverlay = new MyLocationOverlay(this, mMapView);
		//mMapView.getOverlays().add(mLocationOverlay);		

		// ע�ᶨλ�¼�
//		mLocationListener = new LocationListener() {
//			@Override
//			public void onLocationChanged(Location location) {
//				if (location != null) {
//					GeoPoint xizhimen = new GeoPoint((int) (39.949404 * 1E6),(int) (116.360719 * 1E6));
//					mMapView.getController().animateTo(xizhimen);
//					MapController mapController = mMapView.getController();
//					// ���õ�ͼ������
//					mapController.setCenter(xizhimen);
//					// ���õ�ͼĬ�ϵ����ż���
//					mapController.setZoom(16);
//					// ��ʼ��
//					MKSearch mMKSearch = new MKSearch();
//					mMKSearch.init(mBMapMan, new MapSearchListener());
//					// ������ֱ�ŵ���վ500�׷�Χ����������
//					mMKSearch.poiSearchNearBy("��������", xizhimen, 5000);
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
	
	
	// �����¼���������������ͨ�������������Ȩ��֤�����
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

			
			// ����ſɲο�MKEvent�еĶ���
            if (error != 0 || res == null) {
                Toast.makeText(MapviewActivity.this, "��Ǹ��δ�ҵ����", Toast.LENGTH_LONG).show();
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
                //��ePoiTypeΪ2��������·����4��������·��ʱ�� poi����Ϊ��
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
