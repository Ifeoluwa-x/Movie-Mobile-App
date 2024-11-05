package com.example.moviemobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     EditText txtSignupName, txtSignupEmail, txtSignupPassword;
     Button btnSignUp;
     UserDBHandler dbHandler;

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
        txtSignupName = findViewById(R.id.txtSignupName);
        txtSignupPassword = findViewById(R.id.txtSignupPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        dbHandler = new UserDBHandler(this);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to sign up the user
                signupUser();
            }
        });


        TextView txtSignupView = findViewById(R.id.txtSignupView);
        txtSignupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to SignInActivity (if you have one)
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
            }
        });
    }

    private void signupUser() {
        String username = txtSignupName.getText().toString();
        String password = txtSignupPassword.getText().toString();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Check if user already exists
        if (dbHandler.findUserByName(username)) {
            Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
        } else {
            // Add new user to the database
            dbHandler.addNewUser(username, password);
            Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show();

            // Optionally redirect to SignInActivity
            startActivity(new Intent(MainActivity.this, SignInActivity.class));
            Toast.makeText(this, "Hi. tHIS ", Toast.LENGTH_SHORT).show();
            finish(); // Close SignupActivity
        }
    }
}