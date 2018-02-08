package com.example.dazza.functionalprototypev1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import java.net.UnknownHostException;
import com.example.dazza.functionalprototypev1.NewEntry;
import com.example.dazza.functionalprototypev1.QueryBuilder;
import com.example.dazza.functionalprototypev1.SaveAsyncTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    EditText editText_blogTitle;
    EditText editText_blogImage;
    EditText editText_blogContent;
    String createdDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText_blogTitle = (EditText) findViewById(R.id.blogTitle);
        editText_blogImage = (EditText) findViewById(R.id.blogImage);
        editText_blogContent = (EditText) findViewById(R.id.blogContent);

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dt.setTimeZone(tz);
        createdDate = dt.format(new Date());

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if(editText_blogTitle.getText().toString().trim().equals("")){
                    editText_blogTitle.setError("An Entry Title is Required!");
                    editText_blogContent.setError(null);
                }else if(editText_blogContent.getText().toString().trim().equals("")){
                    editText_blogContent.setError("Entry Content is Required!");
                    editText_blogTitle.setError(null);
                }else{
                    NewEntry entry = new NewEntry();
                    entry.blogTitle = editText_blogTitle.getText().toString();
                    entry.blogImage = editText_blogImage.getText().toString();
                    entry.blogContent = editText_blogContent.getText().toString();
                    entry.date = createdDate;

                    SaveAsyncTask task = new SaveAsyncTask();
                    task.execute(entry);
                    Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
