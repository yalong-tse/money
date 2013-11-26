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
	

	private final String[] job_arr={"公务员","白领","退休","私营企业主","自由职业者"};
	private final String[] know_arr = {"有专业执照","财经专业毕业生","自修有心得","懂一些","一无所知"};
	private final String[] family_arr = {"单亲无子女","单亲有子女","双亲有子女","双亲无子女","抚/赡养三代"};
	private final String[] house_arr = {"无房且有投资房产","自宅无房贷","房贷>50%","房贷<50%","无自住房","无自住房且有投资房"};
	private final String[] experience_arr  = {"10年以上","6-10年","2-5年","1年以下"};
	private final String[] age_arr= {"60岁以上","50-60","40-50","30-40","20-30","20岁以下"};
	private final String[] tolerance_arr = {"不能容忍任何损失","5%","10%","15%","15%以上"};
	private final String[] firstfactor_arr = {"赚短期差价","长期稳健获利","每年固定分红","抗通胀保值","保本"};
	private final String[] archivement_arr = {"只赚不赔","赚多赔少","损益两平","赚少赔多","只赔不赚"};
	private final String[] mental_arr = {"学习经验","照常过日子","影响情绪小","影响情绪大"};
	private final String[] maininvest_arr = {"股票","基金","房地产","信托","银行存款"};
	private final String[] refusetools_arr = {"无","期货","股票","基金","房地产","信托","银行存款"};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_risk_testing);
		
		TextView textView = (TextView)findViewById(R.id.title);
		textView.setText("风险测试");
	
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
		
		
		Log.d("风险测试", "进入Adapter");
		
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
