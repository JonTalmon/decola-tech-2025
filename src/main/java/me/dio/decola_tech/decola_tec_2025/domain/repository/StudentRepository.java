package me.dio.decola_tech.decola_tec_2025.domain.repository;

import me.dio.decola_tech.decola_tec_2025.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
