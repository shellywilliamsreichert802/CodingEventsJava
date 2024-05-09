package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();
 //only exists during lifetime of application, lose when restart with static will learn database soon

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");

        //use new static field to display events
        model.addAttribute("events", events);


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
        return "events/create";
    }


    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:/events";
    }

}
