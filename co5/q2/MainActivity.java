package com.example.co5_q1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, address, number;
    Button add, update, delete, viewuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void insertUser(View view){
        name = findViewById(R.id.name);
        address = findViewById(R.id.add);
        number = findViewById(R.id.num);
        DBHelper DB = new DBHelper(this);
        String nam = name.getText().toString();
        String add = address.getText().toString();
        String num = number.getText().toString();
        Boolean checkinsert = DB.insertuserDB(nam,add,num);
        if(checkinsert){
            Toast.makeText(this, "User added Succesfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "User not added", Toast.LENGTH_SHORT).show();
        }
        name.setText("");
        address.setText("");
        number.setText("");
    }
    public void updateUser(View view){
        name = findViewById(R.id.name);
        address = findViewById(R.id.add);
        number = findViewById(R.id.num);
        DBHelper DB = new DBHelper(this);
        String nam = name.getText().toString();
        String add = address.getText().toString();
        String num = number.getText().toString();
        Boolean checkupdate = DB.UpdateuserDB(nam,add,num);
        if(checkupdate){
            Toast.makeText(this, "User data updated Succesfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "User date not updated", Toast.LENGTH_SHORT).show();
        }
        name.setText("");
        address.setText("");
        number.setText("");
    }
    public void deleteUser(View view){
        name = findViewById(R.id.name);
        DBHelper DB = new DBHelper(this);
        String nam = name.getText().toString();
        Boolean checkdelete= DB.DeleteuserDB(nam);
        if(checkdelete){
            Toast.makeText(this, "User deleted Succesfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "User not deleted", Toast.LENGTH_SHORT).show();
        }
        name.setText("");
        address.setText("");
        number.setText("");
    }
    public void  viewUser(View view){
        DBHelper DB = new DBHelper(this);
        Cursor res = DB.getuserDB();
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        if(res.getCount()==0){
            alert.setCancelable(true);
            alert.setTitle("Users Data");
            alert.setMessage("No user found");
            alert.show();
        }
        else {
            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("Name:" + res.getString(0) + "\n");
                buffer.append("Address:" + res.getString(1) + "\n");
                buffer.append("Mobile Number:" + res.getString(2) + "\n\n");
            }
            alert.setCancelable(true);
            alert.setTitle("Users Data");
            alert.setMessage(buffer.toString());
            alert.show();
            name.setText("");
            address.setText("");
            number.setText("");
        }
    }
}