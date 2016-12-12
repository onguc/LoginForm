package com.login.controller.loginform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail=(EditText)findViewById(R.id.etUserName);
        etPassword=(EditText)findViewById(R.id.etPassword);
    }


    public void checkLogin(View arg0){
        final String email=etEmail.getText().toString();
        if(!isValidEmail(email)){
            etEmail.setError("Invalid Email");
        }

        final String password=etPassword.getText().toString();
        if(!isValidPassword(password)){
            etPassword.setError("Password cannot be empty");
        }

        if(isValidEmail(email) && isValidPassword(password)){
            System.out.println("Başarılı");
        }

    }


    private boolean isValidEmail(String email){
        String EMAIL_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern=Pattern.compile(EMAIL_PATTERN);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String password){
        if(password!=null && password.length()>=4){
            return true;
        }
        else{
            return false;
        }
    }
}
