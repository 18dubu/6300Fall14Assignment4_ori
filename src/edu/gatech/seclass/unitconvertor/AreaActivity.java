package edu.gatech.seclass.unitconvertor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class AreaActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
	public String sf2sm(double sf){
		double sm = 0.092903 * sf;
		return String.valueOf(sm);
	}
		
	public String sm2sf(double sm){
		double sf = sm/0.092903;
		return String.valueOf(sf);
	}
	//handle radio button click event
	public void handleClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		EditText txt = (EditText) findViewById(R.id.EditText_area);
		double currentArea = Double.parseDouble(txt.getText().toString());
		switch(view.getId()){
		case R.id.radio_sf:
			if(checked)
				txt.setText(sm2sf(currentArea));
		
		case R.id.radio_sm:
			if(checked)
				txt.setText(sf2sm(currentArea));
		}
	}
}
