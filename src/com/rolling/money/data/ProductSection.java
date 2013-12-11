package com.rolling.money.data;

public class ProductSection implements IProduct {

	private final String title;
	
	public ProductSection(String title) {
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	@Override
	public boolean isSection() {
		return true;
	}

}
