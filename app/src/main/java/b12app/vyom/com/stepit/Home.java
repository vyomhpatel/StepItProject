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

        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("key_name"));
        tvEmail.setText(intent.getStringExtra("key_email"));
        tvPhone.setText(intent.getStringExtra("key_phone"));
    }
}
