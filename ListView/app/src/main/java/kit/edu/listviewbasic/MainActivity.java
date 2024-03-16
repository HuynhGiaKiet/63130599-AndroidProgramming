package kit.edu.listviewbasic;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Tại đây ta khai báo các biến toàn cục
    // ví dụ: các biến tham chiếu đến các điều khiển
    EditText edtThongTin;
    ListView lsvTen;
    // Biến lưu trữ danh sách tên
    ArrayList<String> dsTen;
    ArrayAdapter<String> bo_Nguon;
    //Hàm lấy tham chiếu
    void getControls(){
        edtThongTin = (EditText) findViewById(R.id.edThongTin);
        lsvTen = (ListView) findViewById(R.id.IvTen);
    }


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
        // Ta muốn, co ngay list view hiện dữ liệu khi màn hình được tạo ra và hiện lnee
        //nên ta viết tại đây
        getControls(); //Lấy tham chiếu
        //Tạo nguồn dữ liệu, danh sách tên
        dsTen = new ArrayList<String>(); // lệnh tạo mới danh sách
            // ở đây, ta tạo cứng (hardcode) một danh sách tên
        dsTen.add("Duy");
        dsTen.add("Kiệt");
        dsTen.add("Khoa");
        dsTen.add("Long");
        //Tạo Adapter và gắn vào nguồn dữ liệu
        bo_Nguon = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTen);
        //Cắm bộ nguồn vào ListView
        lsvTen.setAdapter(bo_Nguon);



    }
    public void ThemPhanTu(View v){
        //lấy dữ liệu từ điều khiển
        EditText edtTenMoi = (EditText) findViewById(R.id.edNhapTen);
        String tenNhap = edtTenMoi.getText().toString();
        //Thêm vào dsTen
        dsTen.add(tenNhap);
        //Yêu cầu adapter báo cho view (List view biết) đã có thay đổi ở nguồn dữ liệu
        //Cần phải cập nhật lại view
        bo_Nguon.notifyDataSetChanged();


    }
}