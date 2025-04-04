package me.dio.decola_tech.decola_tec_2025.domain.repository;

import me.dio.decola_tech.decola_tec_2025.domain.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByStudentId(Long studentId);
    List<Attendance> findByCourseClassId(Long classId);
    List<Attendance> findByDate(LocalDate date);
}
