package com.rolling.money.data;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rolling.money.R;

public class ProductAdapter extends ArrayAdapter<IProduct> {
	Context context; 
    private LayoutInflater inflater;   
    List<IProduct> data = null;
    
    public ProductAdapter(Context context, List<IProduct> data) {
    	super(context, 0, data);
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View row = convertView;
    	ProductHolder holder = null;
    	IProduct product = data.get(position);
    	if(product != null) {
    		if(product.isSection()) { // section
    			ProductSection ps = (ProductSection)product;
    			row = inflater.inflate(R.layout.list_product_section, null);
    			
    			row.setOnClickListener(null);
    			row.setOnLongClickListener(null);
    			row.setLongClickable(false);
    			
    			/*LinearLayout layout = (LinearLayout) row.findViewById(R.id.list_item_section_text);
				final TextView sectionView = (TextView) layout.findViewById(android.R.id.title);*/
    			TextView sectionView = (TextView)row.findViewById(R.id.list_item_section_text);
				
				sectionView.setText(ps.getTitle());
    			
    		} else { // entry
    			ProductEntry pe = (ProductEntry)product;
    			if(row == null || !(row.getTag() instanceof ProductHolder))
    	        {
	    			row = inflater.inflate(R.layout.list_product_listview_item, null);
	    			
	    			holder = new ProductHolder();
	    			holder.bankIcon = (ImageView) row.findViewById(R.id.list_product_listview_imageview);
	    			holder.productitem = (TextView) row.findViewById(R.id.list_product_listview_textview_title);
	    			holder.profit = (TextView) row.findViewById(R.id.list_product_listview_textview_profit);
	    			holder.startmoney = (TextView) row.findViewById(R.id.list_product_listview_textview_startmoney);
	    			holder.detail = (TextView) row.findViewById(R.id.list_product_listview_textview_detail);
	    			
	    			row.setTag(holder);
    	        } else {
    	        	holder = (ProductHolder)row.getTag();
    	        }
    			
    			holder.bankIcon.setImageResource(pe.bankIcon);
    			holder.productitem.setText(pe.productitem);
    			holder.detail.setText(pe.detail);
    			holder.profit.setText(pe.profit);
    			holder.startmoney.setText(pe.startmoney);
    			
    		}
    	}
    	
    	return row;
    }
    
    static class ProductHolder 
    {
    	ImageView bankIcon;
    	TextView productitem;
    	TextView detail;
    	TextView profit;
    	TextView startmoney;
    }
    
}
