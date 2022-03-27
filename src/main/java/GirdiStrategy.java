 // Farklı bir kaynaktan dosya alınması gereken durumda kullanmak üzere oluşturduğumuz Strategy interface
public interface GirdiStrategy {
    public void girdiAl(String s);
    public int getX();
    public String[][] getTumDizi();
}
