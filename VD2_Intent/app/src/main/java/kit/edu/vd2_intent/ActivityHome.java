package kit.edu.vd2_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityHome extends AppCompatActivity {

    TextView txt_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityhome);
        txt_username = findViewById(R.id.inputName);
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        txt_username.setText(username);
    }
}
