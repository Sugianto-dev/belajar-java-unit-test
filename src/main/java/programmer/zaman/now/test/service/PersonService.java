package programmer.zaman.now.test.service;

import programmer.zaman.now.test.data.Person;
import programmer.zaman.now.test.repository.PersonRepository;

import java.util.UUID;

// MATERI MOCKING DI TEST
// MATERI VERIFIKASI DI MOCKING

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(String id) { // Pertanyaan nya bagaimana cara buat Unit Test untuk method get ini
        Person person = personRepository.selectById(id);
        if (person != null) {
            return person;
        } else {
            throw new IllegalArgumentException("Person not found");
        }
    }

    // MATERI VERIFIKASI DI MOCKING
    public Person register(String name) {
        var person = new Person(UUID.randomUUID().toString(), name);
        personRepository.insert(person);
        return person;
    }
}
