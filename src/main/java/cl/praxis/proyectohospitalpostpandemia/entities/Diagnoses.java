package cl.praxis.proyectohospitalpostpandemia.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "diagnosticos")
public class Diagnoses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre_diagnostico", nullable = false)
    private String nameDiagnoses;
    @Column(name = "fecha_diagnostico", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateDiagnoses;
    @Column(name = "estado_diagnostico", nullable = false)
    private String status;
    @Column(name = "fecha_alta")
    private LocalDate discharcheDate;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Patient patient;
}
