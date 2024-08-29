<h1 align="center"> Android </h1>


<h2 align="center">
  
  [`1`](#1) [`2`](#2) [`3`](#3) [`4`](#4) [`5`](#5) [`6`](#6) 
</h2>

<h3 id="1"> 1. Display message from the input box in toast </h3>

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

<h3 id="2"> 2. Display message from the input box in text view </h3>

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

<h3 id="3"> 3. Simple calculator </h3>

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

<h3 id="4"> 4. Background color change on button click. </h3>

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
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="140dp"
        android:layout_marginTop="343dp"
        android:layout_marginEnd="140dp"
        android:layout_marginBottom="340dp"
        android:text="change color"
        android:onClick="changeColor"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
<div align="center">
  
  **java**
</div>

```java
package com.example.colorchange;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout main;

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

        main = (ConstraintLayout) findViewById(R.id.main);
    }

    public void changeColor(View view) {
        Random random = new Random();
        int red =  random.nextInt(255);
        int green =  random.nextInt(255);
        int blue =  random.nextInt(255);
        main.setBackgroundColor(Color.rgb(red, green, blue));
    }
}
```

<h3 id="5"> 5. Login to a page and display a welcome message and logout from that page. </h3>

<div align="center">
  
  **xml**
</div>

**login page**

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
        android:layout_marginStart="104dp"
        android:layout_marginTop="235dp"
        android:layout_marginEnd="98dp"
        android:layout_marginBottom="20dp"
        android:ems="10"
        android:hint="username"
        android:inputType="text"
        app:layout_constraintBottom_toTopOf="@+id/et2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/et2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="102dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="100dp"
        android:layout_marginBottom="48dp"
        android:ems="10"
        android:hint="password"
        android:inputType="text"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et1" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="163dp"
        android:layout_marginTop="25dp"
        android:layout_marginEnd="160dp"
        android:layout_marginBottom="239dp"
        android:onClick="handleLogin"
        android:text="Login"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/et2" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

**welcome page**

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondActivity">

    <TextView
        android:id="@+id/label"
        android:layout_width="200dp"
        android:layout_height="34dp"
        android:layout_marginTop="20dp"
        android:layout_marginBottom="100dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.306" />

    <Button
        android:id="@+id/logout"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="161dp"
        android:layout_marginTop="100dp"
        android:layout_marginEnd="161dp"
        android:layout_marginBottom="352dp"
        android:text="logout"
        android:onClick="handleLogout"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/label" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

<div align="center">
  
  **java**
</div>

**login page**

```java
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
```

**welcome page**

```java
package com.example.loginlogout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        t1 = (TextView) findViewById(R.id.label);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        t1.setText("Hello " + username + ", Welcome to the page");
    }
    public void handleLogout(View view) {
        finish();
    }
}
```
