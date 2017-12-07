package test.learn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.learn.spring.Db.Person;
import test.learn.spring.Db.PersonDao;

@RestController
public class SampleController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("get/{name}")
    public Person get(@PathVariable String name){
        return personDao.findByName(name);
    }

    @RequestMapping("create/{name}/age/{age}")
    public String putting(@PathVariable String name, @PathVariable String age){
        Person person = null;
        try {
            person = new Person();
            person.setAge(age);
            person.setName(name);
            personDao.save(person);
        }
        catch (Exception e) {
            return "Error saving: " + e.toString();
        }
        return "Person succesfully created with id: " + person.getId();
    }

    @RequestMapping("update/{id}/name/{name}")
    public String updating(@PathVariable Long id, @PathVariable String name){
        Person person = null;
        try {
            person = personDao.findByName(name);
            person.setName(name);
            personDao.save(person);
        }
        catch (Exception e) {
            return "Error updating: " + e.toString();
        }
        return "Person succesfully updated with id: " + person.getId();
    }

    @RequestMapping("delete/{name}")
    public String deletingThatStupidGuy(@PathVariable String name){
        Person person = null;
        try {
            person = personDao.findByName(name);
            person.setName(name);
            personDao.save(person);
        }
        catch (Exception e) {
            return "Error saving: " + e.toString();
        }
        return "Person succesfully saved with id: " + person.getId();
    }
}
