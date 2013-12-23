package com.rolling.money;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RiskTestFragment2 extends Fragment {
	
	private Spinner spinner_tolerance;
	private Spinner spinner_firstfactor;
	private Spinner spinner_archivement;
	private Spinner spinner_mentalstate;
	private Spinner spinner_maininvest;
	private Spinner spinner_refuse_investtools;
	
	private final String[] tolerance_arr = {"���������κ���ʧ","5%","10%","15%","15%����"};
	private final String[] firstfactor_arr = {"׬���ڲ��","�����Ƚ�����","ÿ��̶��ֺ�","��ͨ�ͱ�ֵ","����"};
	private final String[] archivement_arr = {"ֻ׬����","׬������","������ƽ","׬�����","ֻ�ⲻ׬"};
	private final String[] mental_arr = {"ѧϰ����","�ճ�������","Ӱ������С","Ӱ��������"};
	private final String[] maininvest_arr = {"��Ʊ","����","���ز�","����","���д��"};
	private final String[] refusetools_arr = {"��","�ڻ�","��Ʊ","����","���ز�","����","���д��"};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.risktest2, container, false);
		
		this.spinner_firstfactor = (Spinner) view.findViewById(R.id.risktesting_firstfactor);
		this.spinner_archivement = (Spinner) view.findViewById(R.id.risktesting_archivement);
		this.spinner_maininvest = (Spinner) view.findViewById(R.id.risktesting_main_invest);
		this.spinner_mentalstate = (Spinner) view.findViewById(R.id.risktesting_lost_mentalstate);
		this.spinner_refuse_investtools = (Spinner) view.findViewById(R.id.risktesting_refuse_investtools);
		this.spinner_tolerance = (Spinner) view.findViewById(R.id.risktesting_tolerance);
		
		//tolerance
		ArrayAdapter<String> tolerance_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item,tolerance_arr);
		tolerance_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_tolerance.setAdapter(tolerance_adapter);
				
		// firstfactor
		ArrayAdapter<String> firstfactor_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,firstfactor_arr);
		firstfactor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_firstfactor.setAdapter(firstfactor_adapter);
				
		//archivement
		ArrayAdapter<String> archivement_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,archivement_arr);
		archivement_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_archivement.setAdapter(archivement_adapter);
				
		//mentalstate
		ArrayAdapter<String> mentalstate_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,mental_arr);
		mentalstate_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_mentalstate.setAdapter(mentalstate_adapter);
				
		// maininvest
		ArrayAdapter<String> maininvest_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,maininvest_arr);
		maininvest_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_maininvest.setAdapter(maininvest_adapter);
				
		// refuseinvest
		ArrayAdapter<String> refuseinvest_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_spinner_item,refusetools_arr);
		refuseinvest_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner_refuse_investtools.setAdapter(refuseinvest_adapter);
		
		return view;
	}
}
