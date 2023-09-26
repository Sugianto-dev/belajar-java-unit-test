package programmer.zaman.now.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import programmer.zaman.now.test.resolver.RandomParameterResolver;

// MATERI PEWARISAN DI TEST

@Extensions({ // Untuk mendaftarkan ParameterResolver lebih dari 1
        @ExtendWith(RandomParameterResolver.class) // Registrasi RandomParameterResolver
})
public class AbstractCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
    }
}
