package lesson43;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai2 {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        taiKhoanNganHang t = new taiKhoanNganHang("nguyen xuan tuan anh", "0981089128",14.5f);
        taiKhoanNganHang t1 = new taiKhoanNganHang("nguyen xuan ha ", "122441987", 15.5f);
        boolean flag = true;
        do {
            System.out.println("nhap so tien phai thanh toan: ");
            var tienPTT = scan.nextLine();

            var regex = "\\d{1,8}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(tienPTT);
            if (matcher.matches()) {
                System.out.println("success");
                flag = false;
                var parseTien = Float.parseFloat(tienPTT);
                try {

                    t.rutTien(parseTien);
                } catch (InvalidMoneyException e) {
                    e.printStackTrace();
                }
                System.out.println("ten chu the" + t.getTenChuThe());
                try {
                    t.ChuyenTien(parseTien, t1);
                } catch (InvalidMoneyException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("khong hop le");
            }
        }while(flag);



    }
}
class taiKhoanNganHang{
    private String tenChuThe;
    private String soThe;
    private float soTienTrongTK;

    public taiKhoanNganHang(String tenChuThe, String soThe, float soTienTrongTK) {
        this.tenChuThe = tenChuThe;
        this.soThe = soThe;
        this.soTienTrongTK = soTienTrongTK;
    }

    public String getTenChuThe() {
        return tenChuThe;
    }

    public void setTenChuThe(String tenChuThe) {
        this.tenChuThe = tenChuThe;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public float getSoTienTrongTK() {
        return soTienTrongTK;
    }

    public void setSoTienTrongTK(float soTienTrongTK) {
        this.soTienTrongTK = soTienTrongTK;
    }
    public void rutTien(float tienRut) throws InvalidMoneyException {
        if(this.soTienTrongTK < tienRut){
            var text = "so tien Rut Khong hop Le";
            throw new InvalidMoneyException(text, tienRut);

        }else{
            this.soTienTrongTK -=tienRut;
            System.out.println("success");
        }
    }
    public void ChuyenTien(float tienChuyen, taiKhoanNganHang t) throws InvalidMoneyException {
        if(this.soTienTrongTK < tienChuyen){
            var text = " so tien chuyen khong hop le";
            throw new InvalidMoneyException(text, tienChuyen);

        }else{
          t.soTienTrongTK += tienChuyen;
          this.soTienTrongTK -= tienChuyen;
            System.out.println("success");

        }

    }
}
class InvalidMoneyException extends Exception{
    private float tienRut;

    public InvalidMoneyException() {
    }

    public InvalidMoneyException(String message, float tienRut) {
        super(message);
        this.tienRut = tienRut;
    }

    public float getTienRut() {
        return tienRut;
    }
}
