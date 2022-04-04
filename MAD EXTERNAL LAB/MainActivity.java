package com.example.extern_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView l1;
    String[] listItems = {"Home","About Us","Contact","Address"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = (ListView) findViewById(R.id.List1);
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listItems);
        l1.setAdapter(myAdapter);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public  void  onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item_name=listItems[position];
                Toast.makeText(MainActivity.this,item_name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}