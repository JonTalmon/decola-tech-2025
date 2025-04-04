package me.dio.decola_tech.decola_tec_2025.service;

import me.dio.decola_tech.decola_tec_2025.domain.model.CourseClass;

import java.util.List;

public interface CourseClassService {

    List<CourseClass> findAll();
    CourseClass findById(Long id);
    CourseClass save(CourseClass courseClass);

    CourseClass update(Long id, CourseClass updatedCourseClass);

    void delete(Long id);
}
