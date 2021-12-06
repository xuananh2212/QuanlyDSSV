package lesson43.bai5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DSQL {
    private ArrayList<Person> listEmPOFMana;

    public DSQL() {
        this.listEmPOFMana = new ArrayList<>();
    }

    public DSQL(ArrayList<Person> listEmPOFMana) {
        this.listEmPOFMana = listEmPOFMana;
    }

    public ArrayList<Person> getListEmPOFMana() {
        return listEmPOFMana;
    }

    public void setListEmPOFMana(ArrayList<Person> listEmPOFMana) {
        this.listEmPOFMana = listEmPOFMana;
    }

    public void addPersonAndManager(Person p) {
        this.listEmPOFMana.add(p);
    }

    public void outPutOFEMOfPerson() {
        System.out.printf("%-12s %-15s %-10s %-10s %-15s %-10s %-5s %-15s\n", "SCMD", "EMAIL", "dd/MM/YYYY", "TEN", "ADDRESS", "SDT", "SNKN", "MSV");
        for (var eOFM : this.listEmPOFMana) {
            if (eOFM instanceof Employee) {
                eOFM.outPut();
            }
        }
    }

    public void outPutOFEM(ArrayList<Employee> listEmPM) {
        System.out.printf("%-12s %-15s %-10s %-10s %-15s %-10s %-5s %-15s\n", "SCMD", "EMAIL", "dd/MM/YYYY", "TEN", "ADDRESS", "SDT", "SNKN", "MSV");
        for (var eOFM : listEmPM) {

            eOFM.outPut();
        }
    }


    public void writerFile() {
        int k = 0;
        File file = new File("EMP4.DAT");
        try {
            PrintWriter printWriter = new PrintWriter(file);
            for (var pOfM : this.listEmPOFMana) {
                if (pOfM instanceof Manager) {
                    k =1;
                    Manager m = (Manager) pOfM;
                    printWriter.print("false" + "-");
                    printWriter.print(m.getId() + "-");
                    printWriter.print(m.getFullName().getFirtName() + "-");
                    printWriter.print(m.getFullName().getMiddleName() + "-");
                    printWriter.print(m.getFullName().getSurName() + "-");
                    printWriter.print(m.getNumberPhone() + "-");
                    printWriter.print(m.getAdress() + "-");
                    printWriter.print(m.getEmail() + "-");
                    printWriter.print(m.getBirday().get(Calendar.DAY_OF_MONTH) + "/" + m.getBirday().get(Calendar.MONTH) + "/" + m.getBirday().get(Calendar.YEAR) + "-");
                    printWriter.print(m.getIdCard() + "-");
                    printWriter.print(m.getsNKN() + "-");
                    printWriter.print(m.getSoNgayLamViec() + "-");
                    printWriter.print(m.getLuongTheoNgay() + "-");
                    var ngayBD = m.getNgayBD().get(Calendar.DAY_OF_MONTH) + "/" + m.getNgayBD().get(Calendar.MONTH) +"/"+ m.getNgayBD().get(Calendar.YEAR);
                    var ngayKT = m.getNgayKT().get(Calendar.DAY_OF_MONTH) + "/" + m.getNgayKT().get(Calendar.MONTH) +"/"+ m.getNgayKT().get(Calendar.YEAR);
                    printWriter.print(ngayBD + "-");
                    printWriter.print(ngayKT + "\n");

                } else {
                    Employee ep =  (Employee) pOfM;
                    printWriter.print("true" + "-");
                    printWriter.print(ep.getId() + "-");
                    printWriter.print(ep.getFullName().getFirtName() + "-");
                    printWriter.print(ep.getFullName().getMiddleName() + "-");
                    printWriter.print(ep.getFullName().getSurName() + "-");
                    printWriter.print(ep.getNumberPhone() + "-");
                    printWriter.print(ep.getAdress() + "-");
                    printWriter.print(ep.getEmail() + "-");
                    printWriter.print(ep.getBirday().get(Calendar.DAY_OF_MONTH) + "/" + ep.getBirday().get(Calendar.MONTH) + "/" + ep.getBirday().get(Calendar.YEAR) + "-");
                    printWriter.print(ep.getIdCard() + "-");
                    printWriter.print(ep.getsNKN() + "-");
                    printWriter.print(ep.getSoNgayLamViec() + "-");
                    printWriter.print(ep.getLuongTheoNgay() + "\n");

                }
            }
            printWriter.close();
            if( k == 0){
            System.out.println("ghi file that bai");
            }else{
                System.out.println("thanh cong");
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }


    }

    public void readFile() {
        File file = new File("EMP4.DAT");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {
                Person p;
                var dong = readFile.nextLine().split("-");
                if (dong[0].equalsIgnoreCase("true")) {
                    Employee e = new Employee();
                    e.setId(dong[1]);
                    e.getFullName().setFirtName(dong[2]);
                    e.getFullName().setMiddleName(dong[3]);
                    e.getFullName().setSurName(dong[4]);
                    e.setNumberPhone(dong[5]);
                    e.setAdress(dong[6]);
                    e.setEmail(dong[7]);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date = simpleDateFormat.parse(dong[8]);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        e.setBirday(calendar);
                        e.setIdCard(dong[9]);
                        e.setsNKN(dong[10]);
                        e.setSoNgayLamViec(Float.parseFloat(dong[11]));
                        e.setLuongTheoNgay(Float.parseFloat(dong[12]));
                        p = e;
                        this.listEmPOFMana.add(p);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    Manager m = new Manager();
                    m.setId(dong[1]);
                    m.getFullName().setFirtName(dong[2]);
                    m.getFullName().setMiddleName(dong[3]);
                    m.getFullName().setSurName(dong[4]);
                    m.setNumberPhone(dong[5]);
                    m.setAdress(dong[6]);
                    m.setEmail(dong[7]);
                    var format = "dd/MM/yyyy";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                    try {
                        Date date = simpleDateFormat.parse(dong[8]);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        m.setBirday(calendar);
                        m.setIdCard(dong[9]);
                        m.setsNKN(dong[10]);
                        m.setSoNgayLamViec(Float.parseFloat(dong[11]));
                        m.setLuongTheoNgay(Float.parseFloat(dong[12]));
                        Date date1 = simpleDateFormat.parse(dong[13]);
                        Calendar calendar1 = Calendar.getInstance();
                        m.setNgayBD(calendar1);
                        Date date2 = simpleDateFormat.parse(dong[14]);
                        Calendar calendar2 = Calendar.getInstance();
                        m.setNgayKT(calendar2);
                        p = m;
                        this.listEmPOFMana.add(p);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }

                }

            }
            readFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> timEmployeeTheoName(String name) {
        ArrayList<Employee> listEmployee = new ArrayList<>();
        for (var dOFM : this.listEmPOFMana) {
            if (dOFM instanceof Employee) {
                if (dOFM.getFullName().getFirtName().equalsIgnoreCase(name)) {
                    listEmployee.add((Employee) dOFM);
                }
            }
        }

        return listEmployee;
    }

    public void timEmployeeCoLuongLonHonX(float luong) {
        for (var eOfM : this.listEmPOFMana) {
            if (eOfM instanceof Employee) {

                if (((Employee) eOfM).getLuongTheoNgay() >= luong) {
                    eOfM.outPut();

                }
            }
        }
    }

    public void tinhLuong() {
        for (var eOFM : this.listEmPOFMana) {
            eOFM.tinhLuongThucLinh();
            eOFM.tinhLuongThuong();
            eOFM.tongLuong();
        }
    }

    public void xoaEmployeeVoiMa(String maSV) {
        for (var eOFM : this.listEmPOFMana) {
            if (eOFM instanceof Employee) {
                if (eOFM.getId().equalsIgnoreCase(maSV)) {
                    this.listEmPOFMana.remove(eOFM);
                    System.out.println("remove success");
                } else {
                    System.out.println("remove that bai");
                }
            }

        }
    }

        public void OutPutLuongThuong () {
            System.out.printf("%-10s\t%-10s\n", "SMT", "TienThuong");
            for (var eOFM : this.listEmPOFMana) {
                if (eOFM instanceof Employee) {
                    System.out.printf("%-10s\t%-10f\n", eOFM.getIdCard(), ((Employee) eOFM).getLuongThuong());
                } else {
                    System.out.printf("%-10s\t%-10f\n", eOFM.getIdCard(), ((Manager) eOFM).getLuongThuong());

                }
            }
        }
        public void OutPutBangluong () {
            System.out.printf("%-10s\t%-10s\t%-10s\t%-3s\t%-5s\t%-9s\n", "MNV", "TEN", "LUONGNGAY", "SNLV", "THUONG", "TONGLUONG");
            for (var eOFM : this.listEmPOFMana) {
                if (eOFM instanceof Employee) {
                    Employee e = (Employee) eOFM;
                    System.out.printf("%-10s\t%-10s\t%-10f\t%-3f\t%-5f\t%-9f\n", e.getId(), e.getFullName().getFirtName(), e.getLuongTheoNgay(), e.getSoNgayLamViec(), e.getLuongThuong(), e.getTongLuong());
                }
            }
        }


    }
