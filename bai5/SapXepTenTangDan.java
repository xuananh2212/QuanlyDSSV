package lesson43.bai5;

import java.util.Calendar;
import java.util.Comparator;

public class SapXepTenTangDan implements Comparator<Employee> {


    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getFullName().getFirtName().compareTo(o2.getFullName().getFirtName());
    }
}
 class SapXepTenGiamDan implements Comparator<Employee>{

     @Override
     public int compare(Employee o1, Employee o2) {
         return o2.getFullName().getFirtName().compareTo(o1.getFullName().getFirtName());
     }
 }
 class SapXepMucLuongTangDan implements Comparator<Employee>{

     @Override
     public int compare(Employee o1, Employee o2) {
         return (int)(o1.getLuongTheoNgay()- o2.getLuongTheoNgay());
     }
 }
class SapXepMucLuongGiamDan implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int)(o2.getLuongTheoNgay()- o1.getLuongTheoNgay());
    }
}
class SapXepSoNamKinhNghiemTangDan implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getsNKN().compareTo(o2.getsNKN());
    }
}
class SapXepSoNamKinhNghiemGiamDan implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getsNKN().compareTo(o1.getsNKN());
    }
}
class SapXepTuoiTreDenTuoiGia implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getBirday().get(Calendar.YEAR) - o2.getBirday().get(Calendar.YEAR);
    }
}
class SapXepTuoiGiaDenTuoiTre implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.getBirday().get(Calendar.YEAR)-o1.getBirday().get(Calendar.YEAR);
    }
}
class SapXepTheoTongLuongLinh implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int)(o2.getTongLuong() - o1.getTongLuong());
    }
}

