package com.rolling.money;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RiskTestFragment1 extends Fragment {
	
	private Spinner spinner_job;
	private Spinner spinner_knowledge;
	private Spinner spinner_family;
	private Spinner spinner_house;
	private Spinner spinner_experience;
	private Spinner spinner_age;
	
	private final String[] job_arr={"公务员","白领","退休","私营企业主","自由职业者"};
	private final String[] know_arr = {"有专业执照","财经专业毕业生","自修有心得","懂一些","一无所知"};
	private final String[] family_arr = {"单薪无子女","单薪有子女","双薪有子女","双薪无子女","抚/赡养三代"};
	private final String[] house_arr = {"无房且有投资房产","自宅无房贷","房贷>50%","房贷<50%","无自住房","无自住房且有投资房"};
	private final String[] experience_arr  = {"10年以上","6-10年","2-5年","1年以下"};
	private final String[] age_arr= {"60岁以上","50-60","40-50","30-40","20-30","20岁以下"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.risktest1, container, false);
		
		this.spinner_age = (Spinner) view.findViewById(R.id.risktesting_age);
		this.spinner_job = (Spinner) view.findViewById(R.id.risktesting_job);
		this.spinner_knowledge = (Spinner) view.findViewById(R.id.risktesting_know);
		this.spinner_family = (Spinner) view.findViewById(R.id.risktesting_family);
		this.spinner_experience = (Spinner) view.findViewById(R.id.risktesting_experience);
		this.spinner_house = (Spinner) view.findViewById(R.id.risktesting_house);
		
		// age
		ArrayAdapter<String> age_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.drawable.drop_list_hover,age_arr);
		age_adapter.setDropDownViewResource(R.drawable.custom_spinner);
		spinner_age.setAdapter(age_adapter);
				
		// job
		ArrayAdapter<String> job_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.drawable.drop_list_hover,job_arr);
		job_adapter.setDropDownViewResource(R.drawable.custom_spinner);
		spinner_job.setAdapter(job_adapter);
				
		// knowledge
		ArrayAdapter<String> know_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.drawable.drop_list_hover,know_arr);
		know_adapter.setDropDownViewResource(R.drawable.custom_spinner);
		spinner_knowledge.setAdapter(know_adapter);
				
		//family
		ArrayAdapter<String> family_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.drawable.drop_list_hover,family_arr);
		family_adapter.setDropDownViewResource(R.drawable.custom_spinner);
		spinner_family.setAdapter(family_adapter);
				
		//house
		ArrayAdapter<String> house_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.drawable.drop_list_hover,house_arr);
		house_adapter.setDropDownViewResource(R.drawable.custom_spinner);
		spinner_house.setAdapter(house_adapter);
				
		//experience
		ArrayAdapter<String> experience_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.drawable.drop_list_hover,experience_arr);
		experience_adapter.setDropDownViewResource(R.drawable.custom_spinner);
		spinner_experience.setAdapter(experience_adapter);
				
		return view;
	}
}
