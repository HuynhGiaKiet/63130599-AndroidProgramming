package kit.edu.anynomous;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kit.edu.anynomous.R;
import kit.edu.anynomous.onCreateView;

public class MainActivity extends AppCompatActivity {
    //Khai báo các đối tượng gắn với điều khiển tương ứng ở đây
    EditText editTextSO1;
    EditText editTextSO2;
    EditText editTextKQ;
    Button nutCong,nutTru,nutNhan,nutChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TimDieuKhien();
        View.OnClickListener BoLangNgheCong = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lý cộng ở đây
                XULY_CONG();
            }
        };
        nutCong.setOnClickListener(BoLangNgheCong);

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_TRU();
            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_NHAN();
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XULY_CHIA();
            }
        });
    }
    void TimDieuKhien(){
        editTextSO1 = (EditText)findViewById(R.id.edtSO1);
        editTextSO2 = (EditText)findViewById(R.id.edtSO2);
        editTextKQ= (EditText) findViewById(R.id.edtKQ);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);

    }
    void XULY_CONG(){
        String so1 = editTextSO1.getText().toString();
        String so2 = editTextSO2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong = num1 + num2;
        String ChuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(ChuoiKQ);
    }
    void XULY_TRU(){
        String so1 = editTextSO1.getText().toString();
        String so2 = editTextSO2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong = num1 - num2;
        String ChuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(ChuoiKQ);
    }
    void XULY_NHAN(){
        String so1 = editTextSO1.getText().toString();
        String so2 = editTextSO2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong = num1 * num2;
        String ChuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(ChuoiKQ);
    }
    void XULY_CHIA(){
        String so1 = editTextSO1.getText().toString();
        String so2 = editTextSO2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong = num1 / num2;
        String ChuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(ChuoiKQ);
    }
}

