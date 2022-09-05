package com.example.senddata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 10;
    private EditText edtEmail;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("PhamTrongTu_20505311200325");
        edtEmail = findViewById(R.id.edt_email);
        btnSend= findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }


        });
    }
    private void nextActivity() {
            String strEmail =edtEmail.getText().toString().trim();
            AppUtil.mEmail=strEmail;
            Intent intent = new Intent(MainActivity.this,MainActivity2.class );
        intent.putExtra("key_email",strEmail);
           startActivityForResult(intent,MY_REQUEST_CODE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (MY_REQUEST_CODE == requestCode && resultCode == MainActivity2.RESULT_OK){
            edtEmail.setText(data.getStringExtra("key_email"));
        }
    }
}