package repeat.LoginpageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//5-User objesiyle ilgili işlemler
public class UserService {
    //6-kullanıcı bilgilerini tutmak için list oluşturalım.
    List<User> userList=new ArrayList<>();
    //tüm metodlarda kullanıcıdan bilgi almak için Scanner objesi oluştur.
    Scanner inp=new Scanner(System.in);

    //7-username veya email ile kayıtlı userı getirme
    private User getUser(String userNameOrEmail){
        for(User user:userList){
            if(user.getUsername().equals(userNameOrEmail)){
                return user;
            }else if(user.getEmail().equals(userNameOrEmail)){
                return user;
            }
        }
       return null;
    }
    //8-email validation
    private static boolean validateEmail(String email){
        boolean isValid;
        boolean isExistsSpace=email.contains(" ");
        boolean isContainsAt=email.contains("@");
        if(isExistsSpace){
            System.out.println("Email boşluk içeremez!");
            isValid=false;
        }else if(!isContainsAt){
            System.out.println("Email @ sembolünü içermelidir.");
            isValid=false;
        }else{//asd@gmail@@com->[asd,gmail,com,]
            String firstPart=email.split("@")[0];//asd@mail.com->["asd","mail.com"]
            String secondPart=email.split("@")[1];//gmail.com

           boolean valid= firstPart.replaceAll("[a-zA-Z0-9_.-]","").isEmpty();
           boolean checkStart=valid && firstPart.length()>0;

           boolean checkEnd=secondPart.equals("gmail.com") ||
                            secondPart.equals("hotmail.com") ||
                            secondPart.equals("yahoo.com");
           if(!checkStart) {
               System.out.println("Mailin kullanıcı adı bölümü en az bir karakter içermelidir ve " +
                       "sadece küçük-büyük harf,rakam veya -._ içerebilir.");
           }
           if (!checkEnd){
               System.out.println("email gmail.com, hotmail.com veya yahoo.com ile bitmelidir!");
           }
           isValid=checkStart && checkEnd;
        }
        if(!isValid){
            System.out.println("Tekrar deneyiniz.");
        }
        return isValid;
    }
    //9-password validation
    private static boolean validatePassword(String password){//ASdf12*-
        boolean isValid;
        boolean isExistsSpace=password.contains(" ");
        boolean isLengthGtSix=password.length()>=6;
        boolean isExistUpperLetter=password.replaceAll("[^A-Z]","").length()>0;//AS
        boolean isExistLowerLetter=password.replaceAll("[^a-z]","").length()>0;//df
        boolean isExistsDigit=password.replaceAll("[\\D]","").length()>0;//12
        boolean isExistsSymbol=password.replaceAll("[\\P{Punct}]","").length()>0;
        if(isExistsSpace){
            System.out.println("Şifre boşluk içeremez.");
        }else if(!isLengthGtSix){
            System.out.println("Şifre en az 6 karakter içermelidir.");
        } else if (!isExistUpperLetter) {
            System.out.println("Şifre en az 1 tane büyük harf içermelidir.");
        } else if (!isExistLowerLetter) {
            System.out.println("Şifre en az 1 tane küçük harf içermelidir.");
        } else if(!isExistsDigit){
            System.out.println("Şifre en az 1 tane rakam içermelidir.");
        } else if (!isExistsSymbol) {
            System.out.println("Şifre en az 1 tane sembol içermelidir.");
        }
        isValid=!isExistsSpace && isLengthGtSix && isExistUpperLetter && isExistLowerLetter && isExistsDigit && isExistsSymbol;
        if (!isValid){
            System.out.println("Geçersiz şifre, tekrar deneyiniz.");
        }
        return isValid;
    }

    public void register(){
        System.out.println("Ad-Soyad: ");
        String name=inp.nextLine();
//10-username unique/eşsiz olmalı
        String username=getUserName();
//11-email unique, geçerli olmalı
        String email=getEmail();
//12-password :geçerli olmalı
        String password=getPassword();
//13-user objesi oluşturalım
        User user=new User(name,username,email,password);
//14-user ı listeye kaydedelim.
        this.userList.add(user);
        System.out.println("Tebrikler işleminiz başarıyla gerçekleştirildi.");
        System.out.println("Kullanıcı adı (veya email) ve şifrenizle sisteme giriş yapabilirsiniz.");
    }

//10-a-kullanıcıdan userName alma
     private String getUserName(){
        String username;
        boolean existsUsername;
        do {
            System.out.println("Kullanıcı adı giriniz:");
            username = inp.nextLine();//bu username daha önce kullanılmış mı?
            existsUsername=getUser(username)!=null;
            if (existsUsername){
                System.out.println("Bu username kullanılmış,farklı bir username deneyiniz.");
            }
        }while(existsUsername);
        return username;
     }
//11-a-kullanıcıdan email alma
     private String getEmail(){
        String email;
        boolean isValid;
        boolean existsEmail;
        do {
            System.out.println("Email giriniz:");
            email=inp.nextLine();//email geçerli mi :validation
            isValid=validateEmail(email);//geçerli ise unique mi
            existsEmail=getUser(email)!=null;
            if (existsEmail){
                System.out.println("Bu email zaten kayıtlı, farklı bir email deneyiniz.");
                isValid=false;
            }
        }while(!isValid);
        return email;
     }
//12-a-password oluşturma
     private String getPassword(){
        String passw;
        boolean isValidPass;
        do {
            System.out.println("Şifrenizi giriniz:");
            passw=inp.nextLine();//geçerli mi
            isValidPass=validatePassword(passw);
        }while (!isValidPass);
        return passw;
     }

//15-email veya username ile giriş yapma
     public void login(){
         System.out.println("Kullanıcı adı veya email giriniz:");
         String userNameOrEmail=inp.nextLine();
         //16-girilen değer ile user ı bulma
         if (getUser(userNameOrEmail)!=null) {
             User user = getUser(userNameOrEmail);
             //17-user bulundu ise şifre kontrolü
             boolean isWrong=true;
             while (isWrong){
                 System.out.println("Şifrenizi girinz:");
                 String password=inp.nextLine();
                 //girilen şifre bulduğumuz userın şifresi ile mi aynı mı
                 if (user.getPassword().equals(password)){
                     System.out.println("Sisteme giriş yaptınız.");
                     isWrong=false;
                 }else {
                     System.out.println("Şifreniz yanlış, tekrar deneyiniz.");
                 }
             }

         }else{
             System.out.println("Sistemde kayıtlı kullanıcı adı veya email bulunamadı.");
             System.out.println("Üyeyseniz bilgilerinizi kontrol ederek tekrar deneyiniz, üye değilseniz lütfen üye olunuz.");
         }
     }

}
