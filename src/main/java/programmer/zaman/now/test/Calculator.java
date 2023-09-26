package programmer.zaman.now.test;

// MATERI MEMBUAT TEST
// MATERI MENGGUNAKAN ASSERTIONS
public class Calculator {

    public Integer divide(Integer first, Integer second) {
        if (second == 0) {
            throw new IllegalArgumentException("Can not divide by zero");
        } else {
            return first / second;
        }
    }

    public Integer add(Integer first, Integer second) {
        return first + second;
//        return first - second;
    }

}
