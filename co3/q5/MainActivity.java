package com.example.arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list=findViewById(R.id.listview);
        String[] item=new String[]{"Nihal K","MCA","TKM","KOLLAM"};
        ArrayAdapter <String> adapter=new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,item);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String item_name=item[position];
                Toast.makeText(MainActivity.this,item_name,Toast.LENGTH_LONG).show();
            }
        });
    }
}