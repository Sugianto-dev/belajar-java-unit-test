package programmer.zaman.now.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

// MATERI TEST BERDASARKAN KONDISI

public class ConditionTest {

    // MATERI TEST BERDASARKAN KONDISI

    // Kondisi Sistem Operasi

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows() {

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows() {

    }

    // Kondisi Versi Java

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    void testEnabledOnJava8() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    void testDisabledOnJava8() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    void testEnabledOnJava11to15() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    void testDisabledOnJava11to15() {

    }

    // Kondisi System Property

    // Untuk mengetahui darimana System Properti didapatkan
    @Test
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledIfSystemProperties({ // Jika Kondisi Lebih Dari 1
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnabledOnJavaVendorOracle() {

    }

    @Test
    @DisabledIfSystemProperties({ // Jika Kondisi Lebih Dari 1
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisabledOnJavaVendorOracle() {

    }
    
    // Kondisi Environment Variable

    /*
     * Notes!
     * > Untuk menambahkan environtment PROFILE = DEV :
     *   > Edit Configuration -> Tambahkan Environtment Variable
     * */
    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledOnProfileDev() {

    }

}
