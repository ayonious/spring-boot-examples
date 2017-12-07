package test.learn.spring.Db;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByName(String name);
}