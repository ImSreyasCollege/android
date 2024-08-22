package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText a;
    EditText b;
    TextView result;

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

        a = (EditText) findViewById(R.id.et1);
        b = (EditText) findViewById(R.id.et2);
        result = (TextView) findViewById(R.id.result);
    }

    public void findSum(View view) {
        int first = Integer.parseInt(String.valueOf(a.getText()));
        int second = Integer.parseInt(String.valueOf(b.getText()));
        int sum = first + second;

        result.setText(String.valueOf(sum));
    }
    public void findDiff(View view) {
        int first = Integer.parseInt(String.valueOf(a.getText()));
        int second = Integer.parseInt(String.valueOf(b.getText()));
        int diff = first - second;

        result.setText(String.valueOf(diff));
    }
    public void findProduct(View view) {
        int first = Integer.parseInt(String.valueOf(a.getText()));
        int second = Integer.parseInt(String.valueOf(b.getText()));
        int pro = first * second;

        result.setText(String.valueOf(pro));
    }
    public void findDiv(View view) {
        float first = Float.parseFloat(String.valueOf(a.getText()));
        float second = Float.parseFloat(String.valueOf(b.getText()));
        float div = (float)first / second;

        result.setText(String.valueOf(div));
    }
}