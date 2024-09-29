package com.project.collegedirectory.service;

import com.project.collegedirectory.entity.AdministratorProfile;
import com.project.collegedirectory.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorProfileService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public AdministratorProfile createAdministratorProfile(AdministratorProfile administratorProfile) {
        return administratorRepository.save(administratorProfile);
    }

    public List<AdministratorProfile> getAdministratorList() {
        return administratorRepository.findAll();
    }

    public AdministratorProfile getAdministratorById(Long id) {
        Optional<AdministratorProfile> administratorProfile=administratorRepository.findById(id);
        if(administratorProfile.isPresent()){
            return administratorProfile.get();
        }else{
            throw new RuntimeException("Administrator not found for id " + id);
        }
    }

    public AdministratorProfile updateAdministratorProfile(Long id, AdministratorProfile updatedAdministratorProfile) {
        Optional<AdministratorProfile> administratorProfileOptional = administratorRepository.findById(id);
        if(administratorProfileOptional.isPresent()){
            AdministratorProfile administratorProfile = administratorProfileOptional.get();
            administratorProfile.setPhoto(updatedAdministratorProfile.getPhoto());
            return administratorRepository.save(administratorProfile);
        } else {
            throw new RuntimeException("Administrator not found for id " + id);
        }
    }

    public String deleteAdminProfileById(Long id) {
        Optional<AdministratorProfile> administratorProfile=administratorRepository.findById(id);
        if(administratorProfile.isPresent()){
            administratorRepository.deleteById(id);
            return "Administrator profile deleted successfully";
        }
        return "Administrator not found";
    }
}
