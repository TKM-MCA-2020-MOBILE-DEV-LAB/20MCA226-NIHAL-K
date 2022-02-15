package com.example.mad_lab_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String s,s2,s3;
    String s1;
    TextView t1,t2,t3,t4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1 = (TextView)findViewById(R.id.st);
        t2 = (TextView)findViewById(R.id.dt) ;
        t3 = (TextView)findViewById(R.id.ct1) ;
        t4 = (TextView)findViewById(R.id.mt1);

        Intent i = getIntent();
        s=i.getStringExtra("v1");
        s1=i.getStringExtra("v5");
        t1.setText(s);


            SharedPreferences sh = getSharedPreferences("file", MODE_PRIVATE);
            String value1 = sh.getString("k1", "NULL");
            String value2 = sh.getString("k2", "NULL");
            String value3 = sh.getString("k3", "NULL");

            t2.setText(value1);
            t3.setText(value2);
            t4.setText(value3);






    }
}