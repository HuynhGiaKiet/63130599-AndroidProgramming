package kit.edu.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
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
        //Tìm view
         Timview();
        btnCong.setOnClickListener(BoLangNghe_XuLyCong);
        btnTru.setOnClickListener(BoLangNghe_XuLyTru);
        btnNhan.setOnClickListener(BoLangNghe_XuLyNhan);
        btnChia.setOnClickListener(BoLangNghe_XuLyChia);
    }
    //-----------------------------------------------------
    //Tạo bộ lắng nghe và xử lý sự kiện
    View.OnClickListener BoLangNghe_XuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Code xử lý cộng
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            //Chuyn thành số để tính toán
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //Tính toán
            double Tong = soA + soB;
            String strKQ= String.valueOf(Tong);
            tvKetQua.setText(strKQ);

        }
    };
    View.OnClickListener BoLangNghe_XuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Code xử lý cộng
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            //Chuyn thành số để tính toán
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //Tính toán
            double Tru = soA - soB;
            String strKQ= String.valueOf(Tru);
            tvKetQua.setText(strKQ);

        }
    };
    View.OnClickListener BoLangNghe_XuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Code xử lý cộng
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            //Chuyn thành số để tính toán
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //Tính toán
            double Nhan = soA * soB;
            String strKQ= String.valueOf(Nhan);
            tvKetQua.setText(strKQ);

        }
    };
    View.OnClickListener BoLangNghe_XuLyChia = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Code xử lý cộng
            String strSo1 = edtSoA.getText().toString();
            String strSo2 = edtSoB.getText().toString();
            //Chuyn thành số để tính toán
            double soA = Double.parseDouble(strSo1);
            double soB = Double.parseDouble(strSo2);
            //Tính toán
            double Chia = soA / soB;
            String strKQ= String.valueOf(Chia);
            tvKetQua.setText(strKQ);

        }
    };
    //-----------------------------------------------------
    void Timview(){
            edtSoA = (EditText) findViewById(R.id.editTextA);
            edtSoB = (EditText) findViewById(R.id.editTextB);;
            btnCong = (Button) findViewById(R.id.buttonCong);
            btnTru = (Button) findViewById(R.id.buttonTru);
            btnNhan = (Button) findViewById(R.id.buttonNhan);
            btnChia = (Button) findViewById(R.id.buttonChia);
    }
    //Khai báo các đối tượng tương ứng với các điều khiển (view) cần thao tác
    EditText edtSoA;
    EditText edtSoB;
    Button btnCong,btnTru,btnNhan,btnChia;
    TextView tvKetQua;
}