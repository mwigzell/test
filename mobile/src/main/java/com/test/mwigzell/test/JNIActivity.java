package com.test.mwigzell.test;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class JNIActivity extends Activity {

    static {
        System.loadLibrary("native-lib");
    }

    // A native method that returns a Java String to be displayed on the
    // TextView
    public native String getMessage();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.jni_activity);
        TextView label = findViewById(R.id.hello_textview);
        label.setText(getMessage());
    }
}
