package cl.praxis.proyectohospitalpostpandemia.repositories;

import cl.praxis.proyectohospitalpostpandemia.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {
}
