<h1 align="center"> Android </h1>

<div align="center">

  `Click to Open`
</div>

<details>
  <summary>
    <h3> 1. Display message from the input box in toast </h3>
  </summary>

<div align="center">
  
  **xml**
</div>

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="40dp"
        android:layout_marginEnd="32dp"
        android:onClick="handleClick"
        android:text="Button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/in" />

    <EditText
        android:id="@+id/in"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginTop="243dp"
        android:layout_marginEnd="24dp"
        android:ems="10"
        android:hint="name"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
<div align="center">
  
  **java**
</div>

```java
package com.example.sreyas;

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
    EditText Ed;
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

        // User defined functionalities.
        Ed = (EditText)findViewById(R.id.in);
    }

    public void clicked(View view) {
        Toast.makeText(this, "hello world", Toast.LENGTH_LONG).show();
    }

    public void handleClick(View view) {
        Toast.makeText(this, Ed.getText(), Toast.LENGTH_SHORT).show();
    }
}
```
</details>

<details>
  <summary>
    <h3> 2. Display message from the input box in text view </h3>
  </summary>

<div align="center">
  
  **xml**
</div>

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/l1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/et1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="101dp"
        android:layout_marginEnd="101dp"
        android:layout_marginBottom="160dp"
        android:ems="10"
        android:hint="Enter some text"
        android:inputType="text"
        app:layout_constraintBottom_toTopOf="@+id/b1"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent" />

    <Button
        android:id="@+id/b1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="158dp"
        android:layout_marginTop="60dp"
        android:layout_marginEnd="162dp"
        android:text="Button"
        android:onClick="handleClick"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/l1" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
<div align="center">
  
  **java**
</div>

```java
package com.example.displaymessage;

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
    EditText ed;
    TextView l;

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

        ed = (EditText)findViewById(R.id.et1);
        l = (TextView) findViewById(R.id.l1);
    }

    public void handleClick(View view) {
        l.setText(ed.getText());
    }
} 
```
</details>

<details>
  <summary>
    <h3> 3. Simple calculator </h3>
  </summary>
  
<div align="center">
  
  **xml**
</div>

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
<div align="center">
  
  **java**
</div>

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
</details>
