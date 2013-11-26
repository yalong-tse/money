package com.rolling.money;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class RiskTestingActivity extends Activity {
	
	private Spinner spinner_job;
	private Spinner spinner_knowledge;
	private Spinner spinner_family;
	private Spinner spinner_house;
	private Spinner spinner_experience;
	private Spinner spinner_age;
	private Spinner spinner_tolerance;
	private Spinner spinner_firstfactor;
	private Spinner spinner_archivement;
	private Spinner spinner_mentalstate;
	private Spinner spinner_maininvest;
	private Spinner spinner_refuse_investtools;
	

	private final String[] job_arr={"����Ա","����","����","˽Ӫ��ҵ��","����ְҵ��"};
	private final String[] know_arr = {"��רҵִ��","�ƾ�רҵ��ҵ��","�������ĵ�","��һЩ","һ����֪"};
	private final String[] family_arr = {"��������Ů","��������Ů","˫������Ů","˫������Ů","��/��������"};
	private final String[] house_arr = {"�޷�����Ͷ�ʷ���","��լ�޷���","����>50%","����<50%","����ס��","����ס������Ͷ�ʷ�"};
	private final String[] experience_arr  = {"10������","6-10��","2-5��","1������"};
	private final String[] age_arr= {"60������","50-60","40-50","30-40","20-30","20������"};
	private final String[] tolerance_arr = {"���������κ���ʧ","5%","10%","15%","15%����"};
	private final String[] firstfactor_arr = {"׬���ڲ��","�����Ƚ�����","ÿ��̶��ֺ�","��ͨ�ͱ�ֵ","����"};
	private final String[] archivement_arr = {"ֻ׬����","׬������","������ƽ","׬�����","ֻ�ⲻ׬"};
	private final String[] mental_arr = {"ѧϰ����","�ճ�������","Ӱ������С","Ӱ��������"};
	private final String[] maininvest_arr = {"��Ʊ","����","���ز�","����","���д��"};
	private final String[] refusetools_arr = {"��","�ڻ�","��Ʊ","����","���ز�","����","���д��"};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_risk_testing);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("���ղ���");
	
		this.spinner_age = (Spinner) findViewById(R.id.risktesting_age);
		this.spinner_job = (Spinner) findViewById(R.id.risktesting_job);
		this.spinner_knowledge = (Spinner) findViewById(R.id.risktesting_know);
		this.spinner_family = (Spinner) findViewById(R.id.risktesting_family);
		this.spinner_firstfactor = (Spinner) findViewById(R.id.risktesting_firstfactor);
		this.spinner_archivement = (Spinner) findViewById(R.id.risktesting_archivement);
		this.spinner_experience = (Spinner) findViewById(R.id.risktesting_experience);
		this.spinner_house = (Spinner) findViewById(R.id.risktesting_house);
		this.spinner_maininvest = (Spinner) findViewById(R.id.risktesting_main_invest);
		this.spinner_mentalstate = (Spinner) findViewById(R.id.risktesting_lost_mentalstate);
		this.spinner_refuse_investtools = (Spinner) findViewById(R.id.risktesting_refuse_investtools);
		this.spinner_tolerance = (Spinner) findViewById(R.id.risktesting_tolerance);
		
		
		Log.d("���ղ���", "����Adapter");
		
		// age
		ArrayAdapter<String> age_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,age_arr);
		age_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_age.setAdapter(age_adapter);
		
		// job
		ArrayAdapter<String> job_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,job_arr);
		job_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_job.setAdapter(job_adapter);
		
		// knowledge
		ArrayAdapter<String> know_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,know_arr);
		know_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_knowledge.setAdapter(know_adapter);
		
		//family
		ArrayAdapter<String> family_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,family_arr);
		family_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_family.setAdapter(family_adapter);
		
		//house
		ArrayAdapter<String> house_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,house_arr);
		house_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_house.setAdapter(house_adapter);
		
		//experience
		ArrayAdapter<String> experience_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,experience_arr);
		experience_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_experience.setAdapter(experience_adapter);
		
		//tolerance
		ArrayAdapter<String> tolerance_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tolerance_arr);
		tolerance_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_tolerance.setAdapter(tolerance_adapter);
		
		// firstfactor
		ArrayAdapter<String> firstfactor_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,firstfactor_arr);
		firstfactor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_firstfactor.setAdapter(firstfactor_adapter);
		
		//archivement
		ArrayAdapter<String> archivement_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,archivement_arr);
		archivement_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_archivement.setAdapter(archivement_adapter);
		
		//mentalstate
		ArrayAdapter<String> mentalstate_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mental_arr);
		mentalstate_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_mentalstate.setAdapter(mentalstate_adapter);
		
		// maininvest
		ArrayAdapter<String> maininvest_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,maininvest_arr);
		maininvest_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_maininvest.setAdapter(maininvest_adapter);
		
		// refuseinvest
		ArrayAdapter<String> refuseinvest_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,refusetools_arr);
		refuseinvest_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_refuse_investtools.setAdapter(refuseinvest_adapter);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.risk_testing, menu);
		return true;
	}

}
