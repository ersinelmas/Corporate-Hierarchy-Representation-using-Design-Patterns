public interface Calisan {
    
    // Director ve Memur kişilerinin ortak olarak çalıştırdığı metotlar
    public void calisanYazdir();
    public int toplamMaas();
    public void calisanEkle(Calisan clsn);
    public int getMaas();
    public String getAd();
    public void setAd(String Ad);
    public String getPrintAd();
    public void setPrintAd(String Ad);
    public boolean getIsRoot();
    public void setIsRoot(boolean isRoot);
 
}