package lesson43;

import org.w3c.dom.ranges.RangeException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai1 {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.println("nhap fullName: ");
        var fullName = scan.nextLine();
        System.out.println("nhap mau long : ");
        var mauLong = scan.nextLine();
        boolean flag = true;
        do {
            System.out.println("nhap tuoi(0-50): ");
            var text = scan.nextLine();
            var regex = "\\d{1,2}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if(matcher.matches()){
              flag = false;
              var yearn = Integer.parseInt(text);
                System.out.println("mon an yeu thich: ");
                var monAn = scan.nextLine();
                Cat c = new Cat(fullName, mauLong,"den", yearn, monAn);
                c.KiemTraDoTuoi(yearn);

            }else{
                System.out.println("vui long nhap lai");
            }
        }while(flag);

//        System.out.println("mon an yeu thich: ");
//        var monAn = scan.nextLine();
//        Cat c = new Cat(fullName, mauLong,"den", yearn, monAn);
//        c.KiemTraDoTuoi(yearn);yearn
//        try {
//        } catch (InvalidYearException1 e) {
//            e.printStackTrace();
//        }
      //System.out.println(c.getFullName());
    }

}

class Cat {
    private String fullName;
    private String mauLong;
    private String mauMat;
    private float year;
    private String monAnYeuThich;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMauLong() {
        return mauLong;
    }

    public void setMauLong(String mauLong) {
        this.mauLong = mauLong;
    }

    public String getMauMat() {
        return mauMat;
    }

    public void setMauMat(String mauMat) {
        this.mauMat = mauMat;
    }

    public float getYear() {
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }

    public String getMonAnYeuThich() {
        return monAnYeuThich;
    }

    public void setMonAnYeuThich(String monAnYeuThich) {
        this.monAnYeuThich = monAnYeuThich;
    }

    public Cat(String fullName, String mauLong, String mauMat, float year, String monAnYeuThich) {
        this.fullName = fullName;
        this.mauLong = mauLong;
        this.mauMat = mauMat;
        this.year = year;
        this.monAnYeuThich = monAnYeuThich;
    }

    public void KiemTraDoTuoi(float yearn) {
        if (this.year < 0 || this.year > 50) {
            this.year = 0;
            var text = "ngoai le xay ra nhap diem qua khoang 1 -> 50";
            throw new InvalidYearException1(text, yearn);


        }
    }
}

class InvalidYearException extends Exception {
    private float yearn;

    public InvalidYearException(String message, float yearn) {
        super(message);
        this.yearn = yearn;
    }

    public float getYearn() {
        return yearn;
    }
}
class InvalidYearException1 extends RuntimeException {
    private float yearn;

    public InvalidYearException1(String message, float yearn) {
        super(message);
        this.yearn = yearn;
    }

    public float getYearn() {
        return yearn;
    }
}
