package me.dio.decola_tech.decola_tec_2025.service;

import me.dio.decola_tech.decola_tec_2025.controller.exception.ResourceNotFoundException;
import me.dio.decola_tech.decola_tec_2025.domain.model.Attendance;
import me.dio.decola_tech.decola_tec_2025.domain.repository.AttendanceRepository;
import me.dio.decola_tech.decola_tec_2025.domain.repository.CourseClassRepository;
import me.dio.decola_tech.decola_tec_2025.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpli implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final CourseClassRepository courseClassRepository;

    AttendanceServiceImpli(AttendanceRepository attendanceRepository,
                           StudentRepository studentRepository,
                           CourseClassRepository courseClassRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.courseClassRepository = courseClassRepository;
    }


    @Override
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance findById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + id));
    }

    @Override
    public Attendance save(Attendance attendance) {
        Long studentId = attendance.getStudent().getId();
        Long courseClassId = attendance.getCourseClass().getId();

        studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

        courseClassRepository.findById(courseClassId)
                .orElseThrow(() -> new ResourceNotFoundException("CourseClass not found with id: " + courseClassId));

        return attendanceRepository.save(attendance);
    }

    @Override
    public void delete(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found with id: " + id));
        attendanceRepository.delete(attendance);
    }
}
