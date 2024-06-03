# Coding-Events Application

## PART1 Purpose
Application is designed to help people seekout coding events near them and register accordingly.

## Part2 Current Use
users can view list of coding events coming to their area and add new events to the list

## Part3 Improvements
add user accounts through a 'Person' Class user can register, track events on calendar, and follow events of their choosing
Fields: id (int) - user ID 
username - distinct name to login 
password 
email
first name
last name
**getters for all fileds and could have setters execpt for ID since it shouldn't change

Persons class could have personProfile
List<Events> eventsAttending to store events user wants to attend
List<Events> eventsOwned -stores another list of events created by user
registeredEvents
Methods: registerEvent(), unregisterEvent(), getRegisteredEvents()

Person would have a many-to-many relationship with Event via List<Events> eventsAttending. It would have a one-to-many relationship with Event via List<Events> eventsOwned.
