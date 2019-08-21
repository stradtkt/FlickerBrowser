package com.stradtman.flickerbrowser;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

enum DownloadStatus {IDLE, PROCESSING, NOT_INITIALIZED, FAILED_OR_EMPTY, OK}

class GetRawData extends AsyncTask<String, Void, String> {
    private static final String TAG = "GetRawData";

    private DownloadStatus mDownloadStatus;

    public GetRawData() {
        mDownloadStatus = DownloadStatus.IDLE;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        if(strings == null) {
            mDownloadStatus = DownloadStatus.NOT_INITIALIZED;
            return null;
        }
        try {
            mDownloadStatus = DownloadStatus.PROCESSING;
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
        } catch(MalformedURLException e) {
            Log.e(TAG, "doInBackground: Invalid URL. " + e.getMessage());
        } catch(IOException e) {
            Log.e(TAG, "doInBackground: IO Exception reading data. " + e.getMessage());
        } catch(SecurityException e) {
            Log.e(TAG, "doInBackground: Security Exception. Needs permission? " + e.getMessage());
        }
        return null;
    }
}

