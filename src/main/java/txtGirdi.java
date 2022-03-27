import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Örnek olarak txt dosyasından okuma yapma işlemini gerçekleştiren class
public class txtGirdi implements GirdiStrategy{
    
    private String[][] tumDizi; 
    private int x = 0;

    @Override
    public void   girdiAl(String s) {
        
        String[] dosyaTuru = s.split("\\.");
        if (!"txt".equals(dosyaTuru[1])) { System.out.println("HATA! Lütfen txt dosya türü giriniz!"); System.exit(0); }  // sadece .txt dosya uzantısını okuyor
        
        
        String[]girdiDizi = new String[400];
        try {
        File myObj = new File(s);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        
          String data = myReader.nextLine();
          girdiDizi[x] = data;
          x++;
          
           
        }
        myReader.close();
        } 
        catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
        
        tumDizi = new String[x][4];
        for (int y = 0 ; y < x ; y++) {
            String line = girdiDizi[y];
            String[] bol = line.split(",");
            tumDizi[y][0] = bol[0];
            tumDizi[y][1] = bol[1];
            tumDizi[y][2] = bol[2];
            tumDizi[y][3] = bol[3];
        }
        
    }
    
  
    
    
    @Override
    public String[][] getTumDizi() {
        return tumDizi;
    }
    public void setTumDizi(String[][] tumDizi) {
        this.tumDizi = tumDizi;
    }
    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    
    
    
}
