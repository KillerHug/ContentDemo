package com.example.theamazingdeal.contentdemo;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import static com.example.theamazingdeal.contentdemo.contentPro.PROVIDER_NAME;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText name;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.txtName);
        pass=(EditText)findViewById(R.id.txtPass);
        submit=(Button)findViewById(R.id.submit);
       /* submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==submit)
                {
                    if(TextUtils.isEmpty(name.getText().toString())||TextUtils.isEmpty(pass.getText().toString()))
                    {
                        Toast.makeText(MainActivity.this,"Field is Blanks",Toast.LENGTH_LONG).show();
                    }
                    else {
                        String n = name.getText().toString();
                        String p = pass.getText().toString();
                        contentPro dbOperation = new contentPro();
                        Users user = new Users(n, p);
                        if (dbOperation.storeUser(user) != -1) {
                            Toast.makeText(MainActivity.this, "User created Successfully", Toast.LENGTH_LONG).show();
                            name.setText("");
                            pass.setText("");
                        } else {
                            Toast.makeText(MainActivity.this, "Operation Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });*/
    }
    public void addData(View view)
    {/*
        ContentValues cv =new ContentValues();
        cv.put(ADD_NAME.NAME,name.getText().toString());
        cv.put(ADD_NAME.PASSWORD,pass.getText().toString());
        Uri uri= getContentResolver().insert(ADD_NAME.CONTENT_URI,cv);*/
    }
}
