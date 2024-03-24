package ntu_63130599.cau2_studentmanagement.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import ntu_63130599.cau2_studentmanagement.MainActivity;
import ntu_63130599.cau2_studentmanagement.R;
import ntu_63130599.cau2_studentmanagement.model.SinhVien;

public class AdapterSinhVien extends ArrayAdapter<SinhVien> {
    //Màn hình sử dụng layout này
    Activity context;
    //Layout cho từng dòng muốn hiển thị Item
    int resource;
    //Danh sách dữ liệu muốn hiển thị lên màn hình
    @NonNull
    List<SinhVien> objects;


    public AdapterSinhVien(@NonNull Activity context, int resource, @NonNull List<SinhVien> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Đây là 1 lớp để build layout bình thường thành code java mà android sử dụng dc
        //load file xml vào hệ thống và build thành code để chương trình có thể sử dụng
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        //Đổi số this.resouce chính là item.xml, ta truyen vào khi gọi adapterSinhVien
        View row = layoutInflater.inflate(this.resource, null);

        ImageView img= row.findViewById(R.id.imageView);
        TextView profile = row.findViewById(R.id.profile);
        CheckBox checkBox = row.findViewById(R.id.checkBox);

        SinhVien sinhVien = this.objects.get(position);
        if (sinhVien.getGioiTinh()==true)
        {
            img.setImageResource(R.drawable.male);
        }
        else
        {
            img.setImageResource(R.drawable.female);
        }
        profile.setText(sinhVien.getID() +"  -  "+sinhVien.getName() +"  -  "+sinhVien.getLop());
        //Khi nhấn checkbox sẽ lưu vị trí sangarray vitri bên class main
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()){
                    //Gọi arraylisst
                    //position là vị trí item (dòng thông tin)
                    MainActivity.vitri.add(position);
                }
            }
        });
        return row;
    }
}
