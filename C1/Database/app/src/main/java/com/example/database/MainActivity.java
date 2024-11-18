package com.example.database;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText firstname, lastname, mark, delete;
    MyDatabase database = new MyDatabase(this);
    TextView display;

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
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        mark = (EditText) findViewById(R.id.mark);
        display = (TextView) findViewById(R.id.display);
        delete = (EditText) findViewById(R.id.delete);
        displayData();
    }

    public void handleInsert(View view) {
        String firstnameStr, lastnameStr;
        int markData;

        firstnameStr = firstname.getText().toString();
        lastnameStr = lastname.getText().toString();
        markData = Integer.parseInt(mark.getText().toString());

        Boolean result = database.insertData(firstnameStr, lastnameStr, markData);
        if (result) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            displayData();
        } else {
            Toast.makeText(this, "Data insertion failed", Toast.LENGTH_SHORT).show();
        }
    }
     public void displayData() {
        Cursor res = database.getAllData();
        StringBuffer stringBuff = new StringBuffer();
        if (res != null && res.getCount() > 0) {
            while(res.moveToNext()) {
                stringBuff.append("ID : " + res.getString(0) + "\n");
                stringBuff.append("NAME : " + res.getString(1) + " " + res.getString(2) + "\n");
                stringBuff.append("MARK : " + res.getString(3) + "\n\n");
            }
            display.setText(stringBuff.toString());
        }
     }

     public void handleDelete(View view) {
        String deleteId = (delete.getText().toString();
        database.deleteData(deleteId);
     }
}