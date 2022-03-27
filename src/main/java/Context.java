//Strategy pattern'indeki metotların çalıştırılmasını sağlayan Context sınıfı
public class Context {
    private GirdiStrategy str;
    //Girdi olarak Strategy türünü alarak Context belirlenir
    public Context(GirdiStrategy str) {
        this.str = str;
    }
    //Bulunulan context'in metotları çalıştırılır
    public void executeStrategy(String s) {
        str.girdiAl(s);
    }
    public int retX(){
        return str.getX();
    }
    public String[][] retTumDizi(){
        return str.getTumDizi();
    }
}
