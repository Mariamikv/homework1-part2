package com.example.homework1_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonShowToast = (Button)findViewById(R.id.buttonShowToast);
    Button buttonShowTextView = (Button)findViewById(R.id.buttonShowTextView);
    Button buttonNavigate = (Button)findViewById(R.id.buttonOpenNextScreen);

    EditText fullName = (EditText)findViewById(R.id.nameEditText);
    EditText location = (EditText)findViewById(R.id.locationEditText);
    EditText phoneNumber = (EditText)findViewById(R.id.phoneNumberEdittext);

    TextView fullNameTextView = (TextView)findViewById(R.id.fullName);
    TextView locationTextView = (TextView)findViewById(R.id.location);
    TextView phoneNumberTextView = (TextView)findViewById(R.id.phoneNumber);

    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (buttonShowToast != null && buttonShowTextView != null && buttonNavigate != null) {
            buttonShowToast.setOnClickListener((View.OnClickListener)(it ->
                    Toast.makeText((Context)MainActivity.this, fullName.getText() + ", " + location.getText() + ", " + phoneNumber.getText(), Toast.LENGTH_LONG).show()
            ));

            buttonShowTextView.setOnClickListener(it -> {
                fullNameTextView.setText("full name:" + fullName.getText());
                phoneNumberTextView.setText("phone number:" + phoneNumber.getText());
                locationTextView.setText("location" + location.getText());
            });

            buttonNavigate.setOnClickListener( it -> {
                intent.putExtra("fullName", fullName.getText());
                intent.putExtra("location", location.getText());
                intent.putExtra("phoneNumber", phoneNumber.getText());
                startActivity(intent);
            });
        }
    }
}