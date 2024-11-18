package com.example.registration;

import android.content.Intent;
import android.content.SharedPreferences;
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

    }

    public void handleReg(View view) {
        String firstname_value = firstname.getText().toString();
        String lastname_value = lastname.getText().toString();
        String radio_button_text = "Unknown";

        int id = gender_group.getCheckedRadioButtonId();
        selected_radio_button = (RadioButton) findViewById(id);

        if (selected_radio_button != null) {
            radio_button_text = selected_radio_button.getText().toString();
        }

        String email_value = email.getText().toString();
        String phone_value = phone.getText().toString();
        String password_value = password.getText().toString();
        String dob_value = dob.getText().toString();

        boolean isValid = validateInput(firstname_value, lastname_value, email_value, phone_value, password_value, dob_value);
        if (!isValid) {
            return;
        }

        SharedPreferences share = getSharedPreferences("Registration", MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putString("firstname", firstname_value);
        editor.putString("lastname", lastname_value);
        editor.putString("gender", radio_button_text);
        editor.putString("email", email_value);
        editor.putString("phone", phone_value);
        editor.putString("password", password_value);
        editor.putString("dob", dob_value);
        editor.apply();

        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
    }
    private boolean validateInput(String firstname, String lastname, String email, String phone, String password, String dob) {
        if(firstname.length() < 2 || lastname.length() < 2) {
            Toast.makeText(this, "First and last name must be at least 2 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (phone.length() != 10 || !phone.matches("[0-9]+")) {
            Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$")) {
            Toast.makeText(this, "Password must be at least 6 characters long and contain at least one capital letter, one digit, and one special character", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
            Toast.makeText(this, "Please enter date of birth in DD/MM/YYYY format", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}