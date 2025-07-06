package com.gtr3base.EventPlaner.service;

import com.gtr3base.EventPlaner.dto.EventDTO;
import com.gtr3base.EventPlaner.exception.ResourceNotFoundException;
import com.gtr3base.EventPlaner.model.Event;
import com.gtr3base.EventPlaner.model.Vendor;
import com.gtr3base.EventPlaner.repository.EventRepository;
import com.gtr3base.EventPlaner.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final VendorRepository vendorRepository;

    @Autowired
    public EventService(EventRepository eventRepository, VendorRepository vendorRepository) {
        this.eventRepository = eventRepository;
        this.vendorRepository = vendorRepository;
    }

    public Event createEvent(EventDTO eventDTO) {
        Event event = Event
                .builder()
                .name(eventDTO.getName())
                .description(eventDTO.getDescription())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .location(eventDTO.getLocation())
                .budget(eventDTO.getBudget())
                .build();

        return eventRepository.save(event);
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event " + id + " not found"));
    }

    @Transactional
    public Event updateEvent(Long id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event " + id + " not found"));

        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setStartTime(eventDTO.getStartTime());
        event.setEndTime(eventDTO.getEndTime());
        event.setLocation(eventDTO.getLocation());
        event.setBudget(eventDTO.getBudget());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event " + id + " not found"));

        eventRepository.delete(event);
    }

    @Transactional
    public Event addVendorToEvent(Long eventId, Long vendorId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event " + eventId + " not found"));

        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new ResourceNotFoundException("Vendor " + vendorId + " not found"));

        event.getVendors().add(vendor);
        return eventRepository.save(event);
    }

    public List<Event> getEventsInTimeRange(LocalDateTime start, LocalDateTime end){
        return eventRepository.findByStartTimeBetween(start, end);
    }
}
