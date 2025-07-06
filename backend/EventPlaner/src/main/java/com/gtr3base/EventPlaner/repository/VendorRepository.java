package com.gtr3base.EventPlaner.repository;

import com.gtr3base.EventPlaner.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
    List<Vendor> findByCategory(String category);
    List<Vendor> findByNameContaining(String name);
}
