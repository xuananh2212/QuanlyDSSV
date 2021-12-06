package lesson43.bai5;

import lesson43.bai5.DSQL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class XuLy {
    public static int NEXT_ID = 1001;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DSQL dsql = new DSQL();
        dsql.readFile();
        doMenu(dsql, scan);


    }

    public static void menu() {
        System.out.println("1.them nhan vien: ");
        System.out.println("2.them giam doc ");
        System.out.println("3.hien thi nhan vien");
        System.out.println("4.tim ten nhan vien ");
        System.out.println("5.tim muc luong nhan vien co thu nhap >= x tu ban phim");
        System.out.println("6.tim giam doc theo nhiem ki");
        System.out.println("7.xoa nhan vien voi ma cho truoc");
        System.out.println("8.tinh luong cho nhan vien , giam doc");
        System.out.println("9.hien thi luong thuong");
        System.out.println("10.hien thi bang luong");
        System.out.println("11.ghi file");
        System.out.println("12.sap xep nhan vien theo ten a-z");
        System.out.println("13.sap xep nhan vien theo ten z -a ");
        System.out.println("14.sap xep nhan vien theo Muc luong tang dan");
        System.out.println("15.sap xep nhan vien theo Muc Luong giam dan ");
        System.out.println("16.sap xep so nam kinh nghiem tang dan");
        System.out.println("17.sap xep tuoi tu tre - gia");
        System.out.println("18.sap xep tuoi tu gia - tre");
        System.out.println("19.sap xep theo tong Luong linh giam dan");
        System.out.println("20.sap xep theo so nam kinh nghiem giam dan");
        System.out.println("21.EXIT");
    }

    public static void doMenu(DSQL dsql, Scanner scan) {
        boolean flag = true;
        do {
            Person p;
            int chon;
            menu();
            ArrayList<Employee> listE = new ArrayList<>();
            for (var EOFM : dsql.getListEmPOFMana()) {
                if (EOFM instanceof Employee) {
                    listE.add((Employee) EOFM);
                }
            }
            System.out.print("moi chon>>>>>>>>>: ");
            chon = Integer.parseInt(scan.nextLine());
            switch (chon) {
                case 1:
                    var MaSV = "EMP" + (NEXT_ID++);
                    p = new Employee();
                    p.setId(MaSV);
                    p.inPut(scan);
                    dsql.addPersonAndManager(p);
                    break;
                case 2:
                    p = new Manager();
                    p.inPut(scan);
                    dsql.addPersonAndManager(p);
                    break;
                case 3:
                    dsql.outPutOFEMOfPerson();
                    break;
                case 4:
                    System.out.println("nhap ten ban muon tim: ");
                    var name = scan.nextLine();
                    ArrayList<Employee> list = dsql.timEmployeeTheoName(name);
                    dsql.outPutOFEM(list);
                    break;
                case 5:
                    System.out.println("nhap muc luong x: ");
                    var luongX = Float.parseFloat(scan.nextLine());
                    dsql.timEmployeeCoLuongLonHonX(luongX);
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("nhap Ma Nhan vien muon xoa: ");
                    var maSV = scan.nextLine();
                    dsql.xoaEmployeeVoiMa(maSV);
                    break;
                case 8:
                    dsql.tinhLuong();
                    break;
                case 9:
                    dsql.OutPutLuongThuong();
                    break;
                case 10:
                    dsql.OutPutBangluong();
                    break;
                case 11:
                    dsql.writerFile();
                    break;
                case 12:

                    Collections.sort(listE, new SapXepTenTangDan());
                    dsql.outPutOFEM(listE);

                    break;
                case 13:
                    Collections.sort(listE, new SapXepTenGiamDan());
                    dsql.outPutOFEM(listE);

                    break;
                case 14:
                    Collections.sort(listE, new SapXepMucLuongTangDan());
                    dsql.outPutOFEM(listE);
                    break;
                case 15:
                    Collections.sort(listE, new SapXepMucLuongGiamDan());
                    dsql.outPutOFEM(listE);
                    break;
                case 16:
                    Collections.sort(listE, new SapXepSoNamKinhNghiemTangDan());
                    dsql.outPutOFEM(listE);
                    break;
                case 17:
                    Collections.sort(listE, new SapXepTuoiTreDenTuoiGia());
                    dsql.outPutOFEM(listE);
                    break;
                case 18:
                    Collections.sort(listE, new SapXepTuoiGiaDenTuoiTre());
                    dsql.outPutOFEM(listE);
                    break;
                case 19:
                    dsql.tinhLuong();
                    Collections.sort(listE, new SapXepTheoTongLuongLinh());
                    dsql.outPutOFEM(listE);
                    break;
                case 20:
                    Collections.sort(listE, new SapXepSoNamKinhNghiemGiamDan());
                    dsql.outPutOFEM(listE);
                    break;
                case 21:
                    flag = false;
                    break;


            }

        } while (flag);

    }
}
