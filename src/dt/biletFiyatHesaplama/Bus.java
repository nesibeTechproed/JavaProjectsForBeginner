package dt.biletFiyatHesaplama;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    public String numberPlate;//34 IST 78

    public List<String> seats=new ArrayList<>();//1-32

    public Bus(String numberPlate, List<String> seats) {
        this.numberPlate = numberPlate;
        this.seats=seats;
    }
}
