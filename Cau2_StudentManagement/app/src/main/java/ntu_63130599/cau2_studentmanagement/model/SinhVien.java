package ntu_63130599.cau2_studentmanagement.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String ID;
    private String Name;
    private String Lop;
    private Boolean gioiTinh;

    public SinhVien(){

    }

    public SinhVien(String ID, String Name, String Lop, Boolean gioiTinh) {
        this.ID = ID;
        this.Name = Name;
        this.Lop = Lop;
        this.gioiTinh = gioiTinh;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
