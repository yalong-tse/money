package com.rollinggrid.money.data;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rollinggrid.money.RiskTestFragment1;
import com.rollinggrid.money.RiskTestFragment2;

public class MyPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragments;
	
	private String[] titles = {"个人情况", "投资情况"};
	
	public MyPagerAdapter(FragmentManager fm) {
		super(fm);
		this.fragments = new ArrayList<Fragment>();
		fragments.add(new RiskTestFragment1());
		fragments.add(new RiskTestFragment2());
	}
	
	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}
	
	@Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

	@Override
	public int getCount() {
		return fragments.size();
	}

}
