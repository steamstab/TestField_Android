package com.steamstab.testfield;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by Steam on 16/12/15.
 */

public class TestActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("activity");
    }
}
