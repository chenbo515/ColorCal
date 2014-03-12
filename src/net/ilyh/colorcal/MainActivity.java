package net.ilyh.colorcal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.R.bool;
import android.R.color;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.lang.Math;
public class MainActivity extends Activity
{

	private String calRes(int ringOne,int ringTwo,int ringThree,int ringFour)
	{
		return "null";
	}
	
	private void refreshUI()
	{
		double res_value;
		for(int i=0;i<view.length;i++)
			view[i].setBackgroundColor(Color.parseColor(ColorHexValue.get(spinner[i].getSelectedItem().toString())));
		
		if(is4RingMode)
		{
			res_value=10*Arrays.asList(valueString).indexOf(spinner[0].getSelectedItem())
			+Arrays.asList(valueString).indexOf(spinner[1].getSelectedItem());
			
		}
		else
		{
			res_value=100*Arrays.asList(valueString).indexOf(spinner[0].getSelectedItem())
			+10*Arrays.asList(valueString).indexOf(spinner[1].getSelectedItem())
			+Arrays.asList(valueString).indexOf(spinner[2].getSelectedItem());
		}
		int mul_value;
		mul_value=Arrays.asList(multiplyStrings).indexOf(spinner[3].getSelectedItem());
		if(mul_value>9)
		{
			res_value=res_value/(Math.pow(10, mul_value-9));
		}
		else
		{
			res_value=res_value*Math.pow(10, mul_value);
		}
		String res_string,accuracy_string;
		if(res_value<1000) res_string=String.format("%f次", res_value);
		else if(res_value<10E6) res_string=String.format("%fk次",res_value/1000);
		else if(res_value<10E9) res_string=String.format("%fM次",res_value/10E6);
		else res_string=String.format("%fG次", res_value/10E9);
		
		if(spinner[4].getSelectedItem().toString()=="Brown") accuracy_string="㊣1%";
		else if(spinner[4].getSelectedItem().toString()=="Red") accuracy_string="㊣2%";
		else if(spinner[4].getSelectedItem().toString()=="Gold") accuracy_string="㊣5%";
		else accuracy_string="㊣20%";
		textView.setText("Resistance value="+res_string+"\r\nAccuracy="+accuracy_string);
	}
	
	View[] view=new View[5];
	Spinner[] spinner=new Spinner[5];
	RadioButton radioButton1,radioButton2;
	RadioGroup radioGroup;
	TextView textView;
	String[] valueString={"Black","Brown","Red","Orange","Yellow","Green","Blue","Violet","Grey","White"};
	String[] multiplyStrings={"Black","Brown","Red","Orange","Yellow","Green","Blue","Violet","Grey","White","Gold","Silver"};
	String[] accurateStrings={"Brown","Red","Gold","None"};
	@SuppressWarnings("serial")
	Map<String, String> ColorHexValue=new HashMap<String,String>()
	{{
		put("Black", "#000000");
		put("Brown", "#964B00");
		put("Red", "#FF0000");
		put("Orange", "#FFA500");
		put("Yellow","#FFFF00");
		put("Green", "#008000");
		put("Blue", "#0000FF");
		put("Violet","#800080");
		put("Grey","#808080");
		put("White", "#FFFFFF");
		put("Gold", "#FFD700");
		put("Silver","#C0C0C0");
		put("None", "#808080");
	}};
	boolean is4RingMode;
	ArrayAdapter<String> valueStringAdapter,multiplyStringAdapter,accurateStringAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		valueStringAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, valueString);
		valueStringAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		multiplyStringAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,multiplyStrings);
		multiplyStringAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		accurateStringAdapter=new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item,accurateStrings);
		accurateStringAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		view[0]=findViewById(R.id.view1);
		view[1]=findViewById(R.id.view2);
		view[2]=findViewById(R.id.view3);
		view[3]=findViewById(R.id.view4);
		view[4]=findViewById(R.id.view5);
		

		
		spinner[0]=(Spinner)findViewById(R.id.spinner1);
		spinner[1]=(Spinner)findViewById(R.id.spinner2);
		spinner[2]=(Spinner)findViewById(R.id.spinner3);
		spinner[3]=(Spinner)findViewById(R.id.spinner4);
		spinner[4]=(Spinner)findViewById(R.id.spinner5);
		
		
		spinner[0].setAdapter(valueStringAdapter);
		spinner[1].setAdapter(valueStringAdapter);
		spinner[2].setAdapter(valueStringAdapter);
		spinner[3].setAdapter(multiplyStringAdapter);
		spinner[4].setAdapter(accurateStringAdapter);
		
		radioButton1=(RadioButton) findViewById(R.id.radiobutton1);
		radioButton2=(RadioButton) findViewById(R.id.radiobutton2);
		textView=(TextView)findViewById(R.id.textView1);
		//radioButton1.setSelected(true);
		view[2].setVisibility(View.GONE);
		spinner[2].setVisibility(View.GONE);
		is4RingMode=true;
		refreshUI();
		radioGroup=(RadioGroup)findViewById(R.id.radiogroup1);
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
		{
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				// TODO Auto-generated method stub
				if(checkedId==radioButton1.getId())
				{
					view[2].setVisibility(View.GONE);
					spinner[2].setVisibility(View.GONE);
					is4RingMode=true;
				}
				if(checkedId==radioButton2.getId())
				{
					view[2].setVisibility(View.VISIBLE);
					spinner[2].setVisibility(View.VISIBLE);
					is4RingMode=false;
				}
			}
		});
		
		for(int i=0;i<view.length;i++)
		{
			spinner[i].setOnItemSelectedListener(new OnItemSelectedListener()
			{

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3)
				{
					// TODO Auto-generated method stub
					refreshUI();
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0)
				{
					// TODO Auto-generated method stub
					
				}
			});
		}

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
