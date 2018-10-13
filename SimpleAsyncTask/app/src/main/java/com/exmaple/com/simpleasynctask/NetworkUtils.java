package com.exmaple.com.simpleasynctask;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.BreakIterator;

public class NetworkUtils {
    public NetworkUtils() {
        super();
        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    static String getBookInfo(String queryString) {
    }

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String bookJSONString = null;
    return bookJSONString;

    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?"; // Base URI for the
    Books API
    private static final String QUERY_PARAM = "q"; // Parameter for the search string
    private static final String MAX_RESULTS = "maxResults"; // Parameter that limits search results
    private static final String PRINT_TYPE = "printType"; // Parameter to filter by print type

    try

    {
    ...
    } catch(
    Exception ex)

    {
    ...
    } finally

    {
        return bookJSONString;
    }

    private Object queryString;
    //Build up your query URI, limiting results to 10 items and printed books
    Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
            .appendQueryParameter(QUERY_PARAM, queryString)
            .appendQueryParameter(MAX_RESULTS, "10")
            .appendQueryParameter(PRINT_TYPE, "books")
            .build();
    URL requestURL = new URL(builtURI.toString());

    urlConnection =(HttpURLConnection)requestURL.openConnection();
    urlConnection.setRequestMethod("GET");
    urlConnection.connect();

    InputStream inputStream = urlConnection.getInputStream();
    StringBuffer buffer = new StringBuffer();
if(inputStream ==null)

    {
// Nothing to do.
        return null;
    }

    reader =new

    BufferedReader(new InputStreamReader(inputStream) {
        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
    });
    String line;
while((line =reader.readLine())!=null)

    {
/* Since it's JSON, adding a newline isn't necessary (it won't affect
parsing) but it does make debugging a *lot* easier if you print out the
completed buffer for debugging. */
        buffer.append(line + "\n");
    }
if(buffer.length()==0)

    {
// Stream was empty. No point in parsing.
        return null;
    }

    bookJSONString =buffer.toString();
catch(
    IOException e)

    {
        e.printStackTrace();
        return null;
    }
    finally {
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    Log.d(LOG_TAG, bookJSONString);
return NetworkUtils.getBookInfo(params[0]);
new

    FetchBook(mTitleText, mAuthorText) {
        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
    }.

    execute(mQueryString) {

        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
    }
    JSONObject jsonObject = new JSONObject(s);
    JSONArray itemsArray = jsonObject.getJSONArray("items");
    //Iterate through the results
for(int i = 0; i<itemsArray.length(); i++){
        JSONObject book = itemsArray.getJSONObject(i); //Get the current item
        String title=null;
        String authors=null;
        JSONObject volumeInfo = book.getJSONObject("volumeInfo");
        try {
            title = volumeInfo.getString("title");
            authors = volumeInfo.getString("authors");
        } catch (Exception e){
            e.printStackTrace();
        }
//If both a title and author exist, update the TextViews and return
        if (title != null && authors != null){
            mTitleText.setText(title);
            mAuthorText.setText(authors);
            return;
        }
    }
    mTitleText.setText("No Results Found");
mAuthorText.setText("");
 catch (Exception e){
        BreakIterator mTitleText;
        mTitleText.setText("No Results Found");
        BreakIterator mAuthorText;
        mAuthorText.setText("");
        e.printStackTrace();
        }

    private nputMethodManager inputManager;
inputManager.hideSoftInputFromWindow(

    getCurrentFocus() {
        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private Object getSystemService(String inputMethodService) {
    }.

    getWindowToken() {
        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
    }
    InputMethodManager.HIDE_NOT_ALWAYS);
    public void searchBooks(View, view) {
        Fragment mBookInput;
        String queryString = mBookInput.getText().toString();
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() && queryString.length()!=0) {
            new MainActivity.FetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText(R.string.loading);
        }
        else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mTitleText.setText("Please enter a search term");
            } else {
                mAuthorText.setText("");
                mTitleText.setText("Please check your network connection and try again.");
            }
        }
    }

    public View getCurrentFocus() {
        return currentFocus;
    }
}