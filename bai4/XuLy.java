package lesson43.bai4;

import java.util.ArrayList;
import java.util.Collections;

public class XuLy {
    public static void main(String[] args) {
        ArrayList<Iphone> list = new ArrayList<>();
        Iphone i = new Iphone();
        Iphone i1 = new Iphone();
        Iphone i2 = new Iphone();
        list.add(i);
        list.add(i1);
        list.add(i2);
        try {
            i.inPut();
        } catch (InvalidProductNameException e) {
            e.printStackTrace();
        }
        try {
            i1.inPut();
        } catch (InvalidProductNameException e) {
            e.printStackTrace();
        }
        try {
            i2.inPut();
        } catch (InvalidProductNameException e) {
            e.printStackTrace();
        }
        System.out.println("// xuat thong tin nhan vien");
        Collections.sort(list);
        for(var e: list){
            e.outPut();
        }
        System.out.println("sap xuat theo teo giam dan z - a");
        Collections.sort(list,new sapXepTheoTenGiamDan());
        for(var e: list){
            e.outPut();
        }

    }
}
