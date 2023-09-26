package programmer.zaman.now.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

// MATERI TEST DI DALAM TEST

@DisplayName("A Queue")
public class QueueTest { // Outer Class

    private Queue<String> queue;

    @Nested // Untuk menandakan bahwa inner class ini adalah class Test
    @DisplayName("when new")
    public class whenNew { // Inner Class

        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        void offerNewData() {
            queue.offer("Eko");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer 2 data, size must be 2")
        void offerMoreData() {
            queue.offer("Eko");
            queue.offer("Kurniawan");
            Assertions.assertEquals(2, queue.size());
        }
    }

}
