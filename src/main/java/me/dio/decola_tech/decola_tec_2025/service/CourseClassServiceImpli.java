package me.dio.decola_tech.decola_tec_2025.service;


import me.dio.decola_tech.decola_tec_2025.controller.exception.ResourceNotFoundException;
import me.dio.decola_tech.decola_tec_2025.domain.model.CourseClass;
import me.dio.decola_tech.decola_tec_2025.domain.repository.CourseClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseClassServiceImpli implements CourseClassService {

    private final CourseClassRepository courseClassRepository;

    public CourseClassServiceImpli(CourseClassRepository courseClassRepository) {
        this.courseClassRepository = courseClassRepository;
    }


    @Override
    public List<CourseClass> findAll() {
        return courseClassRepository.findAll();
    }

    @Override
    public CourseClass findById(Long id) {
        return courseClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseClass not found with id: " + id));
    }

    @Override
    public CourseClass save(CourseClass courseClass) {
        return courseClassRepository.save(courseClass);
    }

    @Override
    public CourseClass update(Long id, CourseClass updatedCourseClass) {
        CourseClass courseClass = courseClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseClass not found with id: " + id));
        courseClass.setName(updatedCourseClass.getName());
        return courseClassRepository.save(courseClass);
    }

    @Override
    public void delete(Long id) {
        CourseClass courseClass = courseClassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseClass not found with id: " + id));
        courseClassRepository.delete(courseClass);
    }
}
