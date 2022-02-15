package com.example.mad_lab_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText e1,e2,e3;
    String dv,cc,mob;
    String status ;
    int ch = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.ei1);
        e2 = (EditText) findViewById(R.id.ei2);
        e3 = (EditText) findViewById(R.id.ei3);
    }

    public void booking(View view)
    {
        dv = e1.getText().toString();
        cc = e2.getText().toString();
        mob = e3.getText().toString();

        if(dv.isEmpty() || cc.isEmpty() || mob.isEmpty())
        {
            status = " Booking Failed ";
        }
        else
        {
            status = "Booked Successfully";
            ch = 1;
        }


        if(ch == 1) {
            SharedPreferences sh = getSharedPreferences("file",MODE_PRIVATE);
            SharedPreferences.Editor myedit = sh.edit();
            myedit.putString("k1",dv);
            myedit.putString("k2",cc);
            myedit.putString("k3",mob);
            myedit.apply();
            Toast.makeText(getApplicationContext(),"Booking Details Stored",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            i.putExtra("v1", status);
            i.putExtra("v2", dv);
            i.putExtra("v3", cc);
            i.putExtra("v4", mob);
            i.putExtra("v5",ch);
            startActivity(i);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Failed to store",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            i.putExtra("v1", status);
            startActivity(i);
        }






    }
}