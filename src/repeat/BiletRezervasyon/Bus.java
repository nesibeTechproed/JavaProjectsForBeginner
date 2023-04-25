package repeat.BiletRezervasyon;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    //2-plaka,koltuk numaraları
    public  String numberPlate;
    public List<String> seats=new ArrayList<>();
    //3-otobüsü oluşturduğumuzda koltuk noları olsun ve plaka set edilsin
    public Bus(String numberPlate){
        this.numberPlate=numberPlate;
        for(int i=1;i<=32;i++){
            this.seats.add(i+"");//String.valueOf()
        }
    }


}
