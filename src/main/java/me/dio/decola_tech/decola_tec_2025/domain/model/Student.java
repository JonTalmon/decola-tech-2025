package me.dio.decola_tech.decola_tec_2025.domain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String registration;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Attendance> attendances;
}
