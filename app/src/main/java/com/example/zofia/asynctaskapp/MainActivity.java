package com.example.zofia.asynctaskapp;

import android.os.AsyncTask;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements ProgressInterface{

    private TextView textView;
//    private ExampleAsyncTask task;
    private ProgressBar progressBar;
    private FactorialAsyncTask factorialAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

//        task = new ExampleAsyncTask(this);
//        task.execute();

        factorialAsyncTask = new FactorialAsyncTask(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Integer[] arrayOfInts = new Integer[1000];
        Integer[] array = {12, 1, 53, 2, 8, 26, 17, 11, 489, 2, 11, 23, 353, 223, 3455, 11};
        for(int i =0; i<1000; i++){
            arrayOfInts[i] = array[i%16];
        }
        factorialAsyncTask.execute(arrayOfInts);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        task.cancel(true);
    }

    @Override
    public void setTextToTextView(String text){
        textView.setText(text);
    }

    @Override
    public void updateProgress(int progress) {
        progressBar.setProgress(progress);
    }
}
