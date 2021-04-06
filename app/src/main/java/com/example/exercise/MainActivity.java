package com.example.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button bLogin;
    EditText eEmail;
    EditText ePassword;
    TextInputLayout emailError;
    boolean checkmail;
    boolean checkpass;
    TextInputLayout passError;
    TextView tDaftar;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.eEmail = (EditText) findViewById(R.id.inputEmail);
        this.ePassword = (EditText) findViewById(R.id.inputPW);
        this.tDaftar = (TextView) findViewById(R.id.registrasi);
        this.bLogin = (Button) findViewById(R.id.btnLogin);
        this.emailError = (TextInputLayout) findViewById(R.id.WrongMail);
        this.passError = (TextInputLayout) findViewById(R.id.WrongPass);
        this.bLogin.setOnClickListener(new View.OnClickListener() {
            /* class com.example.exercise1.MainActivity.AnonymousClass1 */

            public void onClick(View view) {
                MainActivity.this.Validasi();
            }
        });
        this.tDaftar.setOnClickListener(new View.OnClickListener() {
            /* class com.example.exercise1.MainActivity.AnonymousClass2 */

            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), Registrasi.class));
            }
        });
    }

    public void Validasi() {
        if (this.eEmail.getText().toString().isEmpty()) {
            this.emailError.setError("Email Cannot Be Empty");
            this.checkmail = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(this.eEmail.getText().toString()).matches()) {
            this.emailError.setError("Please Enter Email Correctly");
            this.checkmail = false;
        } else {
            this.checkmail = true;
            this.emailError.setErrorEnabled(false);
        }
        if (this.ePassword.getText().toString().isEmpty()) {
            this.passError.setError("Passwords Cannot Be Empty");
            this.checkpass = false;
        } else {
            this.checkpass = true;
            this.passError.setErrorEnabled(false);
        }
        if (!this.checkmail || !this.checkpass || !this.eEmail.getText().toString().equals("rio@gmail.com") || !this.ePassword.getText().toString().equals("rio123")) {
            Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getApplicationContext(), Page2.class));
    }
}
