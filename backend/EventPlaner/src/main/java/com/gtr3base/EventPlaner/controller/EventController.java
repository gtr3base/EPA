package com.gtr3base.EventPlaner.controller;

import com.gtr3base.EventPlaner.dto.EventDTO;
import com.gtr3base.EventPlaner.model.Event;
import com.gtr3base.EventPlaner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createEvent(eventDTO);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(id, eventDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{eventId}/vendors/{vendorId}")
    public Event addVendorToEvent(@PathVariable Long eventId, @PathVariable Long vendorId) {
        return eventService.addVendorToEvent(eventId, vendorId);
    }

    @GetMapping("/range")
    public List<Event> getEventsInRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return eventService.getEventsInTimeRange(start, end);
    }
}