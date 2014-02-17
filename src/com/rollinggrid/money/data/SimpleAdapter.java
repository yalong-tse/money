package com.rollinggrid.money.data;

import java.util.List;

import com.rollinggrid.money.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SimpleAdapter extends ArrayAdapter<SimpleItem> {
	Context context; 
    private LayoutInflater inflater;   
    List<SimpleItem> data = null;
    
    public SimpleAdapter(Context context, List<SimpleItem> data) {
    	super(context, 0, data);
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View row = convertView;
    	ViewHolder holder = null;
    	SimpleItem item = (SimpleItem) data.get(position);
    	if(item != null) {
    		row = inflater.inflate(R.layout.list_items_1, null);
    		holder = new ViewHolder();
    		holder.image = (ImageView) row.findViewById(R.id.list_item_imageview_1);
    		holder.content = (TextView) row.findViewById(R.id.list_item_textview_1);
    		row.setTag(holder);
    	} else {
    		holder = (ViewHolder)row.getTag();
    	}
    	
    	holder.image.setImageResource(item.image);
    	holder.content.setText(item.content);
    	
    	return row;
    }
    
    static class ViewHolder {
    	ImageView image;
    	TextView content;
    }
}
