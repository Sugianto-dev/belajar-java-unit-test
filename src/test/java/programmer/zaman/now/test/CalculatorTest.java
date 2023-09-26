package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.opentest4j.TestAbortedException;
import programmer.zaman.now.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*; // Import semua, agar tidak perlu menulis Assertion.nama_method_nya
import static org.junit.jupiter.api.Assumptions.*; // Import semua, agar tidak perlu menulis Assumptions.nama_method_nya

// MATERI MEMBUAT TEST
// MATERI MENGGUNAKAN ASSERTIONS
// MATERI MENGUBAH NAMA TEST
// MATERI MENONAKTIFKAN TEST
// MATERI SEBELUM DAN SETELAH TEST
// MATERI MEMBATALKAN TEST
// MATERI MENGGUNAKAN ASSUMPTIONS

@DisplayNameGeneration(SimpleDisplayNameGenerator.class) // Otomatis membuat display name untuk class dan methodnya
//@DisplayName("Test untuk Calculator class") // @DisplayName
public class CalculatorTest {

    private Calculator calculator = new Calculator(); // Cara 2, agar bisa diakses di method test lain

    // Cara menambahkan Sebelum dan Setelah Semua Test
    /*
    * Notes!
    * > Wajib static
    * */

    @BeforeAll // Sebelum Semua Test
    public static void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll //Setelah Semua Test
    public static void afterAll() {
        System.out.println("After all");
    }

    // Cara menambahkan Sebelum dan Setelah Test
    /*
    * Notes!
    * > Harus public
    * */

    @BeforeEach // Sebelum Test
    public void setUp() {
        System.out.println("Before each");
    }

    @AfterEach // Setelah Test
    public void tearDown() {
        System.out.println("After each");
    }

    @Test // Wajib tambahkan annotation @Test untuk menandakan Unit Test
//    @DisplayName("Test skenario sukses untuk method add(integer, integer)") // @DisplayName
    public void testAddSuccess() {
        // Cara membuat Unit Test
//        Calculator calculator = new Calculator(); // Cara 1

        var result = calculator.add(10, 10);

        // Manual, tanpa Assertions (Tidak direkomendasikan)
//        if (result != 20) {
//            throw new RuntimeException("Test gagal");
//        }

        // Dengan Assertions
        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }

    // Cara Menonaktifkan Test
    /*
    * Notes!
    * > Jika menghapus @Test nya tidak akan ketahuan kalau ada test yang dimatikan
    * > lebih baik menggunakan @Disabled, karna akan ketahuan saat test dijalankan
    * */
    @Test
    @Disabled
    public void testComingSoon() {

    }

    // Cara membatalkan test
    /*
    * Notes!
    * > Untuk menambahkan environtment PROFILE = DEV :
    *   > Edit Configuration -> Tambahkan Environtment Variable
    * */
    @Test
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }

        // unit test untuk DEV
    }

    // Cara menggunakan Assumptions
    /*
    * Notes!
    * > Lebiih disarankan menggunakan Assumptions daripada melakukan secara manual seperti MATERI MEMBATALKAN TEST
    * */
    @Test
    public void testAssumptions() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        // Unit test untuk DEV
    }

}
