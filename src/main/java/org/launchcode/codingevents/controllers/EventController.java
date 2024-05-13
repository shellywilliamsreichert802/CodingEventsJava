package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

//    private static List<Event> events = new ArrayList<>();
    //only exists during lifetime of application, lose when restart with static will learn database soon

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");

        //use new static field to display events
        model.addAttribute("events", EventData.getAll());


//        List<String> events = new ArrayList<>();
//        events.add("Code With Pride");
//        events.add("Strange Loop");
//        events.add("Apple WWDC");
//        events.add("SpringOne Platform");
//        model.addAttribute("events", events);

        return "events/index";
    }

    // lives at /events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
//        model.addAttribute("events", EventData.getAll());
        return "events/create";
    }


    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
//        EventData.add(new Event(eventName, eventDescription));
//        EventData.add(new Event(eventName, eventDescription));
        EventData.add(newEvent);
        return "redirect:/events";
    }

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:/events";

    }
}
