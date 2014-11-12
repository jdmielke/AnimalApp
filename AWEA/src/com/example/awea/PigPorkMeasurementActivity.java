package com.example.awea;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class PigPorkMeasurementActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pig_pork_measurement);
	}
	
	public void goToMain(View view){
		
		EditText input1 = (EditText) findViewById(R.id.editText1);
		EditText input2 = (EditText) findViewById(R.id.editText2);
		int girth = Integer.valueOf(input1.getText().toString());
		int length = Integer.valueOf(input2.getText().toString());

		int weight = (girth * girth * length) / 400;
		
		MainActivity.weight.setText(String.valueOf(weight) + "  lbs");
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pig_pork_measurement, menu);
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
