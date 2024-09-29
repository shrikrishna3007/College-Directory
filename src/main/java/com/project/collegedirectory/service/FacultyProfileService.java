package com.project.collegedirectory.service;

import com.project.collegedirectory.entity.FacultyProfile;
import com.project.collegedirectory.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyProfileService {

    @Autowired
    private FacultyRepository facultyProfileRepository;

    public FacultyProfile createFacultyProfile(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    public List<FacultyProfile> getFacultyList() {
        return facultyProfileRepository.findAll();
    }

    public FacultyProfile getFacultyById(Long id) {
        Optional<FacultyProfile> facultyProfile=facultyProfileRepository.findById(id);
        if(facultyProfile.isPresent()) {
            return facultyProfile.get();
        }
        else {
            throw new RuntimeException("Faculty not found for id " + id);
        }
    }

    public FacultyProfile updateFacultyProfile(Long id, FacultyProfile updatedFacultyProfile) {
        Optional<FacultyProfile> facultyProfileOptional = facultyProfileRepository.findById(id);
        if(facultyProfileOptional.isPresent()) {
            FacultyProfile facultyProfile = facultyProfileOptional.get();
            facultyProfile.setPhoto(updatedFacultyProfile.getPhoto());
            facultyProfile.setOffice_hours(updatedFacultyProfile.getOffice_hours());
            return facultyProfileRepository.save(facultyProfile);
        } else {
            throw new RuntimeException("Faculty not found for id " + id);
        }
    }

    public String deleteFacultyProfile(Long id) {
        Optional<FacultyProfile> facultyProfile=facultyProfileRepository.findById(id);
        if (facultyProfile.isPresent()) {
            facultyProfileRepository.deleteById(id);
            return "Faculty deleted successfully";
        }else {
            throw new RuntimeException("Faculty not found for id " + id);
        }
    }
}
