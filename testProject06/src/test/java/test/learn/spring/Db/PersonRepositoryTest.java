package test.learn.spring.Db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.NonUniqueResultException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void shouldTest() {
        Person person = new Person();
        person.setAge("10");
        person.setName("me");

        personRepository.save(person);

        Person queryPerson = personRepository.findByName("me");
        assertThat(queryPerson.getAge(), is("10"));
    }
}
