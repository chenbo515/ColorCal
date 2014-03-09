package net.ilyh.colorcal;

import android.os.Bundle;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity
{

	View[] view=new View[5];
	Spinner[] spinner=new Spinner[5];
	String[] ringColorsStrings={"RED","BLUE","GERY","YELLOW"};
	ArrayAdapter<String> arrayAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ringColorsStrings);
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
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		for(int i=0;i<spinner.length;i++)
			spinner[i].setAdapter(arrayAdapter);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
