package lesson43.bai5;

import java.util.Calendar;
import java.util.Scanner;

public class Employee extends Person {
    private static final int THANG_LAM = 22;
    private static final float LUONG_THUONG = 0.5F;

    private String id;
    private String sNKN;
    private float luongTheoNgay;
    private float soNgayLamViec;
    private float luongThuong;
    private float luongThang;
    private float TongLuong;

    public Employee() {
    }

    public Employee(String idCard, String email, Calendar birday, String adress, String numberPhone, FullName fullName, String id, String sNKN, float luongTheoNgay, float soNgayLamViec, float luongThuong, float luongThang, float tongLuong) {
        super(idCard, email, birday, adress, numberPhone, fullName);
        this.id = id;
        this.sNKN = sNKN;
        this.luongTheoNgay = luongTheoNgay;
        this.soNgayLamViec = soNgayLamViec;
        this.luongThuong = luongThuong;
        this.luongThang = luongThang;
        TongLuong = tongLuong;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getsNKN() {
        return sNKN;
    }

    public void setsNKN(String sNKN) {
        this.sNKN = sNKN;
    }

    public float getLuongTheoNgay() {
        return luongTheoNgay;
    }

    public void setLuongTheoNgay(float luongTheoNgay) {
        this.luongTheoNgay = luongTheoNgay;
    }

    public float getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(float soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public float getLuongThuong() {
        return luongThuong;
    }

    public float getLuongThang() {
        return luongThang;
    }

    public float getTongLuong() {
        return TongLuong;
    }

    public void setLuongThuong(float luongThuong) {
        this.luongThuong = luongThuong;
    }

    public void setLuongThang(float luongThang) {
        this.luongThang = luongThang;
    }

    public void setTongLuong(float tongLuong) {
        TongLuong = tongLuong;
    }

    @Override
    protected void inPut(Scanner scan) {
        super.inPut(scan);
        System.out.println("so nam kinh nghiem: ");
        this.sNKN = scan.nextLine();
        System.out.println("so ngay lam viec : ");
        this.soNgayLamViec = Float.parseFloat(scan.nextLine());
        try {
            setKiemTraNgoaiLeSoNgaylam();
        } catch (InvalidSoNGayLamExcepTion e) {
            e.printStackTrace();
        }
        System.out.println("luong Theo Ngay: ");
        this.luongTheoNgay = Float.parseFloat(scan.nextLine());
    }

    @Override
    protected void outPut() {
        super.outPut();
        System.out.printf("%-5s %-15s\n", this.sNKN, this.id);
    }

    @Override
    protected void tinhLuongThucLinh() {
        this.luongThang = (this.soNgayLamViec * this.luongTheoNgay) / THANG_LAM;

    }

    @Override
    protected void tinhLuongThuong() {
        if (this.soNgayLamViec >= 20) {
            this.luongThuong = (LUONG_THUONG * this.luongTheoNgay) / THANG_LAM;
        } else {
            this.luongThuong = 0;
        }
    }

    @Override
    protected void tongLuong() {
        this.TongLuong = this.luongThang + this.luongThuong;
    }

    public void setKiemTraNgoaiLeSoNgaylam() throws InvalidSoNGayLamExcepTion {
        if (this.soNgayLamViec < 0 || this.soNgayLamViec > 30) {
            var text = "so ngay lam viec khong hop le";
            throw new InvalidSoNGayLamExcepTion(text, this.soNgayLamViec);


        }
    }
}

class InvalidSoNGayLamExcepTion extends Exception {
    private float soNgayLamViec;

    public InvalidSoNGayLamExcepTion(String message, float soNgayLamViec) {
        super(message);
        this.soNgayLamViec = soNgayLamViec;
    }

    public float getSoNgayLamViec() {
        return soNgayLamViec;
    }
}

