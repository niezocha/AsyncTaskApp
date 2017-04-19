package com.example.zofia.asynctaskapp;

import android.os.AsyncTask;
import android.util.Log;

import java.lang.ref.WeakReference;


public class ExampleAsyncTask extends AsyncTask<Void, Integer, Void>{

    public static final String ASYNC_TASK = "async_task";
    private WeakReference<ProgressInterface> mainActivityWeakReference;

    public ExampleAsyncTask(ProgressInterface mainActivity){
        this.mainActivityWeakReference = new WeakReference<ProgressInterface>(mainActivity);
    }

    @Override
    protected Void doInBackground(Void... params) {

        for(int i =0; i<100; i++){

            String textToShow = String.format("to jest krok nr %d, na wątku %s",i, Thread.currentThread().getName());

            publishProgress(i);
            Log.d(ASYNC_TASK, textToShow);
            if(isCancelled()){
                return null;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        String textToShow = String.format("to jest krok nr %d, na wątku %s",values[0], Thread.currentThread().getName());
        ProgressInterface mainActivity = mainActivityWeakReference.get();
        if(mainActivity !=null){
            mainActivity.setTextToTextView(textToShow);
        }
    }
}
