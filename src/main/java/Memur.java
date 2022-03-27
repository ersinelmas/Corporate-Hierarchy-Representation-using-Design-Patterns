public class Memur implements Calisan{
    private String Ad;
    private String printAd;
    private String Soyad;
    private boolean isRoot = false; // Hiyerarşi de kaydırma yapılmayacak olan Root kontrolü
    private int maas;
    private int count = 0;

    public Memur(String Ad, String Soyad, int maas) {
        this.Ad = Ad;
        this.printAd = Ad;
        this.Soyad = Soyad;
        this.maas = maas;
    }

    Memur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void calisanYazdir() {
        System.out.println("    "+getPrintAd()+" "+getSoyad()+" Maas:"+maas);
    }
    // Memur olduğu için sadece kendi maaşını yazdırır
    @Override
    public int toplamMaas() {
       return getMaas();
    }
    //Memurun çalışanı olmadığı için ekleme metodu işlem yapmaz
    @Override
    public void calisanEkle(Calisan clsn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
