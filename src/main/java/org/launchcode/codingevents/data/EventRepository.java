package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
//manage class and create instance for us, flags Springboot should create event repositories then inject them when code ask ie. Autowired
public interface EventRepository extends CrudRepository<Event, Integer> { //have to have concrete class that implements interface, interface is a blueprint any class that implements this must follow rules, provide the following fields
}
//public class MyRepository implements EventRepository {}
//CrudRespository allows code to store and retrieve Event instances
//google 'CrudRepository javadoc'