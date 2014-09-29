package edu.gatech.seclass.unitconvertor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DistanceActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.distance, menu);
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
	
	//Two convert methods
	public String mile2km(double mile){
		double km = 1.60934 * mile;
		return String.valueOf(km);
	}
		
	public String km2mile(double km){
		double mile = km/1.60934;
		return String.valueOf(mile);
	}
	
	//handle radio button click event
	public void handleClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		EditText txt = (EditText) findViewById(R.id.editText_dist);
		double currentDist = Double.parseDouble(txt.getText().toString());
		switch(view.getId()){
		case R.id.radio_km:
			if(checked)
				txt.setText(mile2km(currentDist));
			break;
		case R.id.radio_mile:
			if(checked)
				txt.setText(km2mile(currentDist));
			break;
		}
	}
}
