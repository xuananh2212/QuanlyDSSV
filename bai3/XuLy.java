package lesson43.bai3;

import java.util.Scanner;

public class XuLy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Teacher t = new Teacher();
        try {
            t.inPut(scan);
        } catch (InvalidWageException e) {
            e.printStackTrace();
        }
        System.out.printf("%-12s\t%-10s\t%-12s\n", "ID","NAME","Wage");
        t.outPut();
    }
}
