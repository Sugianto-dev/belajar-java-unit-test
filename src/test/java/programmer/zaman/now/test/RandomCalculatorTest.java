package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import programmer.zaman.now.test.resolver.RandomParameterResolver;

import java.util.List;
import java.util.Random;

// MATERI DEPENDENCY INJECTION DI TEST
// MATERI PEWARISAN DI TEST
// MATERI TEST BERULANG
// MATERI TEST DENGAN PARAMETER

// Cara menggunakan RandomParameterResolver (Custom Parameter Resolver)

/*
* Notes!
* > @Extensions({...}) dipindahkan ke parent class (AbstractCalculatorTest.java)
* > Karena Materi PEWARISAN DI TEST
* */
//@Extensions({ // Untuk mendaftarkan ParameterResolver lebih dari 1
//        @ExtendWith(RandomParameterResolver.class) // Registrasi RandomParameterResolver
//})
public class RandomCalculatorTest extends AbstractCalculatorTest{ // Cara Pewarisan di Test

//    private Calculator calculator = new Calculator(); // Dipindahkan ke parent class

    @Test
    void testRandom(TestInfo info, Random random) { // Cara inject data Random & TestInfo
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    // MATERI TEST BERULANG

    // Cara Test Berulang
    @DisplayName("Test random calculator")
    @RepeatedTest( // Tinggal ubah dari @Test ke @RepeatedTest
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    void testRandomRepeat(TestInfo info, Random random) { // Cara inject data Random & TestInfo
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    // Informasi Perulangan
    @DisplayName("Test random calculator")
    @RepeatedTest( // Tinggal ubah dari @Test ke @RepeatedTest
            value = 10,
            name = "{displayName}"
    )
    void testRandomRepeatInfo(TestInfo info, Random random, RepetitionInfo repetitionInfo) { // Tambahkan inject RepetitionInfo
        System.out.println(info.getDisplayName() + " ke " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);
    }

    // MATERI TEST DENGAN PARAMETER

    // @ValueSource
    @DisplayName("Test calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 45, 34, 56})
    void testWithParameter(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

    // @MethodSource
    public static List<Integer> parameterSource() { // Harus static
        return List.of(1, 2, 34, 56, 33, 65, 67, 35);
    }

    @DisplayName("Test calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource({"parameterSource"})
    void testWithMethodSource(int value) {
        var expected = value + value;
        var result = calculator.add(value, value);

        Assertions.assertEquals(expected, result);
    }

}
