package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //References to button and other controls

        Button addbutton,viewbutton;
        EditText name,age;
        Switch switch1;
        ListView list;

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        switch1=findViewById(R.id.switch1);
        addbutton=findViewById(R.id.addbutton);
        viewbutton=findViewById(R.id.viewbutton);
        list=findViewById(R.id.list);

        addbutton.setOnClickListener(new View.OnClickListener() {
            Customer customer;
            @Override
            public void onClick(View view) {
                try {
                    customer = new Customer(1, name.getText().toString(), Integer.parseInt(age.getText().toString()), switch1.isChecked());
                    Toast.makeText(MainActivity.this, customer.toString(), Toast.LENGTH_LONG).show();

                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

                }
                Database db=new Database(MainActivity.this);
                Boolean success=db.enter(customer);
                Toast.makeText(MainActivity.this,"success " + success,Toast.LENGTH_LONG).show();

            }
        });

        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"View",Toast.LENGTH_LONG).show();
            }
        });

    }


}