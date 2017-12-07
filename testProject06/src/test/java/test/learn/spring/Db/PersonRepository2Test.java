package test.learn.spring.Db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepository2Test {

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
