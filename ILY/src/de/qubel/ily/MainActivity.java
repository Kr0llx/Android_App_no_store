package de.qubel.ily;

import org.joda.time.DateTime;
import org.joda.time.Period;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView heart;
	private TextView date;
	private TextView unter;
	private TextView ueber;
	private Boolean timeRun = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getPeriod();
		ueber = (TextView) findViewById(R.id.ueberschrift);
		unter = (TextView) findViewById(R.id.unterschrift);
		date = (TextView) findViewById(R.id.date);
		heart = (ImageView) findViewById(R.id.herz);
		heart.setOnClickListener(this);
	}

	private void dateDiv() {
		Period pd = getPeriod();
		date.setText(getDateDiffString(pd));
	}

	private String getDateDiffString(Period pd) {

		String diffText = "";

		if (pd.getYears() != 0) {
			diffText = pd.getYears() + "J ";
		}
		if (pd.getMonths() != 0) {
			diffText = String.valueOf(diffText) + pd.getMonths() + "M ";
		}
		if (pd.getWeeks() != 0) {
			diffText = String.valueOf(diffText) + pd.getWeeks() + "W ";
		}
		if (pd.getDays() != 0) {
			diffText = String.valueOf(diffText) + pd.getDays() + "T ";
		}
		if (pd.getHours() != 0) {
			if (pd.getHours() < 10)
				diffText = String.valueOf(diffText) + "0" + pd.getHours()
						+ "St ";
			else
				diffText = String.valueOf(diffText) + pd.getHours() + "St ";
		}
		if (pd.getMinutes() != 0) {
			if (pd.getMinutes() < 10)
				diffText = String.valueOf(diffText) + "0" + pd.getMinutes()
						+ "min ";
			else
				diffText = String.valueOf(diffText) + pd.getMinutes() + "min ";
		}
		if (pd.getSeconds() >= 0) {
			if (pd.getSeconds() < 10)
				diffText = String.valueOf(diffText) + "0" + pd.getSeconds()
						+ "sek ";
			else
				diffText = String.valueOf(diffText) + pd.getSeconds() + "sek ";

		}
		if (pd.getMillis() >= 0) {

			if (pd.getMillis() < 100) {
				if (pd.getMillis() < 10) {
					diffText = String.valueOf(diffText) + "00" + pd.getMillis()
							+ "ms";
				} else {
					diffText = String.valueOf(diffText) + "0" + pd.getMillis()
							+ "ms";
				}
			} else {
				diffText = String.valueOf(diffText) + pd.getMillis() + "ms";
			}
		}

		return diffText;
	}

	private Period getPeriod() {

		DateTime start = new DateTime(2013, 4, 14, 20, 22, 50, 500);
		DateTime end = new DateTime();

		return new Period(start, end);

	}

	@SuppressWarnings("unchecked")
	public void onClick(final View v) {
		switch (v.getId()) {

		case (R.id.herz):
			if (timeRun)
				runToggle();
			ueber.setText("Ich liebe dich mein Schatz");
			unter.setText("Dein Sören <3");
			date.setText("14. April 2013");
			date.setOnClickListener(this);
			
			break;
		case (R.id.date):

			ueber.setText("Und wir sind schon");
			unter.setText("zusammen <3");
			runToggle();
			@SuppressWarnings("rawtypes")
			AsyncTask task = new AsyncTask() {
				@Override
				protected Object doInBackground(Object... params) {

					do {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								dateDiv();
							}
						});
						try {
							Thread.sleep(85); // pause für 0,1 Sekunde
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} while (timeRun);
					return null;
				}
			};
			task.execute(this);

			break;
		}

	}

	private void runToggle() {

		timeRun = !timeRun;

	}
}
