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
	
	private final String[] job_arr={"����Ա","����","����","˽Ӫ��ҵ��","����ְҵ��"};
	private final String[] know_arr = {"��רҵִ��","�ƾ�רҵ��ҵ��","�������ĵ�","��һЩ","һ����֪"};
	private final String[] family_arr = {"��н����Ů","��н����Ů","˫н����Ů","˫н����Ů","��/��������"};
	private final String[] house_arr = {"�޷�����Ͷ�ʷ���","��լ�޷���","����>50%","����<50%","����ס��","����ס������Ͷ�ʷ�"};
	private final String[] experience_arr  = {"10������","6-10��","2-5��","1������"};
	private final String[] age_arr= {"60������","50-60","40-50","30-40","20-30","20������"};
	
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
