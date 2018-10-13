package com.exmaple.com.simpleasynctask;

import android.app.Fragment;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {}

    public SimpleAsyncTask(TextView tv) {
        TextView mTextView = tv;
    }
    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }
    @Override
    protected String doInBackground(Void... voids) {
// Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);
// Make the task take long enough that we have
// time to rotate the phone while it is running
        int s = n * 200;
// Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
// Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }
    protected void onPostExecute(String result) {
        TextView mTextView;
        mTextView.setText(result);
    }
    private TextView mTextView;
    public void startTask (View view) {
// Put a message in the text view
        mTextView.setText("Napping... ");
// Start the AsyncTask.
// The AsyncTask has a callback that will update the text view.
        new SimpleAsyncTask(mTextView).execute();
    }
    outState.putString(TEXT_STATE, mTextView.getText().toString());
    // Restore TextView if there is a savedInstanceState
if(savedInstanceState!=null){
        mTextView.setText(savedInstanceState.getString(TEXT_STATE));
    }

    private Fragment mBookInput;
    String queryString = mBookInput.getText().toString();
    public class FetchBook extends AsyncTask<String,Void,String>{
        private TextView mTitleText;
        private TextView mAuthorText;
        public FetchBook(TextView mTitleText, TextView mAuthorText) {
            this.mTitleText = mTitleText;
            this.mAuthorText = mAuthorText;
        }
        @Override
        protected String doInBackground(String... params) {
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}