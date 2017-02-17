package com.example.mccracken.lab3practice_mccracken;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String tag = "AJM";

    EditText input_et;
    TextView output_tv;
    Button calculate_b;

    private static String answer;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        // The Bundle provides a way of storing a NVP ("Name-Value Pair") map.
        // It will get passed in to onRestoreInstanceState() OR onCreate()
        Log.i(tag, "onSaveInstanceState: answer = [" + answer + "]");
        Toast.makeText(this, "onSaveInstanceState = [" + answer + "]", Toast.LENGTH_SHORT).show();

        savedInstanceState.putString("answer", answer);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState)
    {
        answer = savedInstanceState.getString("answer");
        Toast.makeText(this, "onSaveInstanceState = [" + answer + "]", Toast.LENGTH_SHORT).show();
        Log.i(tag, "onRestoreInstanceState: answer = [" + answer + "]");

        // this works, but doesn’t restore the textView.  How to fix???
        output_tv.setText(answer);
    }

    // NOTE:  import android.view.View.OnClickListener!!!
    // NOTE:  OnClickListener is an interface
    private View.OnClickListener onClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            Log.i(tag, "onClick:");

            answer = answer + input_et.getText().toString();

            output_tv.setText(answer);

            input_et.setText("");
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        //saveDataFromCurrentState();
        Log.i(tag, "onPause:");
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "onRestart:");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "onResume:");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //updateFromSavedState();
        Log.i(tag, "onStart:");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "onDestroy:");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "onStop:");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(tag, "onCreate:");
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

        input_et    = (EditText) findViewById(R.id.input_et);
        output_tv   = (TextView) findViewById(R.id.output_tv);
        calculate_b = (Button)   findViewById(R.id.calculate_b);

        answer = "";

        calculate_b.setOnClickListener(onClickListener);
    }
}
