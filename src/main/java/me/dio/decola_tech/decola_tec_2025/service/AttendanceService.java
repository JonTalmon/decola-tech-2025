package me.dio.decola_tech.decola_tec_2025.service;

import me.dio.decola_tech.decola_tec_2025.domain.model.Attendance;

import java.util.List;

public interface AttendanceService {

    List<Attendance> findAll();
    Attendance findById(Long id);
    Attendance save(Attendance attendance);
    void delete(Long id);
}
