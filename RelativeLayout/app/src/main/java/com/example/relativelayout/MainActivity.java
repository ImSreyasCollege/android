package com.example.relativelayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText username, password;

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

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void handleLogin(View view) {
        String usernameString = username.getText().toString();
        String passwordString = password.getText().toString();

        if (usernameString.equals("admin")) {
            if (passwordString.equals("admin@123")) {
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "invalid password", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "invalid username", Toast.LENGTH_SHORT).show();
        }
    }
}