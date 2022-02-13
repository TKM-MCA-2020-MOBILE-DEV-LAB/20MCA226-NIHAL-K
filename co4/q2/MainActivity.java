package com.example.co4_q2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements OnItemSelectedListener {

    String[] names = {"_","Alpha","Beta","Gamma","Zeta"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner sp =  (Spinner) findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);

        ArrayAdapter ar = new ArrayAdapter(this,android.R.layout.simple_spinner_item,names);
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ar);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, names[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}