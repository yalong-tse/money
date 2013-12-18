package com.rolling.money.data;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rolling.money.R;

public class ProductAdapter2 extends ArrayAdapter<IProduct> {
	Context context; 
    private LayoutInflater inflater;   
    List<IProduct> data = null;
    
    public ProductAdapter2(Context context, List<IProduct> data) {
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
    			ProductEntry2 pe = (ProductEntry2)product;
    			if(row == null || !(row.getTag() instanceof ProductHolder))
    	        {
	    			row = inflater.inflate(R.layout.list_product_listview_item2, null);
	    			
	    			holder = new ProductHolder();
	    			holder.bankIcon = (ImageView) row.findViewById(R.id.item_bankIcon);
	    			holder.ratingbar = (RatingBar) row.findViewById(R.id.item_ratingBar);
	    			holder.profit = (TextView) row.findViewById(R.id.item_profit);
	    			holder.investPeriod = (TextView) row.findViewById(R.id.item_investperiod);
	    			holder.period = (TextView) row.findViewById(R.id.item_period);
	    			holder.type = (TextView) row.findViewById(R.id.item_type);
	    			holder.startmoney = (TextView) row.findViewById(R.id.item_startmoney);
	    			holder.productitem = (TextView) row.findViewById(R.id.item_productitem);
	    			holder.productType = (TextView) row.findViewById(R.id.item_productType);
	    			holder.attentionPeople = (TextView) row.findViewById(R.id.item_attentionPeople);
	    			
	    			row.setTag(holder);
    	        } else {
    	        	holder = (ProductHolder)row.getTag();
    	        }
    			
    			holder.bankIcon.setImageResource(pe.bankIcon);
    			holder.ratingbar.setRating(pe.ratingNum);
    			holder.profit.setText(pe.profit);
    			holder.investPeriod.setText(pe.investPeriod);
    			holder.period.setText(pe.period);
    			holder.type.setText(pe.type);
    			holder.startmoney.setText(pe.startmoney);
    			holder.productitem.setText(pe.productitem);
    			holder.productType.setText(pe.productType);
    			holder.attentionPeople.setText(pe.attentionPeople);
    		}
    	}
    	
    	return row;
    }
    
    static class ProductHolder 
    {
    	ImageView bankIcon;             // 发行机构图标
    	RatingBar ratingbar;               // 几星，如：5或3.5
    	TextView profit;                     // 预期收益率, 如：6.50%  
    	TextView investPeriod;          // 投资起止时间，如：2013/6/24~2013/7/5
    	TextView period;                    // 投资期限，如：24天
    	TextView type;                       // 销售类型，如：预售
    	TextView startmoney;           // 起购金额, 如：5万
    	TextView productitem;         // 产品名称
    	TextView productType;        // 产品类型，如：保本浮动收益
    	TextView attentionPeople;   // 关注人数，如：25人关注
    }
    
}
