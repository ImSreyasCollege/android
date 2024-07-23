<h1 align="center"> Android </h1>

<h2> 3. Calculator </h2>
<h3 align="center">
  xml
</h3>

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/et1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="100dp"
        android:layout_marginTop="100dp"
        android:layout_marginEnd="100dp"
        android:ems="10"
        android:hint="Enter first number"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/et2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="100dp"
        android:layout_marginTop="44dp"
        android:layout_marginEnd="100dp"
        android:ems="10"
        android:hint="Enter second number"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et1" />

    <Button
        android:id="@+id/plus"
        android:layout_width="60dp"
        android:layout_height="50dp"
        android:layout_marginStart="30dp"
        android:layout_marginTop="50dp"
        android:onClick="findSum"
        android:text="+"
        app:layout_constraintEnd_toStartOf="@+id/minus"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et2" />

    <Button
        android:id="@+id/minus"
        android:layout_width="60dp"
        android:layout_height="50dp"
        android:layout_marginStart="10dp"
        android:layout_marginTop="50dp"
        android:layout_marginEnd="10dp"
        android:onClick="findDiff"
        android:text="-"
        app:layout_constraintEnd_toStartOf="@+id/star"
        app:layout_constraintStart_toEndOf="@+id/plus"
        app:layout_constraintTop_toBottomOf="@+id/et2" />

    <Button
        android:id="@+id/star"
        android:layout_width="60dp"
        android:layout_height="50dp"
        android:layout_marginStart="10dp"
        android:layout_marginTop="50dp"
        android:layout_marginEnd="10dp"
        android:onClick="findProduct"
        android:text="x"
        app:layout_constraintEnd_toStartOf="@+id/div"
        app:layout_constraintStart_toEndOf="@+id/minus"
        app:layout_constraintTop_toBottomOf="@+id/et2" />

    <Button
        android:id="@+id/div"
        android:layout_width="60dp"
        android:layout_height="50dp"
        android:layout_marginStart="10dp"
        android:layout_marginTop="50dp"
        android:layout_marginEnd="30dp"
        android:onClick="findDiv"
        android:text="/"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/star"
        app:layout_constraintTop_toBottomOf="@+id/et2" />

    <TextView
        android:id="@+id/result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="179dp"
        android:layout_marginTop="145dp"
        android:layout_marginEnd="175dp"
        android:textSize="50dp"
        android:textFontWeight="900"
        android:text="\?"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et2" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
<h3 align="center">
  java
</h3>


```java
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
```
