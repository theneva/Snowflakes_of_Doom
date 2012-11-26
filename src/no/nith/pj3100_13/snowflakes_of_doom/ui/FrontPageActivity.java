package no.nith.pj3100_13.snowflakes_of_doom.ui;

import no.nith.pj3100_13.snowflakes_of_doom.R;
import no.nith.pj3100_13.snowflakes_of_doom.util.AbstractActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FrontPageActivity extends AbstractActivity {

	private Button buttonNavigateToTextActivity;
	
	@Override
	protected void init() {
		super.setContentView(R.layout.activity_front_page);
	}

	@Override
	protected void initGui() {
		buttonNavigateToTextActivity = (Button) findViewById(R.id.button_navigate_to_text_activity);
	}

	@Override
	protected void initListeners() {
		buttonNavigateToTextActivity.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				navigateToActivity(TextViewActivity.class);
			}
		});
	}

}
