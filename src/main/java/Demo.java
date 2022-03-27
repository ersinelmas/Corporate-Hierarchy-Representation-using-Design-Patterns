
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        
        
        // Farklı dosya türlerini açmak için değiştirilmesi gereken bölüm
        int x;
        String[][] tumDizi;
        GirdiStrategy txtgirdi = new txtGirdi();
        Context ctx = new Context(txtgirdi);
        ctx.executeStrategy("girdi.txt");
        tumDizi = ctx.retTumDizi();
        x = ctx.retX();   
        
     

        // tumEkip dizi sayacı
        int ekipNo = 0;
        //Ekipteki kişilerin gerekli işlemler yapıldıktan sonra eklendiği dizi
        Calisan[] tumEkip = new Calisan[x];
        
        for(String[] s : tumDizi) {
            if ("D".equals(s[0])) { // Director ise girer
                if("Root".equals(s[3])) { // Root ise girer
                    String[] adsoyad = s[1].split(" ");
                    Calisan root = new Director(adsoyad[0],adsoyad[1], Integer.parseInt(s[2]), true); // Director(root) nesnesi oluşturuldu
                    root.setPrintAd("" + root.getAd());
                    tumEkip[ekipNo] = root;
                    ekipNo++;
                }
                else{ // Direktör ve root değilise girer
                    String hier = "";
                    String[] adsoyad = s[1].split(" ");
                    Calisan dir = new Director(adsoyad[0],adsoyad[1], Integer.parseInt(s[2]), false);// Director nesnesi oluşturuldu
                    for (int a = 0; a<ekipNo; a++) { // Hiyerarşik üstünü aramak
                        if (tumEkip[a].getAd().equals(s[3])){
                            if (tumEkip[a].getIsRoot() == false) {hier = "   ";} 
                            
                            tumEkip[a].calisanEkle(dir);
                            break;
                        }
                    }
                    dir.setPrintAd("    " + hier + dir.getAd());  // Hiyerarşik çıktı için
                    
                    tumEkip[ekipNo] = dir;
                    ekipNo++;
                
                }
                
            }
            else { // Memursa girer
                String hier = "";
                String[] adsoyad = s[1].split(" ");
                Calisan mem = new Memur(adsoyad[0],adsoyad[1], Integer.parseInt(s[2])); // Memur nesnesi oluşturuldu
                for (int a = 0; a<ekipNo; a++) { // Hiyerarşik üstünü aramak
                        
                        if (tumEkip[a].getAd().equals(s[3])){
                            if (tumEkip[a].getIsRoot() == false) {hier = "   ";}
                            tumEkip[a].calisanEkle(mem);
                            break;
                        }
                }
                mem.setPrintAd("    " + hier + mem.getAd());  // Hiyerarşik çıktı için
                tumEkip[ekipNo] = mem;
                ekipNo++;
                
            }
    
        }
        
        System.out.println("\n\n--------------------------------------");
        System.out.println("İlk çıktı 1 / Mustafa Türksever Maliyeti");
        System.out.println("--------------------------------------");
        System.out.println(tumEkip[0].toplamMaas()); 
        System.out.println("\n--------------------------------------");
        System.out.println("İlk çıktı 2 / Mustafa Türksever Altında Çalışanlar");
        System.out.println("--------------------------------------");
        tumEkip[0].calisanYazdir();
        System.out.println("\n\n\n");
        System.out.println("\n--------------------------------------");
        System.out.println("İkinci çıktı 1 / Oğuz Demir Maliyeti");
        System.out.println("--------------------------------------");
        System.out.println(tumEkip[5].toplamMaas()); 
        System.out.println("\n--------------------------------------");
        System.out.println("İkinci çıktı 2 / Oğuz Demir Altında Çalışanlar");
        System.out.println("--------------------------------------");
        tumEkip[5].calisanYazdir();
        System.out.println("\n\n\n");
        System.out.println("\n--------------------------------------");
        System.out.println("Üçüncü çıktı / Ahmet Egeli Maliyeti");
        System.out.println("--------------------------------------");
        System.out.println(tumEkip[7].toplamMaas()); 
        System.out.println("\n\n\n");
        
        
    } 
}