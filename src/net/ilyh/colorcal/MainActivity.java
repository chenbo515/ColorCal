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

public class MainActivity extends Activity
{

	private String calRes(int ringOne,int ringTwo,int ringThree,int ringFour)
	{
		return "null";
	}
	
	private void refreshUI()
	{
		for(int i=0;i<view.length;i++)
			view[i].setBackgroundColor(Color.parseColor(ColorHexValue.get(spinner[i].getSelectedItem().toString())));
		
	}
	
	View[] view=new View[5];
	Spinner[] spinner=new Spinner[5];
	RadioButton radioButton1,radioButton2;
	RadioGroup radioGroup;
	String[] valueString={"Black","Brown","Red","Orange","Yellow","Green","Blue","Violet","Grey","White"};
	String[] multiplyStrings={"Black","Brown","Red","Orange","Yellow","Green","Blue","Violet","Grey","White","Gold","Silver"};
	String[] accurateStrings={"Brown","Red","Gold"};
	@SuppressWarnings("serial")
	Map<String, String> ColorHexValue=new HashMap<String,String>()
	{{
		put("Black", "#000000");
		put("Brown", "#964B00");
		put("Red", "#FF0000");
		put("Orange", "#FFA500");
		put("Yellow","#FFFF00");
		put("Green", "#0x80000");
		put("Blue", "#0000FF");
		put("Violet","#800080");
		put("Grey","#808080");
		put("White", "#FF0000");
		put("Gold", "#FFD700");
		put("Silver","#C0C0C0");
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
		
		view[0].setBackgroundColor(Color.RED);
		view[1].setBackgroundColor(Color.BLACK);
		view[2].setBackgroundColor(Color.BLACK);
		view[3].setBackgroundColor(Color.BLUE);
		view[4].setBackgroundColor(Color.YELLOW);
		
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
