package me.dio.decola_tech.decola_tec_2025.service;

import me.dio.decola_tech.decola_tec_2025.domain.model.Student;

import java.util.List;

public interface StudentService {

    List<Student>findAll();
    Student findById(Long id);

    Student update(Long id, Student updatedStudent);

    Student save(Student student);
    void delete(Long id);
}
