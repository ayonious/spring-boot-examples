package test.learn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.learn.spring.Db.Person;
import test.learn.spring.Db.PersonRepository;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("v1/")
public class SampleController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(path = "get/{name}", method = GET)
    public Person get(@PathVariable String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping(path = "create/{name}/age/{age}" , method = POST)
    public String putting(@PathVariable String name, @PathVariable String age) {
        Person person = null;
        try {
            person = new Person();
            person.setAge(age);
            person.setName(name);
            personRepository.save(person);
        } catch (Exception e) {
            return "Error saving: " + e.toString();
        }
        return "Person succesfully created with id: " + person.getId();
    }

    @RequestMapping(path = "update/{id}/name/{name}", method = POST)
    public String updating(@PathVariable Long id, @PathVariable String name) {
        Person person = null;
        try {
            person = personRepository.findByName(name);
            person.setName(name);
            personRepository.save(person);
        } catch (Exception e) {
            return "Error updating: " + e.toString();
        }
        return "Person succesfully updated with id: " + person.getId();
    }

    @RequestMapping(path = "delete/{name}", method = DELETE)
    public String deletingThatStupidGuy(@PathVariable String name) {
        Person person = null;
        try {
            person = personRepository.findByName(name);
            person.setName(name);
            personRepository.save(person);
        } catch (Exception e) {
            return "Error saving: " + e.toString();
        }
        return "Person succesfully saved with id: " + person.getId();
    }
}

