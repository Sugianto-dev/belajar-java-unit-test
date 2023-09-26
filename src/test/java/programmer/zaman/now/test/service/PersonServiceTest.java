package programmer.zaman.now.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import programmer.zaman.now.test.data.Person;
import programmer.zaman.now.test.repository.PersonRepository;

// MATERI MOCKING DI TEST
// MATERI VERIFIKASI DI MOCKING

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // menambah behavior ke mock object
        Mockito.when(personRepository.selectById("eko"))
                .thenReturn(new Person("eko", "eko"));

        var person = personService.get("eko");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("eko", person.getId());
        Assertions.assertEquals("eko", person.getName());
    }

    // MATERI VERIFIKASI DI MOCKING

    /*
    * Notes!
    * > Seperti tidak ada yang salah dengan test dibawah
    * > Akan tetapi ketika di PersonService.java dihapus personRepository.insert(person) nya, test akan tetap sukses, itu yang jadi masalah
    * > Maka harus hati hati ketika membuat Mocking object apalagi methodnya void
    * > Disarankan selalu melakukan verifikasi ketika menggunakan mocking object
    * */
    @Test
    void testRegisterSuccess() {
        var person = personService.register("Eko");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Eko", person.getName());
        Assertions.assertNotNull(person.getId());

        // Cara Mengatasi Masalah Diatas
        // Dengan melakukan verifikasi
        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Eko"));
    }
}
