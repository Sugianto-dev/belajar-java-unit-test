package programmer.zaman.now.test.generator;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

// MATERI MENGUBAH NAMA TEST

/*
* Notes!
*
* > Bisa buat implementasi sendiri seperti dibawah
* > Atau menggunakan bawaan dari java (Cara cek : ctrl + klik di DisplayNameGenerator)
*
* */
public class SimpleDisplayNameGenerator implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(Class<?> aClass) {
        return "Test " + aClass.getSimpleName();
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> aClass) { // Akan dibahas nanti
        return null;
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> aClass, Method method) {
        return "Test " + aClass.getSimpleName() + "." + method.getName();
    }
}
