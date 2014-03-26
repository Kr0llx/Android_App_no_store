package de.qubel.jhg;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {


    ImageView img;
    boolean second = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView unter1 = (TextView) findViewById(R.id.unter1);
        final TextView unter2 = (TextView) findViewById(R.id.unter2);
        img = (ImageView) findViewById(R.id.geschenk);
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (second) {
                    img.setImageResource(R.drawable.first);
                    unter1.setText("");
                    unter2.setText("");
                    second=false;
                } else {
                    img.setImageResource(R.drawable.second);
                    unter1.setText(R.string.from1);
                    unter2.setText(R.string.from2);
                    second=true;
                }


            }
        });
    }
}