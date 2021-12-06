package lesson43.bai4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Iphone implements Comparable<Iphone> {
    private String IphoneName;
    private String id;
    private String productName;
    private float cost;
    private int yearOfManufacture;
    private float screenSize;

    public Iphone() {
    }

    public Iphone(String iphoneName, String id, String productName,
                  float cost, int yearOfManufacture, float screenSize) {
        IphoneName = iphoneName;
        this.id = id;
        this.productName = productName;
        this.cost = cost;
        this.yearOfManufacture = yearOfManufacture;
        this.screenSize = screenSize;
    }

    public String getIphoneName() {
        return IphoneName;
    }

    public void setIphoneName(String iphoneName) {
        IphoneName = iphoneName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) throws InvalidProductNameException {
        //Apple,
        //Samsung, Huawei, Xiaomi, Oppo, Vsmart
        var regex ="^(Apple|samsung|huawei|xiaomi|oppo|vsmart)$";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(productName);
        if(matcher.matches()){
            System.out.println("success");
            this.productName = productName;
        }else{
            this.productName = null;
            var exception ="ten hang khong hop le";
            throw new InvalidProductNameException(exception, productName);
        }

    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }
    public void inPut() throws InvalidProductNameException {
        var scan = new Scanner(System.in);
        System.out.println("ten dien thoai: ");
        this.IphoneName = scan.nextLine();
        System.out.println();
        System.out.println("id: ");
        this.id = scan.nextLine();
        System.out.println("ten hang : ");
        var tenHang = scan.nextLine();
        setProductName(tenHang);
        System.out.println("gia ban:");
        this.cost = Float.parseFloat(scan.nextLine());
        System.out.println("man hinh: ");
        this.screenSize = Float.parseFloat(scan.nextLine());

    }
    public void  outPut(){
        System.out.printf("%-12s\t%-12s\t%-12s%-12f\n",this.IphoneName, this.id,
                this.productName, this.cost);
    }

    @Override
    public int compareTo(Iphone other) {
        return this.id.compareTo(other.id);
    }
}
 class InvalidProductNameException extends Exception{
    private String invaliProductName;

     public InvalidProductNameException() {
     }

     public InvalidProductNameException(String message, String invaliProductName) {
         super(message);
         this.invaliProductName = invaliProductName;
     }

     public String getInvaliProductName() {
         return invaliProductName;
     }
 }
