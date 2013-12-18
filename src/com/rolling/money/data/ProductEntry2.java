package com.rolling.money.data;

public class ProductEntry2 implements IProduct{
	public final float ratingNum;     // ���ǣ��磺5��3.5
	public final String profit;            // Ԥ��������, �磺6.50%
	
	public final String investPeriod;  // Ͷ����ֹʱ�䣬�磺2013/6/24~2013/7/5
	public final String period;            // Ͷ�����ޣ��磺24��
	public final String type;               // �������ͣ��磺Ԥ��
	public final String startmoney;   // �𹺽��, �磺5��
	
	public final int bankIcon;             // ��������ͼ��
	public final String productitem;  // ��Ʒ����
	
	public final String productType; //��Ʒ���ͣ��磺������������
	public final String attentionPeople;  // ��ע�������磺25�˹�ע
	
	/**
	 * ���캯��
	 * @param ratingNum ���ǣ��磺5��3.5
	 * @param profit Ԥ��������, �磺6.50%
	 * @param investPeriod Ͷ����ֹʱ�䣬�磺2013/6/24~2013/7/5
	 * @param period Ͷ�����ޣ��磺24��
	 * @param type �������ͣ��磺Ԥ��
	 * @param startmoney �𹺽��, �磺5��
	 * @param bankIcon ��������ͼ��
	 * @param productitem ��Ʒ����
	 * @param productType ��Ʒ���ͣ��磺������������
	 * @param attentionPeople ��ע�������磺25�˹�ע
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
