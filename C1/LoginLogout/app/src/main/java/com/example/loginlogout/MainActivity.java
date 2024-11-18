package com.example.loginlogout;

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
    EditText et1;
    EditText et2;

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

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
    }
    public void handleLogin(View view) {
        if (String.valueOf(et1.getText()).equals("sreyas")) {
            if (String.valueOf(et2.getText()).equals("sreyas123")) {
                Toast.makeText(this, "Login successful",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("username", "sreyas");
                startActivity(intent);
            } else {
                Toast.makeText(this, "invalid password", Toast.LENGTH_SHORT).show();
            }
        }
        else if (String.valueOf(et1.getText()).equals("admin")) {
            if (String.valueOf(et2.getText()).equals("admin123")) {
                Toast.makeText(this, "Login successful",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("username", "admin");
                startActivity(intent);
            } else {
                Toast.makeText(this, "invalid password", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "invalid username", Toast.LENGTH_SHORT).show();
        }
    }
}