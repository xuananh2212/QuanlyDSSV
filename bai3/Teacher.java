package lesson43.bai3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher {

    private FullName fullName;
    private String id;
    private int sNKN;
    private float wage;
    private String chuyenMon;

    public Teacher() {
        this.fullName = new FullName();
    }

    public Teacher(FullName fullName, String id, int sNKN, float wage, String chuyenMon) {
        this.fullName = fullName;
        this.id = id;
        this.sNKN = sNKN;
        this.wage = wage;
        this.chuyenMon = chuyenMon;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getsNKN() {
        return sNKN;
    }

    public void setsNKN(int sNKN) {
        this.sNKN = sNKN;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    protected void inPut(Scanner scan) throws InvalidWageException {
        var regex = "^([a-z]+\\s+[a-z]+)+$";
        Pattern pattern = Pattern.compile(regex);
        boolean flag = true;
        boolean flag1 = true;

        do {
            System.out.println("Ho va Ten: ");
            var fullName = scan.nextLine();
            Matcher matcher = pattern.matcher(fullName);
            if (matcher.matches()) {
                flag = false;
                var chuoiString = fullName.split("\\s+");
                this.fullName.setFirtName(chuoiString[chuoiString.length - 1]);
                this.fullName.setSurmName(chuoiString[0]);
                var surmName = "";
                for (int i = 1; i < chuoiString.length - 1; i++) {
                    surmName += chuoiString[i] + " ";
                }
                this.fullName.setSurmName(surmName);

            }
        } while (flag);
        do {
            System.out.println("nhap id cho teacher: ");
            var teacher = scan.nextLine();
            var regex1 = "\\w";
            Pattern pattern1 = Pattern.compile(regex1);
            Matcher matcher1 = pattern1.matcher(teacher);
            if (matcher1.matches()) {
                this.id = teacher;
                flag1 = false;
            }
        } while (flag1);
        System.out.println("so nam kinh nghiem : ");
        var sNKN = Integer.parseInt(scan.nextLine());
        this.sNKN = sNKN;
        var regex2 ="^([0-7]\\d?.\\d{2}| 80.[0]{2})$";
        System.out.println("nhap muc luong teacher: ");
        var mucLuong = scan.nextLine();
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher = pattern2.matcher(mucLuong);
        if(matcher.matches()){
            var luong = Float.parseFloat(mucLuong);
            this.wage = luong;
        }else{
            var exception ="nhap khong hop le";
            this.wage = 0;

            throw new InvalidWageException(exception, wage);
        }



    }
    public void outPut(){
        System.out.printf("%-12s\t%-10s\t%-12.2f\n", this.fullName.getFirtName(), this.id, this.wage);
    }


    class FullName {
        private String midName;
        private String surmName;
        private String firtName;

        public FullName() {
        }

        public FullName(String midName, String surmName, String firtName) {
            this.midName = midName;
            this.surmName = surmName;
            this.firtName = firtName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }

        public String getSurmName() {
            return surmName;
        }

        public void setSurmName(String surmName) {
            this.surmName = surmName;
        }

        public String getFirtName() {
            return firtName;
        }

        public void setFirtName(String firtName) {
            this.firtName = firtName;
        }
    }
}

class InvalidWageException extends Exception {
    private String mess;
    private float wage;

    public InvalidWageException(String mess, float wage) {
        this.mess = mess;
        this.wage = wage;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }
}
