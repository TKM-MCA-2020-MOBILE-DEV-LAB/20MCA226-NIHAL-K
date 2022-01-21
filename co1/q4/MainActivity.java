package com.example.form_validation;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.text.TextUtils.isEmpty;


public class MainActivity extends AppCompatActivity {
    EditText fstnm,lstnm,emailid,phn,pswd,confpswd;
    Button register;
    boolean isFNameValid = false,isConfirmPasswordValid = false, isLNameValid = false, isEmailValid = false, isPhoneValid = false, isPasswordValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fstnm = findViewById(R.id.firstName);
        lstnm = findViewById(R.id.lastName);
        emailid = findViewById(R.id.email);
        phn = findViewById(R.id.phone);
        pswd = findViewById(R.id.passwd);
        confpswd = findViewById(R.id.confPasswd);
        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fstnm.getText().toString().trim().equalsIgnoreCase("")) {
                    fstnm.setError("You must enter first name to register!");
                    isFNameValid = false;
                }
                else if(fstnm.getText().toString().trim().matches(".*[0-9].*")){
                    fstnm.setError("Firstname does not contain a number");
                    isFNameValid = false;
                }
                else{
                    isFNameValid = true;
                }
                if (lstnm.getText().toString().trim().equalsIgnoreCase("")){
                    lstnm.setError("Last name is required!");
                    isLNameValid = false;
                }
                else if (lstnm.getText().toString().trim().matches(".*[0-9].*")){
                    lstnm.setError("Lastname does not contain a number");
                    isLNameValid = false;
                }
                else{
                    isLNameValid = true;
                }
                if (emailid.getText().toString().isEmpty()) {
                    emailid.setError("Emailid is required");
                    isEmailValid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailid.getText().toString()).matches()) {
                    emailid.setError("Enter a valid Emailid");
                    isEmailValid = false;
                } else  {
                    isEmailValid = true;
                }
                if (phn.getText().toString().length()!=10){
                    phn.setError("Enter valid Phone number");
                    isPhoneValid = false;
                }
                else{
                    isPhoneValid = true;
                }
                if(isValidPassword(pswd.getText().toString().trim()))
                {
                    isPasswordValid = true;
                }
                else{
                    pswd.setError("Enter valid Password including Caps,Number and Special Character");
                    isPasswordValid = false;
                }

                if(confpswd.getText().toString().trim().equalsIgnoreCase("")) {
                    confpswd.setError("Enter your confirmation password");
                    isConfirmPasswordValid = false;
                }
                else if (confpswd.equals(pswd))
                {
                    confpswd.setError("Password do not match");
                    isConfirmPasswordValid = false;
                }
                else {
                    isConfirmPasswordValid = true;
                }

                if (isFNameValid && isLNameValid && isEmailValid && isPhoneValid && isPasswordValid && isConfirmPasswordValid) {
                    Toast.makeText(getApplicationContext(), "Registration Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Registration Not Successfully!!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public boolean isValidPassword(String pswd){
        Pattern pattern;
        Matcher matcher;

        String PSWD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";

        pattern = Pattern.compile(PSWD_PATTERN);
        matcher = pattern.matcher(pswd);

        return matcher.matches();
    }

}