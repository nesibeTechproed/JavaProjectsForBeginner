package repeat.RestaurantBillGenerator;
//3
public class Dish {
    //yiyeceklerin fieldlarına okunsun ancak değiştirilemesin
    private int code;
    private String name;
    private double price;

    //yiyecek oluşturulurken özelllikler set edilsin
    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

//dish objesini yazdırmak için
    @Override
    public String toString() {
        return  "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
