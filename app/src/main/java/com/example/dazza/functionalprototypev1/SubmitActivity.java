package com.example.dazza.functionalprototypev1;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubmitActivity extends AppCompatActivity {

    Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        postButton = (Button) findViewById(R.id.newPostButton);
        //Intent intent = new Intent(this, MainActivity.class);

        postButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SubmitActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
