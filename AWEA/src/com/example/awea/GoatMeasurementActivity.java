package com.example.awea;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class GoatMeasurementActivity extends ActionBarActivity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goat_measurement);
		
		EditText input1 = (EditText) findViewById(R.id.editText1);
		EditText input2 = (EditText) findViewById(R.id.editText2);
		input1.setRawInputType(Configuration.KEYBOARD_12KEY);
		input2.setRawInputType(Configuration.KEYBOARD_12KEY);
	
	}

	public void goToMain(View view){
	
		EditText input1 = (EditText) findViewById(R.id.editText1);
		EditText input2 = (EditText) findViewById(R.id.editText2);
		int girth = Integer.valueOf(input1.getText().toString());
		int length = Integer.valueOf(input2.getText().toString());

		int weight = (girth * girth * length) / 300;
		
		MainActivity.weight.setText(String.valueOf(weight) + "  lbs");
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.measurement, menu);
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
