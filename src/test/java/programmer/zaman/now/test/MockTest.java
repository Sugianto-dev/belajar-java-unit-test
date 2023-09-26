package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

// MATERI PENGENALAN MOCKING

public class MockTest {

    @Test
    void testMock() {

        // Membuat Mock Object
        List<String> list = Mockito.mock(List.class); // Object tiruan

//        System.out.println(list.get(0)); // Default hasilnya null
//        System.out.println(list.get(100)); // Default hasilnya null

        // Menambah Behaviour (Kemampuan) ke Mock Object
        Mockito.when(list.get(0)).thenReturn("Eko");
        Mockito.when(list.get(100)).thenReturn("Khannedy");

        // Test Mock
        System.out.println(list.get(0));
//        System.out.println(list.get(0)); // Untuk test Mockito.verify
        System.out.println(list.get(100));

        // Verify Mock
        Mockito.verify(list, Mockito.times(1)).get(0);

    }
}
