package programmer.zaman.now.test;

// MATERI URUTAN EKSEKUSI TEST

import org.junit.jupiter.api.Test;

public class LifecycleTest {

    private String temp;

    @Test
    void testA() {
        // Alasan kenapa di testB temp = null
//        LifecycleTest a = new LifecycleTest();
//        a.testA();
////        a.testB(); // Bukan seperti ini
//
//        LifecycleTest b = new LifecycleTest();
//        b.testB(); // Tapi seperti ini, yaitu dibuat di Object baru, makanya di testB temp = null

        temp = "Eko"; // Tapi di testB temp akan tetap null
    }

    @Test
    void testB() {
        System.out.println(temp); // Hasilnya akan null
    }
}
