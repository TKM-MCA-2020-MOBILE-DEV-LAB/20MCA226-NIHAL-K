package com.example.workshow1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView l1;
    String [] nam  = {"Shajahan","Tovino","Ragav","Bineesh"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            ArrayAdapter <String> adap = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nam);
            l1.setAdapter(adap);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}