package data.example.edunachal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edunachal.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail, loginPwd;

    private FirebaseAuth mAuth;
    private ProgressDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        loader = new ProgressDialog(this);

        if (mAuth.getCurrentUser() !=null){
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }

        loginEmail = findViewById(R.id.loginEmail);
        loginPwd = findViewById(R.id.loginPassword);
        Button loginBtn = findViewById(R.id.loginButton);
        TextView loginQn = findViewById(R.id.loginPageQuestion);
        loginQn.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(intent);
        });

        loginBtn.setOnClickListener(v -> {
            final String email = loginEmail.getText().toString().trim();
            String password = loginPwd.getText().toString().trim();

            if (TextUtils.isEmpty(email)){
                loginEmail.setError("Email is required");
                return;
            }
            if (TextUtils.isEmpty(password)){
                loginPwd.setError("Password is required");
            }else {
                loader.setMessage("Login in progress");
                loader.setCanceledOnTouchOutside(false);
                loader.show();

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        String error = Objects.requireNonNull(task.getException()).toString();
                        Toast.makeText(LoginActivity.this, "Login failed" + error, Toast.LENGTH_SHORT).show();
                    }
                    loader.dismiss();
                });

            }
        });

    }
}