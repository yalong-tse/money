package com.rolling.money.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.rolling.money.R;

public class MtitlePopupWindow extends PopupWindow {
	/**
	 * �����Ķ���
	 */
	private Context mContext;
	/**
	 * �ص��ӿڶ���
	 */
	private OnPopupWindowClickListener listener;
	/**
	 * ArrayAdapter����
	 */
	private ArrayAdapter adapter;
	/**
	 * ListView������Դ
	 */
	private List<String> list = new ArrayList<String>();
	/**
	 * PopupWindow�Ŀ��
	 */
	private int width = 0;

	public MtitlePopupWindow(Context context){
		super(context); 
		mContext = context;
		initView();
	}
	
	private void initView(){
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View popupView = inflater.inflate(R.layout.title_popupwindow, null);
		setContentView(popupView);
		
		//���ÿ��,��û�����ÿ��ΪLayoutParams.WRAP_CONTENT
		setWidth(250);  
		setHeight(LayoutParams.WRAP_CONTENT);
		
		//���ö�����Ҳ���Բ����á�������������ʾĬ�ϵ�
//		setAnimationStyle(R.style.popupwindow_animation);
		
		//�������Ҫ�����������ListView�ò�����Ӧ
		this.setFocusable(true);
	    this.setBackgroundDrawable(new BitmapDrawable()); 
	    this.setOutsideTouchable(true);
	    	
		ListView listView = (ListView) popupView.findViewById(R.id.popupwindow);
//		adapter = new ArrayAdapter(mContext, R.layout.popupwindow_item, R.id.popup_item, list);
		adapter = new ArrayAdapter(mContext, R.layout.title_popupwindow_item, R.id.popup_item, list);
		listView.setAdapter(adapter);
		
		//ListView�ĵ���¼�
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				MtitlePopupWindow.this.dismiss();
				if(listener != null){
					listener.onPopupWindowItemClick(position);
				}
			}
		});
		
	}
	
	/**
	 * ΪPopupWindow���ûص��ӿ�
	 * @param listener
	 */
	public void setOnPopupWindowClickListener(OnPopupWindowClickListener listener){
		this.listener = listener;
	}
	

	/**
	 * �������ݵķ��������ⲿ����
	 * @param mList
	 */
	public void changeData(List<String> mList) {
		//������addAllҲ����Ҫ�������this.list = mList������notifyDataSetChanged()��Ч
		//notifyDataSetChanged()����Դ�����ı��ʱ����õģ�this.list = mList��list��û�з��͸ı�
		list.addAll(mList);
		adapter.notifyDataSetChanged();
	}
	
	
	/**
	 * �ص��ӿ�.���ⲿ����
	 */
	public interface OnPopupWindowClickListener{
		/**
		 * �����PopupWindow��ListView ��item��ʱ����ô˷������ûص������ĺô����ǽ��������
		 * @param position λ��
		 */
		void onPopupWindowItemClick(int position);
	}


}

