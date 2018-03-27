package b12app.vyom.com.stepit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tvName = findViewById(R.id.tvName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPhone = findViewById(R.id.tvPhone);
        TextView tvCountry = findViewById(R.id.tvCountry);
        TextView tvGender = findViewById(R.id.tvGender);
        TextView tvDate = findViewById(R.id.tvDate);

        Intent intent = getIntent();
        tvName.setText("Name: "+intent.getStringExtra("key_name"));
        tvEmail.setText("Email: "+intent.getStringExtra("key_email"));
        tvPhone.setText("Phone: "+intent.getStringExtra("key_phone"));
        tvCountry.setText("Country: "+intent.getStringExtra("key_country"));
        tvGender.setText("Gender: "+intent.getStringExtra("key_gender"));
        tvDate.setText("Birth Date: "+intent.getStringExtra("key_date"));
    }
}
