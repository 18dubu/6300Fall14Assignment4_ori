package edu.gatech.seclass.unitconvertor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CurrencyActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_currency);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.currency, menu);
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
	public String usd2euro(double usd){
		double euro = 0.79 * usd;
		return String.valueOf(euro);
	}
		
	public String euro2usd(double euro){
		double usd = euro/0.79;
		return String.valueOf(usd);
	}
	//handle radio button click event
	public void handleClick(View view){
		boolean checked = ((RadioButton) view).isChecked();
		EditText txt = (EditText) findViewById(R.id.EditText_curr);
		double currentCurr = Double.parseDouble(txt.getText().toString());
		switch(view.getId()){
		case R.id.radio_usd:
			if(checked)
				txt.setText(euro2usd(currentCurr));
			break;
		case R.id.radio_euro:
			if(checked)
				txt.setText(usd2euro(currentCurr));
			break;
		}
	}
	
}
