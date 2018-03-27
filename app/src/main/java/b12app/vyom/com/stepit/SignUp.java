package b12app.vyom.com.stepit;

import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SignUp extends AppCompatActivity implements View.OnFocusChangeListener, AdapterView.OnItemSelectedListener{

    private static final String TAG ="Log" ;
    String spnItem;
    RadioGroup radioGroup;
    Button btnDate;
    Calendar myCalendar;
    RadioButton radio;
    private int mYear, mMonth, mDay;

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

        btnDate = findViewById(R.id.btnDate);
        myCalendar   = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener dpd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                updateLabel();
            }
        };


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                new DatePickerDialog(SignUp.this,dpd,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.spinner_format,R.id.spinner_box,arrays); //adapter
        spinner.setAdapter(arrayAdapter); //plug

         radioGroup = findViewById(R.id.radioGroup);









    }


    public void sendHome(View view) {
        EditText name = findViewById(R.id.etName);
        String nameS = name.getText().toString();

        EditText email = findViewById(R.id.etEmail);
        String emailS = email.getText().toString();

        EditText phone = findViewById(R.id.etPhone);
        String phoneS = phone.getText().toString();

        int id = radioGroup.getCheckedRadioButtonId();
        radio = findViewById(id);




        String myFormat = "MM dd, yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        String date = sdf.format(myCalendar.getTime());
        Log.i(TAG, "sendHome: "+date);


        Log.e(TAG, "sendHome: ");
            Intent send = new Intent(this, Home.class);


            send.putExtra("key_name", nameS);
            send.putExtra("key_email", emailS);
            send.putExtra("key_phone", phoneS);
            send.putExtra("key_country",spnItem);

            if(radio!=null) {

                String radioText= radio.getText().toString();
                send.putExtra("key_gender", radioText);
            }
            send.putExtra("key_date",date);
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


    public void pickDate(View view) {

        final Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);



    }
}
