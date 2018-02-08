package com.example.dazza.functionalprototypev1;

import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.dazza.functionalprototypev1.NewEntry;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class SaveAsyncTask extends AsyncTask<NewEntry, Void, Boolean> {

    @Override
    protected Boolean doInBackground(NewEntry... arg0) {
        try
        {
            NewEntry entry = arg0[0];

            QueryBuilder qb = new QueryBuilder();

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost request = new HttpPost(qb.buildEntrySaveUrl());

            StringEntity params = new StringEntity(qb.createEntry(entry));
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            if(response.getStatusLine().getStatusCode()<205)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            //e.getCause();
            String val = e.getMessage();
            String val2 = val;
            return false;
        }
    }

}
