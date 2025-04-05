package me.dio.decola_tech.decola_tec_2025.controller;

import me.dio.decola_tech.decola_tec_2025.domain.model.Attendance;
import me.dio.decola_tech.decola_tec_2025.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> findAll() {
        return ResponseEntity.ok(attendanceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> findById(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Attendance> save(@RequestBody Attendance attendance) {
        return ResponseEntity.status(201).body(attendanceService.save(attendance));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        attendanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
