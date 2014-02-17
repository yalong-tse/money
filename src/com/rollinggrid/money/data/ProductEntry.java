package com.rollinggrid.money.data;

public class ProductEntry implements IProduct {

	public final int bankIcon;             // ��������ͼ��
	public final String productitem;  // ��Ʒ����
	public final String detail;             // ��������
	public final String profit;            // Ԥ��������
	public final String startmoney;   // �𹺽��
	
	
	/**
	 * 
	 * @param bankIcon ����ͼ��
	 * @param productitem  ��Ʒ����
	 * @param detail ��������
	 * @param profit Ԥ��������
	 * @param startmoney  �𹺽��
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
