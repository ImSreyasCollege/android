package com.example.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public EditText firstname;
    public EditText lastname;
    public RadioGroup gender_group;
    public EditText email;
    public EditText phone;
    public EditText password;
    public EditText dob;
    public RadioButton selected_radio_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstname = (EditText) findViewById(R.id.first_name);
        lastname = (EditText) findViewById(R.id.last_name);
        gender_group = (RadioGroup) findViewById(R.id.gender_group);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        dob = (EditText) findViewById(R.id.dob);

        int id = gender_group.getCheckedRadioButtonId();
        selected_radio_button = (RadioButton) findViewById(id);
    }

    public void handleReg(View view) {
        if (selected_radio_button != null) {
            String radio_button_text = selected_radio_button.getText().toString();
            Toast.makeText(this, radio_button_text, Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "no its not working", Toast.LENGTH_SHORT).show();
    }
}