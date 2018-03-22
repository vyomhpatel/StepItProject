package b12app.vyom.com.stepit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class SignUp extends AppCompatActivity {


    private static final String TAG ="Log" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Log.e(TAG, "onCreate: ");
        EditText name = findViewById(R.id.etName);
        String nameS = name.getText().toString();
        EditText email = findViewById(R.id.etEmail);
        String emailS = email.getText().toString();
        Button signup = findViewById(R.id.btnSignUp);

        EditText pass = findViewById(R.id.etPassword);
    }


    public void sendHome(View view) {

        Log.e(TAG, "sendHome: ");
        Intent send = new Intent(this,Home.class);
        EditText name = findViewById(R.id.etName);
        String nameS = name.getText().toString();
        EditText email = findViewById(R.id.etEmail);
        String emailS = email.getText().toString();

        EditText phone = findViewById(R.id.etPhone);
        String phoneS = phone.getText().toString();

        send.putExtra("key_name",nameS);
        send.putExtra("key_email",emailS);
        send.putExtra("key_phone",phoneS);

        startActivity(send);
    }
}
