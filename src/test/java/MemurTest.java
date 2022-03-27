/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;import java.util.concurrent.TimeUnit;

/**
 *
 * @author C.Cesur
 */
public class MemurTest {
    Memur m;
    public MemurTest() {
    }
    @BeforeEach
    public void setUp(){
        m = new Memur("Mert", "Günok", 500);
    }
    @AfterEach
    public void tearDown() throws InterruptedException{
        Runtime r = Runtime.getRuntime();
        System.out.println("Garbage collecting işlemi yapılıyor...\n");
        TimeUnit.SECONDS.sleep(4);
        r.gc();
    }
    /**
     * Test of toplamMaas method, of class Memur.
     */
    @Test
    public void testToplamMaas() {
        int expected = 500; //Beklenen değer gerçek değerle aynı girildi
        int actual = m.toplamMaas();
        assertEquals(expected, actual, "Memur / toplamMaas() metodu test edildi.");
        // Memur.java test edildiğinde beklendiği gibi test başarılı sonucu alınıyor.
        System.out.println("\n Test Başarılı! \n");
    }

    
}
