/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


/**
 *
 * @author C.Cesur
 */
public class DirectorTest {
    Calisan d1;
    public DirectorTest() {
    }
    @BeforeEach // Test yapmadan önce örnek değerler girildi
    public void setUp(){
        d1 = new Director("Ali","Yılmaz", 5000, true);
        Calisan m1 = new Memur("Ahmet","Cesur", 500);
        Calisan m2 = new Memur("Berk","Can", 600);
        Calisan d2 = new Director("Mert","Yılmaz", 3000, false);
        d1.calisanEkle(d2);
        d1.calisanEkle(m1);
        d2.calisanEkle(m2);
    }
    @AfterEach // Test sonunda garbage collecting yapıldı
    public void tearDown() throws InterruptedException{
        Runtime r = Runtime.getRuntime();
        System.out.println("Garbage collecting işlemi yapılıyor...\n");
        TimeUnit.SECONDS.sleep(4);
        r.gc();
    }
    /**
     * Test of toplamMaas method, of class Director.
     */
    @Test
    public void testToplamMaas() { // Director toplam maas test edildi
        
        int expected = 9200; // Beklenen değer gerçek değerden farklı girildi
        int actual = d1.toplamMaas();
        assertEquals(expected, actual,"Director / toplamMaas() methodu test edildi.");
        // Director.java test edildiğinde beklendiği gibi test failed sonucu alınıyor.
        System.out.println("\n Test Başarılı! \n"); // Fail olduğu için output yok
    }

}
