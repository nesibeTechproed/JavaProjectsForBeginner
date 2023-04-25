package repeat.MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-b:Notebookla ilgili işlemler
public class NotebookService implements ProductService{
    Scanner inp=new Scanner(System.in);
    //3-Notebooklari saklamak icin list olusturdum
    List<Notebook> notebooks= new ArrayList<>();
    //4-b:baslangicta sisteme mevcut defterler kaydediyoruz
    public NotebookService(){
        Notebook notebook1=new Notebook("Cizgili","50",25,"Gipta",55,111);
        Notebook notebook2=new Notebook("Kareli","55",35,"Mopak",60,222);
        Notebook notebook3=new Notebook("Hatira defteri","120",12,"Gipta",70,333);
        this.notebooks.add(notebook1);
        this.notebooks.add(notebook2);
        this.notebooks.add(notebook3);
    }
    @Override
    public void processMenu() {
        int choice;
        do {
            System.out.println("----------------------------");
            System.out.println("1-Defterleri listele");
            System.out.println("2-Defter ekle");
            System.out.println("3-Defter sil");
            System.out.println("4-Markasina  göre filtrele");
            System.out.println("0-Geri Dön");
            System.out.println("Seçiminiz:");
            choice=inp.nextInt();
            inp.nextLine();
            switch (choice){
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Markasi :");
                    String publisher=inp.nextLine();
                    filterProducts(publisher);
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Hatalı giriş!!");
                    break;
            }
        }while (choice!=0);
    }
    //6-a:Defterleri formatla yazdiriyorum
    @Override
    public void listProduct() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                "ID","Defter Adı","Birim Fiyat","Stok","Brand","Sheet","Codu");
        System.out.println("--------------------------------------------------------------------------");
        this.notebooks.forEach(notebook->System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                notebook.getId(),notebook.getName(),notebook.getPrice(),notebook.getStock(),notebook.getBrand(),notebook.getSheet(),notebook.getCode()));
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
    }
    //7-b:yeni defter ekle
    @Override
    public void addProduct() {
        System.out.println("Urun kodu");
        int code=inp.nextInt();
        boolean isExist= false;
        for (Notebook notebook:this.notebooks){
            if(notebook.getCode()==code){
                System.out.println("Bu defter sistemde zaten kayıtlı, lütfen ürün güncelleme yapınız.");
                isExist=true;
            }
        }if(!isExist){
            inp.nextLine();
            System.out.println("Defter adı:");
            String name=inp.nextLine();
            System.out.println("Birim Fiyatı: ");
            String price=inp.nextLine();
            System.out.println("Stok :");
            int stock=inp.nextInt();
            inp.nextLine();
            System.out.println("Brand: ");
            String brand=inp.nextLine();
            System.out.println("Yaprak sayisi :");
            int sheet=inp.nextInt();
            inp.nextLine();
            Notebook newNotebook=new Notebook(name,price,stock,brand,sheet,code);
            this.notebooks.add(newNotebook);
        }listProduct();
    }
    //kullanicidan code ile urun bulalim ve listeden silelim
    @Override
    public void deleteProduct() {
        boolean isExist=true;
        System.out.println("Defter kodu");
        int code=inp.nextInt();
        for(Notebook notebook:this.notebooks){
            if(notebook.getCode()==code){
                isExist=true;
                this.notebooks.remove(notebook);
                System.out.println("Urun silindi."+notebook.getName());
                break;
            }else{
                isExist=false;
            }
        }if(!isExist){
            System.out.println("Urun bulunamadi");
        }
    }
    //defterleri markasina gore filtrele
    @Override
    public void filterProducts(String filter) {
        int counter=0;
        for (Notebook notebook:this.notebooks){
            if(notebook.getBrand().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                        notebook.getId(), notebook.getName(),notebook.getPrice(),notebook.getStock(),notebook.getBrand(),notebook.getSheet(),notebook.getCode());
                counter++;
            }
        }
        if(counter==0){
            System.out.println("Ürün bulunamadı.");
        }
    }
}