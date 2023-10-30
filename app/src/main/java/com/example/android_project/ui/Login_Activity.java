package com.example.android_project.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_project.MainActivity;
import com.example.android_project.R;

public class Login_Activity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewForgotPassword;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedpref = getSharedPreferences("SP", Login_Activity.MODE_PRIVATE);
        editor = sharedpref.edit();
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        String pass = sharedpref.getString("defaultpassword", "");
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        textViewForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the "Forgot Password" logic here
                Toast.makeText(Login_Activity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
     public void openMainActivity(){
         String Text = editTextEmail.getText().toString();
         String pass = editTextPassword.getText().toString();
         if( !Patterns.EMAIL_ADDRESS.matcher(Text).matches())
         {
             Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show();
         }
         else if (pass.length() < 8) {
             Toast.makeText(this, "Password length should be minimum 8", Toast.LENGTH_SHORT).show();
         }
         else if(!pass.matches(".*\\d.*") && !pass.matches(".*[!@#$%^&*()\\-+].*")){
             Toast.makeText(this, "Password should have atleast one number and a special character", Toast.LENGTH_SHORT).show();
         }
         else if(pass.equals(pass.toLowerCase()) && pass.equals(pass.toUpperCase())){
             Toast.makeText(this, "Password should have one upper and lower case letter", Toast.LENGTH_SHORT).show();
         }
         else {
             Intent intent = new Intent(this, MainActivity.class);
             startActivity(intent);
         }

     }

}
