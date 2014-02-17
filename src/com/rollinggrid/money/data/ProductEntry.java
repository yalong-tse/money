package com.rollinggrid.money.data;

public class ProductEntry implements IProduct {

	public final int bankIcon;             // 所属银行图标
	public final String productitem;  // 产品名称
	public final String detail;             // 发行银行
	public final String profit;            // 预期收益率
	public final String startmoney;   // 起购金额
	
	
	/**
	 * 
	 * @param bankIcon 银行图标
	 * @param productitem  产品名称
	 * @param detail 发行银行
	 * @param profit 预期收益率
	 * @param startmoney  起购金额
	 */
	public ProductEntry(int bankIcon, String productitem, String detail,  String profit, String startmoney) {
		this.bankIcon = bankIcon;
		this.productitem = productitem;
		this.detail = detail;
		this.profit = profit;
		this.startmoney = startmoney;
	}
	
	@Override
	public boolean isSection() {
		return false;
	}

}
