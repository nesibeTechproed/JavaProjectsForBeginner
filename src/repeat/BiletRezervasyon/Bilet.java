package repeat.BiletRezervasyon;

public class Bilet {
    //mesafe,yolculuk tipi,fiyat,koltuk no

    public double distance;
    public int typeNo;
    public double price;
    public int seatNo;

    //5-bileti yazdıralım
    public void printBilet(Bus bus){
        System.out.println("Toplam tutar: "+this.price);
        System.out.println("---Bilet Detayı ---");
        System.out.println("Otobüs plaka : "+bus.numberPlate);
        System.out.println("Mesafe       :"+this.distance);
        System.out.println("Yolculuk tipi:"+(this.typeNo==1 ? "Tek Yön" : "Gidiş-Dönüş"));
        System.out.println("Koltuk no     :"+this.seatNo);
        System.out.println("Keyifli yolculuklar dileriz...");
    }
}
