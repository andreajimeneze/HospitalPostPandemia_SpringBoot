package cl.praxis.proyectohospitalpostpandemia.services;

import cl.praxis.proyectohospitalpostpandemia.entities.Diagnoses;
import cl.praxis.proyectohospitalpostpandemia.entities.Patient;

import java.util.List;

public interface IDiagnosesService {
    List<Diagnoses> getDiagnosesByPatient(Patient patient);
}
