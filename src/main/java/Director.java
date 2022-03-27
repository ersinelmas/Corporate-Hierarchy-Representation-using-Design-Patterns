public class Director implements Calisan{
    private String Ad;
    private String printAd; // Hiyerarşi çıktısını vermesi için özel field
    private String Soyad;
    private boolean isRoot; // Hiyerarşi de kaydırma yapılmayacak olan Root kontrolü
    private int maas;
    private int count = 0;
    public Calisan[] calisanDizi = new Calisan[100];
    public int calisanlarMaas=0;

    public Director(String Ad, String Soyad, int maas, boolean isRoot) {
        this.Ad = Ad;
        this.printAd = Ad;
        this.Soyad = Soyad;
        this.maas = maas;
        this.isRoot = isRoot;
    }
    
  
    // Kişinin altına çalışan ekleme metodu
    @Override
    public void calisanEkle(Calisan clsn){
        calisanDizi[count] = clsn;
        count++;
    }
    
    // Iterator ile dolaşıp kişinin altında çalışanların çıktısının alındığı metot
    @Override
    public void calisanYazdir(){
        System.out.println(getPrintAd()+" "+getSoyad()+" Maas:"+maas);
        IteratorPattern iter = new IteratorPattern(calisanDizi, count);
        while (iter.hasNext()){
            Calisan clsn = iter.next();
            clsn.calisanYazdir();
        }
    };
    // Iterator ile dolaşıp kişinin ve varsa altında çalışanların toplam maliyetinin hesaplandığı metot
    @Override
    public int toplamMaas () {
        calisanlarMaas+= this.getMaas();
        IteratorPattern maasIter = new IteratorPattern(calisanDizi,count);
        while(maasIter.hasNext()){
            Calisan calisan = maasIter.next();           
            calisanlarMaas += calisan.toplamMaas();
        }
        int save = calisanlarMaas;
        calisanlarMaas = 0;
        return save;
        
    }
    
    @Override
    public String getAd() {
        return Ad;
    }
    
    @Override
    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getSoyad() {
        return Soyad;
    }

    public void setSoyad(String Soyad) {
        this.Soyad = Soyad;
    }

    @Override
    public String getPrintAd() {
        return printAd;
    }
    
    @Override
    public void setPrintAd(String printAd) {
        this.printAd = printAd;
    }

    @Override
    public boolean getIsRoot() {
        return isRoot;
    }

    @Override
    public void setIsRoot(boolean isRoot) {
        this.isRoot = isRoot;
    }

    @Override
    public int getMaas() {
        return maas;
    }
    public void setMaas(int maas) {
        this.maas = maas;
    }
 
}