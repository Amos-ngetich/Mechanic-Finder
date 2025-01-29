package com.example.mechnicfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //EditText userid = (EditText) findViewById(R.id.userid);

        MaterialButton regbtn = (MaterialButton) findViewById(R.id.signupbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
               // String Userid = userid.getText().toString();
               // Toast.makeText(MainActivity.this,"User Id is "+userid,Toast.LENGTH_SHORT).show();
               // Button loginbtn = findViewById(R.id.loginbtn);
               // loginbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                    //}
               // });

            }
        });

    }
}