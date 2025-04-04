package me.dio.decola_tech.decola_tec_2025.controller;

import me.dio.decola_tech.decola_tec_2025.domain.model.CourseClass;
import me.dio.decola_tech.decola_tec_2025.service.CourseClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classes")
public class CourseClassController {

    private final CourseClassService courseClassService;

    public CourseClassController(CourseClassService courseClassService) {
        this.courseClassService = courseClassService;
    }

    @GetMapping
    public ResponseEntity<List<CourseClass>> findAll() {
        return ResponseEntity.ok(courseClassService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseClass> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseClassService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseClass> save(@RequestBody CourseClass courseClass) {
        return ResponseEntity.ok(courseClassService.save(courseClass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseClassService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
