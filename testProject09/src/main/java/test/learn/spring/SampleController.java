package test.learn.spring;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.learn.spring.Db.Person;
import test.learn.spring.Db.PersonRepository;
import test.learn.spring.dto.UpdateRequestDto;
import test.learn.spring.exceptions.IllegalInputException;
import test.learn.spring.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("v1/")
public class SampleController {

  @Autowired
  private PersonRepository personRepository;

  @RequestMapping(path = "get/{name}", method = GET)
  public Person get(@PathVariable String name) {
    Person person = personRepository.findByName(name);
    if (person == null) {
      throw new ResourceNotFoundException("Person Does Not Exist");
    }
    return person;
  }

  @RequestMapping(path = "create/{name}/age/{age}", method = PUT)
  public String putting(@PathVariable String name, @PathVariable Long age) {
    if (age <= 0 || age > 50) {
      throw new IllegalInputException("Age should be in the range [1,50]");
    }

    Person person = null;
    try {
      person = new Person();
      person.setAge(age);
      person.setName(name);
      personRepository.save(person);
    } catch (Exception e) {
      return "Error saving: " + e.toString();
    }
    return "UpdateRequestDto succesfully created with id: " + person.getId();
  }

  @RequestMapping(path = "update/{name}", method = POST)
  public String updating(@PathVariable String name, @RequestBody UpdateRequestDto updateRequest) {
    Person person = null;
    person = personRepository.findByName(name);
    person.setName(updateRequest.getName());
    person.setAge(updateRequest.getAge());
    personRepository.save(person);
    return "UpdateRequestDto succesfully updated with id: " + person.getId();
  }

  @RequestMapping(path = "delete/{name}", method = POST)
  public String deletingThatStupidGuy(@PathVariable String name) {
    Person person = null;
    person = personRepository.findByName(name);
    person.setName(name);
    personRepository.delete(person);
    return "Delted succesfully: " + person;
  }
}

