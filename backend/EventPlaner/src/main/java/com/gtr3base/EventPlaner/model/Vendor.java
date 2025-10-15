package com.gtr3base.EventPlaner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vendor {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String category;
    private String contactInfo;
    private Double rating;

    @ManyToMany(mappedBy = "vendors")
    private List<Event> events;
}
