package cl.praxis.proyectohospitalpostpandemia.repositories;

import cl.praxis.proyectohospitalpostpandemia.entities.Diagnoses;
import cl.praxis.proyectohospitalpostpandemia.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDiagnosesRepository extends JpaRepository<Diagnoses, Integer> {
    List<Diagnoses> getDiagnosesByPatient(Patient patient);
}
