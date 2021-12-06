package lesson43.bai4;

import java.util.Comparator;

public class sapXepTheoTenGiamDan implements Comparator<Iphone> {
    @Override
    public int compare(Iphone o1, Iphone o2) {
        return o2.getIphoneName().compareTo(o1.getIphoneName());
    }
}
