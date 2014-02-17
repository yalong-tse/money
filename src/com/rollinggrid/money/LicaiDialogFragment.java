package com.rollinggrid.money;

import com.rollinggrid.money.R;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;

public class LicaiDialogFragment extends DialogFragment {
	
	public LicaiDialogFragment() {
		
	}
	
	/** creates a new instance of PropDialogFragment */
    static LicaiDialogFragment newInstance() {
    	LicaiDialogFragment f = new LicaiDialogFragment();
        return f;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setStyle(STYLE_NO_FRAME, R.style.colorPickerStyle);
    	// this setStyle is VERY important.
        // STYLE_NO_FRAME means that I will provide my own layout and style for the whole dialog
        // so for example the size of the default dialog will not get in my way
        // the style extends the default one. see bellow.    
    	// http://stackoverflow.com/questions/14946887/setting-the-size-of-a-dialogfragment
    	
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	  View view = inflater.inflate(R.layout.licai_dialog, container); 
//    	  getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);  // 去掉dialog上面的多余title区域
    	  
    	  /*ImageView close_dialog = (ImageView) view.findViewById(R.id.close_button);
  		
	  		close_dialog.setOnClickListener(new View.OnClickListener() {
	
	              public void onClick(View v) {
	              	dismiss();
	              }
	          });*/
    	  final Button btn1 = (Button)view.findViewById(R.id.dialog_btn_1);
    	  final Button btn2 = (Button)view.findViewById(R.id.dialog_btn_2);
    	  final Button btn3 = (Button)view.findViewById(R.id.dialog_btn_3);
    	  final Button btn4 = (Button)view.findViewById(R.id.dialog_btn_4);
    	  
    	  // http://stackoverflow.com/questions/4142090/how-do-you-to-retrieve-dimensions-of-a-view-getheight-and-getwidth-always-r
    	  ViewTreeObserver vto  = btn2.getViewTreeObserver();
    	  vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@SuppressLint("NewApi")
			@Override
			public void onGlobalLayout() {
				// TODO Auto-generated method stub
				
				int width=btn2.getWidth();
				btn3.setWidth(width);
				btn4.setWidth(width);
				
//				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//		            btn1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//		        } else {
		        	btn1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//		        }
			}
		});
    	  
	  		return view;
    }
    
    /*@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	//getting proper access to LayoutInflater is the trick
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.mydialog2, null); 
        
        ImageView close_dialog = (ImageView) view.findViewById(R.id.close_button);
		
		close_dialog.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
            	dismiss();
            }
        });
        
        AlertDialog.Builder builder = new AlertDialog.Builder(getSherlockActivity());
        builder.setView(view);
        
        
        return builder.create();
    }*/
}
