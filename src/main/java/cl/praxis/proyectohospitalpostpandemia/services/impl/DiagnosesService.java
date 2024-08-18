package cl.praxis.proyectohospitalpostpandemia.services.impl;

import cl.praxis.proyectohospitalpostpandemia.entities.Diagnoses;
import cl.praxis.proyectohospitalpostpandemia.entities.Patient;
import cl.praxis.proyectohospitalpostpandemia.repositories.IDiagnosesRepository;
import cl.praxis.proyectohospitalpostpandemia.services.IBaseCrudService;
import cl.praxis.proyectohospitalpostpandemia.services.IDiagnosesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosesService implements IBaseCrudService<Diagnoses>, IDiagnosesService {
    @Autowired
    IDiagnosesRepository diagnosesRepo;

    @Override
    public List<Diagnoses> getAll() {
        return diagnosesRepo.findAll();
    }

    @Override
    public Diagnoses getById(int id) {
        return diagnosesRepo.findById(id).orElse(null);
    }

    @Override
    public Diagnoses create(Diagnoses diagnoses) {
        return diagnosesRepo.save(diagnoses);
    }

    @Override
    public Diagnoses update(Diagnoses diagnoses) {
        return diagnosesRepo.save(diagnoses);
    }

    @Override
    public void delete(int id) {
        diagnosesRepo.deleteById(id);
    }

    @Override
    public List<Diagnoses> getDiagnosesByPatient(Patient patient) {
        return diagnosesRepo.getDiagnosesByPatient(patient);
    }
}
