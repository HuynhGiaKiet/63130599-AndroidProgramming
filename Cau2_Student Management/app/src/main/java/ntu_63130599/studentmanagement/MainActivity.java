package ntu_63130599.studentmanagement;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnList, btnInfo, btnExit;
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

        btnCreate = findViewById(R.id.btnCreate);
        btnList = findViewById(R.id.btnList);
        btnInfo = findViewById(R.id.btnInfo);
        btnExit = findViewById(R.id.btnExit);
        //Click Create
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chuyển qua ActivityStudent
                Intent myintent = new Intent(MainActivity.this,ActivityStudent.class);
                startActivity(myintent);
            }
        });
        //Click info
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInfo();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogExit();
            }
        });
    }
    //Hiển thị thông báo thoát
    private void DialogExit() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogexit);
        //Tắt click ngoài là thoát
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = findViewById(R.id.btnYes);
        Button btnNo = findViewById(R.id.btnNo);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);

                Intent intent1 = new Intent(Intent.ACTION_MAIN);
                intent1.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent1);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }




    //Hiển thị thông tin sinh viên
    private void DialogInfo(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialoginformation);
        dialog.show();
    }

    private void DialogCreate(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_student);
        dialog.show();
    }

}