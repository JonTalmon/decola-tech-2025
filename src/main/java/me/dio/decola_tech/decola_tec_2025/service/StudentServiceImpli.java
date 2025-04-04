package me.dio.decola_tech.decola_tec_2025.service;

import me.dio.decola_tech.decola_tec_2025.controller.exception.ResourceNotFoundException;
import me.dio.decola_tech.decola_tec_2025.domain.model.Student;
import me.dio.decola_tech.decola_tec_2025.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpli implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpli(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public Student update(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
}
