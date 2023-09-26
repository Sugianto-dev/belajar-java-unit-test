package programmer.zaman.now.test.repository;

import programmer.zaman.now.test.data.Person;

// MATERI MOCKING DI TEST
// MATERI VERIFIKASI DI MOCKING

public interface PersonRepository {

    Person selectById(String id);

    // MATERI VERIFIKASI DI MOCKING
    void insert(Person person);

}
