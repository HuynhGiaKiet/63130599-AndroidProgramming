package kit.edu.vd1_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
    //Hàm Xử Lý chuyển màn hình
    public void ChuyenManHinh (View v){
        //Tạo 1 đối tượng intent
        //Tham số thứ 2 của hàm tạo, là tên Activity(Màn hình) và ta muốn chuyển sang màn hình khác là SubActivityOne
        Intent iManHinh2 = new Intent(this,SubActivityOne.class);
        //Thực hiện việc chuyển
        startActivity(iManHinh2);
    }
}