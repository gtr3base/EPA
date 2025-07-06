package com.gtr3base.EventPlaner.service;

import com.gtr3base.EventPlaner.dto.VendorDTO;
import com.gtr3base.EventPlaner.exception.ResourceNotFoundException;
import com.gtr3base.EventPlaner.model.Vendor;
import com.gtr3base.EventPlaner.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Vendor createVendor(VendorDTO vendorDTO){
        Vendor vendor = Vendor
                .builder()
                .name(vendorDTO.getName())
                .category(vendorDTO.getCategory())
                .contactInfo(vendorDTO.getContactInfo())
                .rating(vendorDTO.getRating())
                .build();

        return vendorRepository.save(vendor);
    }

    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }

    public Vendor getVendorById(Long id){
        return vendorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Vendor with id " + id + " not found"));
    }

    @Transactional
    public Vendor updateVendor(Long id, VendorDTO vendorDTO){
        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor with id " + id + " not found"));

        vendor.setName(vendorDTO.getName());
        vendor.setCategory(vendorDTO.getCategory());
        vendor.setContactInfo(vendorDTO.getContactInfo());
        vendor.setRating(vendorDTO.getRating());

        return vendorRepository.save(vendor);
    }

    public void deleteVendor(Long id){
        Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor with id " + id + " not found"));
        vendorRepository.delete(vendor);
    }

    public List<Vendor> getVendorsByCategory(String category){
        return vendorRepository.findByCategory(category);
    }
}
