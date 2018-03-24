package b12app.vyom.com.stepit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText username, pass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("vyom") && pass.getText().toString().equals("1234")){
                    Intent intent = new Intent(Login.this,Home.class);
                    String user = username.getText().toString();
                   // intent.putExtra("username",user);
                    startActivity(intent);
                } else{
                    ContextThemeWrapper ctw = new ContextThemeWrapper(Login.this, R.style.Background);
                    AlertDialog.Builder alert = new AlertDialog.Builder(ctw);
                    alert.setTitle("Invalid Credentials");
                    alert.setMessage("Username and Password do not match");

                    alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }

                    });
                    alert.show();
                }
            }
        });
    }
}
