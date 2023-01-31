package nt.RestaurantBillGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner inp=new Scanner(System.in);
    List<Order> orderList=new ArrayList<>();

    public void createOrder(DishService dishService){
        int dishCode=-1;
        while (dishCode!=0){
            System.out.println("Lütfen ürün kodunu giriniz: (ÇIKIŞ:0)");//100,200
            dishCode=inp.nextInt();//code ile ürünü bulmamız gerekiyor?
            if(dishService.findDishByCode(dishCode)!=null) {
                Dish dish = dishService.findDishByCode(dishCode);
                if (dish.getCode() > 0) {
                    System.out.println("Adet giriniz:");
                    int num = inp.nextInt();//2,3
                    Order order = new Order(dish, num);
                    order.setPrice();
                    order.setOrderCode(1000 + this.orderList.size());//1000,1001
                    this.orderList.add(order);
                }
                for (Order order : this.orderList) {
                    System.out.printf("Sipariş kodu:%-5s  lezzet kodu:%-4s adı:%-20s adet:%-3s\n",
                            order.orderCode, order.dish.getCode(), order.dish.getName(), order.numOfDish);
                }
            }
        }
    }
    public void deleteOrder(){
        boolean isValid=true;
        if(this.orderList.isEmpty()){
            System.out.println("Siparişiniz bulunmamaktadır.");
        }else {
            System.out.println("İptal etmek istediğiniz siparişin kodunu giriniz:");
            int code=inp.nextInt();//1000//5000
            for (Order order:this.orderList){
                if (order.orderCode==code){
                    this.orderList.remove(order);
                    System.out.println("Siparişiniz iptal edildi: "+order.dish.toString());
                    isValid=true;
                    break;
                }else {
                    isValid=false;
                }
            }
            if (!isValid){
                System.out.println("Sipariş kodu geçersiz!");
            }
        }
    }

    public void printBill(){
        double totalPrice=0.0;
        System.out.println("              Lezzet Fişiniz             ");
        for (Order order:this.orderList){
            System.out.printf("Lezzet kodu:%-5s  adı:%-20s  adet:%-5s sipariş tutarı: %-5s Lira\n",
                             order.dish.getCode(),order.dish.getName(),order.numOfDish,order.orderPrice);
            totalPrice+=order.orderPrice;
        }
        System.out.println("Toplam tutar:"+totalPrice);
        System.out.println("Afiyet olsun...");
        this.orderList=new ArrayList<>();
    }

}
