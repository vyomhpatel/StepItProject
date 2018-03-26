package b12app.vyom.com.stepit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {


    private static final String TAG ="Log" ;
    String spnItem;

    String[] arrays = {"India","United States","United Kingdom","China"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Log.e(TAG, "onCreate: ");
        EditText name = findViewById(R.id.etName);
        String nameS = name.getText().toString();
        name.setOnFocusChangeListener(this);
        EditText email = findViewById(R.id.etEmail);
        String emailS = email.getText().toString();
        Button signup = findViewById(R.id.btnSignUp);

        Button signin = findViewById(R.id.btnlogin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signin  = new Intent(SignUp.this,Login.class);
                startActivity(signin);
            }
        });

        EditText pass = findViewById(R.id.etPassword);

        Spinner spinner = findViewById(R.id.spinCountry);
        spinner.setOnItemSelectedListener(this);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_format,R.id.spinner_box,arrays); //adapter
        spinner.setAdapter(arrayAdapter); //plug


        Button cancel = findViewById(R.id.cancel);


        CheckBox cbMale = findViewById(R.id.maleC);
        CheckBox cbFemale = findViewById(R.id.femaleC);

        cbFemale.setOnCheckedChangeListener(this);
        cbMale.setOnCheckedChangeListener(this);
    }


    public void sendHome(View view) {
        EditText name = findViewById(R.id.etName);
        String nameS = name.getText().toString();

        EditText email = findViewById(R.id.etEmail);
        String emailS = email.getText().toString();

        EditText phone = findViewById(R.id.etPhone);
        String phoneS = phone.getText().toString();

            Log.e(TAG, "sendHome: ");
            Intent send = new Intent(this, Home.class);


            send.putExtra("key_name", nameS);
            send.putExtra("key_email", emailS);
            send.putExtra("key_phone", phoneS);
            send.putExtra("key_country",spnItem);
            startActivity(send);

    }

    @Override
    public void onFocusChange(View view, boolean isFocused) {
        if(isFocused){
            Toast.makeText(this,"Name is in focus",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Name is not in Focus",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner = findViewById(R.id.spinCountry);
        spnItem = spinner.getSelectedItem().toString();
        Toast.makeText(this,"selected item is "+spnItem,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this,"Nothing has been selected",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        Toast.makeText(this,"Selected",Toast.LENGTH_SHORT).show();

    }

    public void cancelClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(SignUp.this);
        alert.setTitle(" Cancel Alert");
        alert.setMessage("Are you sure, you want to cancel ");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }
}
