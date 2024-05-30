package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {
    //    private static List<Event> events = new ArrayList<>();
    //only exists during lifetime of application, lose when restart with static will learn database soon

    @Autowired //filed will be auto-wired up with an actual object
    private EventRepository eventRepository; //use instance of an interface from EventRepository data
    // findAll, save, findById methods  we can use with CrudREpository

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }


    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                         Errors errors, Model model) {
//        EventData.add(new Event(eventName, eventDescription));
//        EventData.add(new Event(eventName, eventDescription));
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
//            model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id); //.delete is different takes actual object this takes primary key for object so be careful which you use
            }
        }

        return "redirect:/events";
    }

}
//Ready to test - replaced all instances of EventData class with EventRespository = interface that allows us to interact with MySQL database
