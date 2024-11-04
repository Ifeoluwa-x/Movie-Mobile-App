//package com.example.moviemobileapp;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//
//public class SignupActivity extends AppCompatActivity {
//
//    private EditText txtSignupName, txtSignupEmail, txtSignupPassword;
//    private Button btnSignUp;
//    private UserDBHandler dbHandler;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.signup); // Make sure this matches your layout file name
//
//        txtSignupName = findViewById(R.id.txtSignupName);
//        txtSignupEmail = findViewById(R.id.txtSignupEmail);
//        txtSignupPassword = findViewById(R.id.txtSignupPassword);
//        btnSignUp = findViewById(R.id.btnSignUp);
//        dbHandler = new UserDBHandler(this);
//
//        btnSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signupUser();
//            }
//        });
//
//        TextView txtSignupView = findViewById(R.id.txtSignupView);
//        txtSignupView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Redirect to SignInActivity (if you have one)
//                startActivity(new Intent(SignupActivity.this, SignInActivity.class));
//            }
//        });
//    }
//
//    private void signupUser() {
//        String username = txtSignupName.getText().toString();
//        String email = txtSignupEmail.getText().toString(); // Assuming email is not being stored
//        String password = txtSignupPassword.getText().toString();
//
//        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
//            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // Check if user already exists
//        if (dbHandler.findUserByName(username)) {
//            Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
//        } else {
//            // Add new user to the database
//            dbHandler.addNewUser(username, password);
//            Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show();
//
//            // Optionally redirect to SignInActivity
//            startActivity(new Intent(SignupActivity.this, SignInActivity.class));
//            finish(); // Close SignupActivity
//        }
//    }
//}}