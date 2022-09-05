package com.example.senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    private EditText edtEmail;
    private Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("PhamTrongTu_20505311200325_Update");

        edtEmail = findViewById(R.id.edt_email);
        btnUpdate= findViewById(R.id.btn_update);
        edtEmail.setText(getIntent().getStringExtra("key_email"));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backActivity();
            }




        });
    }
    private void backActivity() {
        String setEmailUpdate = edtEmail.getText().toString().trim();
        Intent rtIntent = new Intent();
        rtIntent.putExtra("key_email",setEmailUpdate);
        setResult(MainActivity.RESULT_OK,rtIntent);
        finish();
    }
}
