package no.nith.pj3100_13.snowflakes_of_doom.ui;

import android.os.AsyncTask;
import android.util.Log;
import no.nith.pj3100_13.snowflakes_of_doom.R;
import no.nith.pj3100_13.snowflakes_of_doom.dto.TextDto;
import no.nith.pj3100_13.snowflakes_of_doom.util.AbstractActivity;
import no.nith.pj3100_13.snowflakes_of_doom.util.ObjectSerializer;

public class TextViewActivity extends AbstractActivity {

	private TextDto text;
	private static final String url = "http://emunch.no/No-MM_T2730-12v.xml";
	
	protected void init() {
		super.init(R.layout.activity_text);
	}

	protected void initGui() {
		Log.i("Test", "b4 parse");
		new GetResultsTask().execute();
	}

	protected void initListeners() {
		
	}
	
	 private class GetResultsTask extends AsyncTask<Void, Void, TextDto> {

		@Override
		protected TextDto doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			return ObjectSerializer.fromXML(url);
		}
		
		protected void onPostExecute(TextDto result) {
			text = result;
			Log.i("Test", "after parse");
			super.onPostExecute(result);
		}
		 
	 }
	
}
