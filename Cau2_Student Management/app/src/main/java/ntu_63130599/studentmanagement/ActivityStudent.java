package ntu_63130599.studentmanagement;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import ntu_63130599.studentmanagement.Adapter.AdapterSinhVien;
import ntu_63130599.studentmanagement.model.SinhVien;

public class ActivityStudent extends AppCompatActivity {
    ListView lv_HienThiDS;
    ArrayList<SinhVien> dsSinhVien = new ArrayList<>();
    AdapterSinhVien adapterSinhVien;

    //Tạo 1 vị trí click checkbox để xóa nhân viên
    //phải public và do ở hàm main nên phải dùng static
    public static  ArrayList<Integer> vitri = new ArrayList<>();
    Button btnXoa,btnThem;
    EditText txt_Maso,txt_Ten,txt_Lop;
    RadioButton btnNam, btnNu;
    boolean gioiTinh = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Quản Lý Sinh Viên");
        return super.onCreateOptionsMenu(menu);
    }

    private void addControls(){
        btnXoa = findViewById(R.id.btnXoa);
        btnThem = findViewById(R.id.btnThem);
        txt_Maso = findViewById(R.id.txt_Maso);
        txt_Ten = findViewById(R.id.txt_Ten);
        txt_Lop = findViewById(R.id.txt_Lop);
        btnNam = findViewById(R.id.btnNam);
        btnNu = findViewById(R.id.btnNu);

        lv_HienThiDS = findViewById(R.id.dsHienThi);
        dsSinhVien.add(new SinhVien("NV1","Gia Kiệt","63CNTT2",true));
        dsSinhVien.add(new SinhVien("NV2","Gia Huy","63CNTT2",true));
        //dsSinhVien.add(new SinhVien("NV3","Gia Long","63CNTT2",true));
        //dsSinhVien.add(new SinhVien("NV4","Gia Bảo","63CNTT2",true));
        //dsSinhVien.add(new SinhVien("NV5","Gia Hân","63CNTT2",false));
        adapterSinhVien = new AdapterSinhVien(ActivityStudent.this,R.layout.item_view,dsSinhVien);
        lv_HienThiDS.setAdapter(adapterSinhVien);
    }

    private void addEvent(){
        //sự kiện xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!vitri.isEmpty())
                {
                    for(int k:vitri)
                    {
                        dsSinhVien.remove(k);
                    }
                    vitri.clear();
                    adapterSinhVien.notifyDataSetChanged();
                }else{
                    Toast.makeText(ActivityStudent.this,"Chưa chọn nhân viên xóa.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (btnNam.isChecked()){
            gioiTinh = true;
        }else{
            gioiTinh = false ;
        }
        //Sự kiện thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsSinhVien.add(new SinhVien(txt_Maso.getText().toString(),txt_Ten.getText().toString(),txt_Lop.getText().toString(),gioiTinh));
            }
        });
    }
}