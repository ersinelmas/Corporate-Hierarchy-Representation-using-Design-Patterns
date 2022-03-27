public class IteratorPattern {

    public Calisan[] calisanDizi; // Çalışanların tümünün bulunacağı dizi
    public int sira = 0; // Çalışan dizi de gezinme sırası
    public int count; // Çalışan dizi eleman sayısı
    
    //constructor
    public IteratorPattern(Calisan[] calisanDizi, int count) {
        this.calisanDizi = calisanDizi;
        this.count = count;
    }

    // sıradakini kontrol eden metot
    public boolean hasNext() {
        if(sira < count){
            return true;
        }
        else{
            return false;
        }
    }
    
    // sıradakini döndüren metot
    public Calisan next() {
        Calisan calisan = calisanDizi[sira];
        sira++;
        return calisan;
    }
    // çalışanların tutulduğu diziyi döndüren metot
    public Calisan[] getCalisanDizi() {
        return calisanDizi;
    }

    public void setCalisanDizi(Calisan[] calisanDizi) {
        this.calisanDizi = calisanDizi;
    }

    public int getSira() {
        return sira;
    }

    public void setSira(int sira) {
        this.sira = sira;
    }

}
