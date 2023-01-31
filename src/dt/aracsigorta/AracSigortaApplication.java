package dt.aracsigorta;

import java.util.Scanner;

/*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
       Tarife dönemi:Aralık 2022,Haziran 2022
       1.dönemi :Haziran 2022              2.dönem:Aralık 2022
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750
        Hatalı girişte hesaplama başarısız uyarsı verip tekrar menü gösterilsin.
        Yeni işlem yapılabilmesi için seçenek sunulsun.
 */
public class AracSigortaApplication {
    public static void main(String[] args) {

        start();

    }
    public static void start(){
        boolean isFail;
        Scanner inp=new Scanner(System.in);
        do {
            isFail=false;
            //menü ve tarife dönemi seçimi
            System.out.println("--- Zorunlu Araç Sigorta Primi Hesaplama ---");
            System.out.println("Tarife dönemi seçiniz: ");
            System.out.println("1. Haziran 2022");
            System.out.println("2. Aralık 2022");
            int term= inp.nextInt();
            //tarife dönemi doğru girilmişse işleme devam et değilse uyarı ver uygulamayı yeniden yap
            if (term==1 || term==2){
               //araç oluştur
                Arac arac=new Arac();
                System.out.println("Araç tipini giriniz: ");
                System.out.println("otomobil,kamyon,otobüs,motosiklet");
                arac.type=inp.next();
                arac.prim= arac.countPrim(term);
                //prim 0 dan büyükse hesaplama başarılı, sonucu görüntüle
                //prim=0 veya negatifse hatalı giriş yeni işlem seçeneği
               int select;
               String termName=term==1 ? "Haziran 2022" : "Aralık 2022";
               if(arac.prim>0){
                   System.out.println("Hesaplama başarıyla tamamlandı.");
                   System.out.println("Araç tipi : "+arac.type);
                   System.out.println("Tarife dönemi : "+termName);
                   System.out.println("Aracınızın ilgili dönem sigorta primi: "+arac.prim);
                   System.out.println("Yeni işlem için 1, çıkış için 0 gririniz:");
                   select= inp.nextInt();
                   if(select==1)
                       isFail=true;
                   else
                       isFail=false;
               }else{
                   System.out.println("Hesaplama başarısız, tekrar deneyiniz.");
                   System.out.println("Yeni işlem için 1, çıkış için 0 giriniz:");
                   select= inp.nextInt();
                   if(select==1)
                       isFail=true;
                   else
                       isFail=false;
               }
            }else{
                System.out.println("Hatalı giriş!");
                isFail=true;
            }
        }while(isFail);
        System.out.println("İyi günler dileriz.");

    }
}
