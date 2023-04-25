package repeat.MiniBookStore;

import java.util.Scanner;

/*
Proje: Mini Book Store
        Online bir kitap market için ürün yönetim uygulaması yapınız.
        Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı.

        Kitap özellikleri: id, isim, birim fiyat, stok, yazar adı, yayınevi,isbn no
        Defter özellikleri: id, isim, birim fiyat, stok, marka, yaprak sayısı,ürün kodu

        Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
        Kullanıcı kategoriye göre ürün ekleyebilmeli,ürün mevcutsa uyarı verilmeli
        Kullanıcı ürünleri benzersiz numaralarına(id) göre silebilmeli.
        Kullanıcı ürünleri marka(defter)  veya yayınevine(kitap) göre filtreleyip listeleyebilmeli.

        NotebookService:ÖDEV
        updateProduct:opsitonel ödev

        */
public class MiniBookStore {
    public static void main(String[] args) {
        enter();
    }
    //1-product,book,notebook
    public static void enter(){
        Scanner inp=new Scanner(System.in);
        int select;
        System.out.println("---  Mini Book Store  ---");
        do {
            System.out.println("Ürün Yönetim Paneli");
            System.out.println("1-Kitaplar");
            System.out.println("2-Defterler");
            System.out.println("0-Çıkış");
            System.out.println("Seçiminiz:");
            select= inp.nextInt();
            inp.nextLine();
            ProductService service;
            //BookService bookService=new BookService();
            //NotebookService notebookService=new NotebookService();
            switch (select){
                case 1:
                    service=new BookService();
                    service.processMenu();
                   // bookService.processMenu();
                    break;
                case 2:
                    service=new NotebookService();
                    service.processMenu();
                    //notebookService.processMenu();
                    break;
                case 0:
                    System.out.println("İyi günler..");
                    break;
                default:
                    System.out.println("Hatalı giriş!!!");
                    break;
            }

        }while (select!=0);


    }

}
