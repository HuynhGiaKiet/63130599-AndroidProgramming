package kit.edu.vd2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    public void XuLyCong(View view){
        //code xử lý
        //b1: lấy dữ liệu vào
        //b1.2: tìm editext số 1 và số 2

        //b1.3: lấy dữ liệu từ 2 điều khiển editext
        String SO1 = editTextSO1.getText().toString();
        String SO2 = editTextSO2.getText().toString();
        //b1.4: chuyển dữ liệu từ chuỗi sang số
        float so1 = Float.parseFloat(SO1);
        float so2 = Float.parseFloat(SO2);
        //b2: Tính cộng
        float Tong = so1 + so2;
        //b3: hiển thị kết quả
        //b3.1: tìm edit text kết quả
        //b3.2: chuẩn bị dữ liệu xuất
        String ChuoiKQ = String.valueOf(Tong);
        //B3.3: gắn kết quả lên
        editTextKQ.setText(ChuoiKQ);
    }

    public void XuLyTru(View view){
        //code xử lý
        //b1: lấy dữ liệu vào
        //b1.2: tìm editext số 1 và số 2
        EditText editTextSO1 = (EditText)findViewById(R.id.edtSO1);
        EditText editTextSO2 = (EditText)findViewById(R.id.edtSO2);
        //b1.3: lấy dữ liệu từ 2 điều khiển editext
        String SO1 = editTextSO1.getText().toString();
        String SO2 = editTextSO2.getText().toString();
        //b1.4: chuyển dữ liệu từ chuỗi sang số
        float so1 = Float.parseFloat(SO1);
        float so2 = Float.parseFloat(SO2);
        //b2: Tính cộng
        float Tru = so1 - so2;
        //b3: hiển thị kết quả
        //b3.1: tìm edit text kết quả
        EditText editTextKQ= (EditText) findViewById(R.id.edtKQ);
        //b3.2: chuẩn bị dữ liệu xuất
        String ChuoiKQ = String.valueOf(Tru);
        //B3.3: gắn kết quả lên
        editTextKQ.setText(ChuoiKQ);
    }

    public void XuLyNhan(View view){
        //code xử lý
        //b1: lấy dữ liệu vào
        //b1.2: tìm editext số 1 và số 2
        EditText editTextSO1 = (EditText)findViewById(R.id.edtSO1);
        EditText editTextSO2 = (EditText)findViewById(R.id.edtSO2);
        //b1.3: lấy dữ liệu từ 2 điều khiển editext
        String SO1 = editTextSO1.getText().toString();
        String SO2 = editTextSO2.getText().toString();
        //b1.4: chuyển dữ liệu từ chuỗi sang số
        float so1 = Float.parseFloat(SO1);
        float so2 = Float.parseFloat(SO2);
        //b2: Tính cộng
        float Nhan = so1 * so2;
        //b3: hiển thị kết quả
        //b3.1: tìm edit text kết quả
        EditText editTextKQ= (EditText) findViewById(R.id.edtKQ);
        //b3.2: chuẩn bị dữ liệu xuất
        String ChuoiKQ = String.valueOf(Nhan);
        //B3.3: gắn kết quả lên
        editTextKQ.setText(ChuoiKQ);
    }

    public void XuLyChia(View view){
        //code xử lý
        //b1: lấy dữ liệu vào
        //b1.2: tìm editext số 1 và số 2
        EditText editTextSO1 = (EditText)findViewById(R.id.edtSO1);
        EditText editTextSO2 = (EditText)findViewById(R.id.edtSO2);
        //b1.3: lấy dữ liệu từ 2 điều khiển editext
        String SO1 = editTextSO1.getText().toString();
        String SO2 = editTextSO2.getText().toString();
        //b1.4: chuyển dữ liệu từ chuỗi sang số
        float so1 = Float.parseFloat(SO1);
        float so2 = Float.parseFloat(SO2);
        //b2: Tính cộng
        float Chia = so1 / so2;
        //b3: hiển thị kết quả
        //b3.1: tìm edit text kết quả
        EditText editTextKQ= (EditText) findViewById(R.id.edtKQ);
        //b3.2: chuẩn bị dữ liệu xuất
        String ChuoiKQ = String.valueOf(Chia);
        //B3.3: gắn kết quả lên
        editTextKQ.setText(ChuoiKQ);
    }
}