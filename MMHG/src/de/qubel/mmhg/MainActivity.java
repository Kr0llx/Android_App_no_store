package de.qubel.mmhg;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	
	ImageView img; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView unter = (TextView) findViewById(R.id.unterschrift);
        img = (ImageView) findViewById(R.id.geschenk);
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			unter.setText("Dein Bernd, Jonas & Sören <3");
			img.setImageResource(R.drawable.geschenk1);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
