package lesson43.bai5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Manager extends Employee{
    private Calendar ngayBD;
    private Calendar ngayKT;

    public Manager() {
        this.ngayBD = Calendar.getInstance();
        this.ngayKT= Calendar.getInstance();

    }

    public Manager(String idCard, String email, Calendar birday, String adress, String numberPhone, FullName fullName, String id, String sNKN, float luongTheoNgay, float soNgayLamViec, float luongThuong, float luongThang, float tongLuong, Calendar ngayBD, Calendar ngayKT) {
        super(idCard, email, birday, adress, numberPhone, fullName, id, sNKN, luongTheoNgay, soNgayLamViec, luongThuong, luongThang, tongLuong);
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public Calendar getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Calendar ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Calendar getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Calendar ngayKT) {
        this.ngayKT = ngayKT;
    }
    @Override
    protected void inPut(Scanner scan){
        super.inPut(scan);
        var format = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        System.out.printf("ngay bat dau nhiem ki(VD: 25/01/2003) : ");
        var Bd = scan.nextLine();
        try {
            Date dateBD = simpleDateFormat.parse(Bd);
            this.ngayBD.setTime(dateBD);
            System.out.println("ngay ket Thuc nhiem ki (VD: 23/02/2024):");
            var kT = scan.nextLine();
            Date dateKT = simpleDateFormat.parse(kT);
            this.ngayKT.setTime(dateKT);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
    @Override
    protected void tinhLuongThuong(){
        if(getSoNgayLamViec() >= 22){
            float luongThuong = 0.25f * getLuongThang();
            setLuongThuong(luongThuong);
        }
    }
}
