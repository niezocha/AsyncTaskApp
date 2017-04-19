package com.example.zofia.asynctaskapp;


public interface ProgressInterface extends ProgressUpdate{

    void setTextToTextView(String tetx);
    void setProgress(int progress);
}
