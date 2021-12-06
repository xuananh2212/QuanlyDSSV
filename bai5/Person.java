package lesson43.bai5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {

    private String idCard;// chung minh thu
    private String email;
    private Calendar birday;// ngay sinh
    private String adress;// dia chia
    private String numberPhone;// so dien thoai
    private FullName fullName;

    protected Person() {
        this.fullName = new FullName();
        this.birday = Calendar.getInstance();
    }

    public Person(String idCard, String email, Calendar birday, String adress, String numberPhone, FullName fullName) {
        this.idCard = idCard;
        this.email = email;
        this.birday = birday;
        this.adress = adress;
        this.numberPhone = numberPhone;
        this.fullName = fullName;
    }

    public final String getIdCard() {
        return idCard;
    }

    public final void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        this.email = email;
    }

    public final Calendar getBirday() {
        return birday;
    }

    public final void setBirday(Calendar birday) {
        this.birday = birday;
    }

    public final String getAdress() {
        return adress;
    }

    public final void setAdress(String adress) {
        this.adress = adress;
    }

    public final String getNumberPhone() {
        return numberPhone;
    }

    public final void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public final FullName getFullName() {
        return fullName;
    }

    public final void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    protected void inPut(Scanner scan) {
        var format = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        System.out.println("nhap so chung minh nhan dan: ");
        var sCMND = scan.nextLine();
        this.idCard = sCMND;
        System.out.println("nhap ho va ten:");
        var fullName = scan.nextLine();
        boolean flag = kiemTraNgoaiLeTen(fullName);
        if (!flag) {
            var ngoaiLe = "ban ten khong dung, ngoai le";
            try {
                throw new InvalidFullNameException(ngoaiLe, fullName);
            } catch (InvalidFullNameException e) {
                e.printStackTrace();
            }
        } else {
            var fName = fullName.split(" ");
            this.fullName.setSurName(fName[0]);
            this.fullName.setFirtName(fName[fName.length - 1]);
            var midName = "";
            for (int i = 1; i < fName.length - 1; i++) {
                midName += fName[i] + " ";
            }
            this.fullName.setMiddleName(midName);

        }
        System.out.println("email: ");
        var email = scan.nextLine();
        if(kiemTraNgoaiLeEmail(email)){
            this.email = email;
        }else{
            var exception ="email khong hop le vui long nhap lap";
            this.email = null;
            try {
                throw new InvalidEmailException(exception,email);
            } catch (InvalidEmailException e) {
                e.printStackTrace();
            }
        }
        System.out.println("dia chi : ");
        this.adress = scan.nextLine();
        System.out.println("ngay/thang/nam(vd: 25/12/2003) :");
        var birday = scan.nextLine();
        boolean flag1 = kiemTraNgoaiLeBirday(birday);
        if (!flag1) {
            var text = "nhap ngay thang nam sinh ngoai le";
            try {
                throw new InvaliBirdayException(text, birday);
            } catch (InvaliBirdayException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Date date = simpleDateFormat.parse(birday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        System.out.println("so dien thoai: ");
        var numberPhone = scan.nextLine();
        if(checkExceptionNumber(numberPhone)){
            this.numberPhone = numberPhone;
        }else{
            var exception ="nhap so dien thoai khong hop le";
            this.numberPhone = null;
            try {
                throw new InvalidNumberException(exception, numberPhone);
            } catch (InvalidNumberException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean kiemTraNgoaiLeTen(String fullName) {
        var regex = "^([a-z]+\\s+[a-z]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(fullName);
        if (matcher.matches()) {
            return true;
        }
        return false;

    }

    protected boolean kiemTraNgoaiLeBirday(String birday) {
        var regex = "^\\d{1,2}[/]{1}\\d{1,2}[/]{1}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birday);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    protected boolean kiemTraNgoaiLeEmail(String email) {
        var regex = "^[a-z]+[a-z0-9_.]+@gmail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
    protected boolean checkExceptionNumber(String numberPhone) {
        var regex = "^((09|08){1}\\d{7}|(03|04|07){1}\\d{8})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numberPhone);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    protected void outPut() {
        var string = this.birday.get(Calendar.DAY_OF_MONTH) + "/" + this.birday.get(Calendar.MONTH) + "/" + this.birday.get(Calendar.YEAR);
        System.out.printf("%-12s %-15s %-10s %-10s %-15s %-10s", this.idCard, this.email, string, this.fullName.getFirtName(), this.adress, this.numberPhone);
    }

    protected abstract void tinhLuongThucLinh();

    protected abstract void tinhLuongThuong();


    protected abstract void tongLuong();

    protected void setId(String id) {
    }

    public String getId() {
        return "";
    }


    class FullName {
        private String surName;
        private String firtName;
        private String middleName;

        public FullName() {
        }

        public String getSurName() {
            return surName;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public String getFirtName() {
            return firtName;
        }

        public void setFirtName(String firtName) {
            this.firtName = firtName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }
    }


}

class InvalidNgayThangNamSinhException extends Exception {
    private String ngayThangNam;

    public InvalidNgayThangNamSinhException(String ngayThangNam) {
        this.ngayThangNam = ngayThangNam;
    }

    public InvalidNgayThangNamSinhException(String message, String ngayThangNam) {
        super(message);
        this.ngayThangNam = ngayThangNam;
    }

    public String getNgayThangNam() {
        return ngayThangNam;
    }
}

class InvalidFullNameException extends Exception {
    private String fullName;

    public InvalidFullNameException(String message, String fullName) {
        super(message);
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

class InvaliBirdayException extends Exception {
    private String Birday;

    public InvaliBirdayException(String message, String birday) {
        super(message);
        Birday = birday;
    }

    public String getBirday() {
        return Birday;
    }

    public void setBirday(String birday) {
        Birday = birday;
    }
}
class InvalidEmailException extends Exception{
    private String ivalidEmail;

    public InvalidEmailException(String message, String ivalidEmail) {
        super(message);
        this.ivalidEmail = ivalidEmail;
    }

    public InvalidEmailException() {

    }

    public String getIvalidEmail() {
        return ivalidEmail;
    }

    public void setIvalidEmail(String ivalidEmail) {
        this.ivalidEmail = ivalidEmail;
    }
}
class InvalidNumberException extends Exception{
    private String numberIphone;

    public InvalidNumberException() {
    }

    public InvalidNumberException(String message, String numberIphone) {
        super(message);
        this.numberIphone = numberIphone;
    }

    public String getNumberIphone() {
        return numberIphone;
    }

    public void setNumberIphone(String numberIphone) {
        this.numberIphone = numberIphone;
    }
}
