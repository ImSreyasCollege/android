package com.example.registration;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfilePage extends AppCompatActivity {
    public TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        show = (TextView) findViewById(R.id.show);
//        show.setText("Hello");

        SharedPreferences share = getSharedPreferences("Registration", MODE_PRIVATE);
        String firstname = share.getString("firstname", "");
        String lastname = share.getString("lastname", "");
        String gender = share.getString("gender", "");
        String email = share.getString("email", "");
        String phone = share.getString("phone", "");
        String password = share.getString("password", "");
        String dob = share.getString("dob", "");

        String content = "Name : " + firstname + " " + lastname + "\nGender : " + gender + "\nEmail : " + email + "\nPhone : " + phone + "\nDate of birth : " + dob;
        show.setText(content);
    }
}