package com.example.awea;

import android.support.v7.app.ActionBarActivity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	public static TextView weight;
	public String selectedAnimal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.spinner1, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		        if(pos == 0){
		        	selectedAnimal = "cow - dairy";
		        }else if(pos == 1) {
		        	selectedAnimal = "cow - beef";
		        }else if(pos == 2) {
		        	selectedAnimal = "pig";
		        }else if(pos == 3){
		        	selectedAnimal = "goat - beetal"; 
		        }else if(pos == 4){
		        	selectedAnimal = "horse";
		        }
		        Log.d("ANIMAL SELECTED:    ", selectedAnimal);
		    }
		    public void onNothingSelected(AdapterView<?> parent) {
		    }
		});
		weight = (TextView) findViewById(R.id.textView4);
		
	}
	
	public void goToMeasurementPage(View view){
		Intent intent = null;
		if(selectedAnimal.equalsIgnoreCase("cow - dairy")) {
			intent = new Intent(this, CowDairyMeasurementActivity.class);
		}else if(selectedAnimal.equalsIgnoreCase("cow - beef")){
			intent = new Intent(this, CowBeefMeasurementActivity.class);
		}else if(selectedAnimal.equalsIgnoreCase("pig")){
			
		}else if(selectedAnimal.equalsIgnoreCase("goat - beetal")){
			intent = new Intent(this, GoatBeetalMeasurementActivity.class);
		}
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}


