package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

// MATERI TIMEOUT DI TEST
// MATERI EKSEKUSI TEST SECARA PARALLEL

/*
* Notes!
* > Eksekusi Test secara Default adalah Tidak Paralel atau Dieksekusi secara sequential (1 per 1)
* > Eksekusi paralel adalah Test dieksekusi secara bersamaan tanpa perlu menunggu test diatasnya selesai
* */

@Execution(ExecutionMode.CONCURRENT) // Cara Eksekusi Test Secara Paralel
public class SlowTest {
    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS) // Cara menggunakan timeout, selama 5 detik
    void testSlow1() throws InterruptedException {
//        Thread.sleep(10_000); // Men-sleep proses selama 10 detik
        Thread.sleep(4_000); // Men-sleep proses selama 4 detik
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS) // Cara menggunakan timeout, selama 5 detik
    void testSlow2() throws InterruptedException {
//        Thread.sleep(10_000); // Men-sleep proses selama 10 detik
        Thread.sleep(4_000); // Men-sleep proses selama 4 detik
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS) // Cara menggunakan timeout, selama 5 detik
    void testSlow3() throws InterruptedException {
//        Thread.sleep(10_000); // Men-sleep proses selama 10 detik
        Thread.sleep(4_000); // Men-sleep proses selama 4 detik
    }
}
