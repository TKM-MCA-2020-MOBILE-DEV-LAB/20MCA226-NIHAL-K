//Develop application using Fragments
package com.example.co4_q4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fragement1Start(View view){
        replaceFragement(new Fragment1());
    }

    public void fragement2Start(View view){
        replaceFragement(new Fragment2());
    }

    public void replaceFragement(Fragment pragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fra,pragment);
        ft.commit();
    }

}