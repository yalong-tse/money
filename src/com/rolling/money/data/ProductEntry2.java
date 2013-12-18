package com.rolling.money.data;

public class ProductEntry2 implements IProduct{
	public final float ratingNum;     // 几星，如：5或3.5
	public final String profit;            // 预期收益率, 如：6.50%
	
	public final String investPeriod;  // 投资起止时间，如：2013/6/24~2013/7/5
	public final String period;            // 投资期限，如：24天
	public final String type;               // 销售类型，如：预售
	public final String startmoney;   // 起购金额, 如：5万
	
	public final int bankIcon;             // 所属银行图标
	public final String productitem;  // 产品名称
	
	public final String productType; //产品类型，如：保本浮动收益
	public final String attentionPeople;  // 关注人数，如：25人关注
	
	/**
	 * 构造函数
	 * @param ratingNum 几星，如：5或3.5
	 * @param profit 预期收益率, 如：6.50%
	 * @param investPeriod 投资起止时间，如：2013/6/24~2013/7/5
	 * @param period 投资期限，如：24天
	 * @param type 销售类型，如：预售
	 * @param startmoney 起购金额, 如：5万
	 * @param bankIcon 所属银行图标
	 * @param productitem 产品名称
	 * @param productType 产品类型，如：保本浮动收益
	 * @param attentionPeople 关注人数，如：25人关注
	 */
	public ProductEntry2(float ratingNum, String profit,
			String investPeriod, String period, String type, String startmoney,
			int bankIcon, String productitem,
			String productType, String attentionPeople) {
		super();
		this.ratingNum = ratingNum;
		this.profit = profit;
		this.investPeriod = investPeriod;
		this.period = period;
		this.type = type;
		this.startmoney = startmoney;
		this.bankIcon = bankIcon;
		this.productitem = productitem;
		this.productType = productType;
		this.attentionPeople = attentionPeople;
	}

	@Override
	public boolean isSection() {
		return false;
	}
}
