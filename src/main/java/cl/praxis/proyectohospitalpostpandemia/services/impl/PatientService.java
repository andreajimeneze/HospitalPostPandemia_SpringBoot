package cl.praxis.proyectohospitalpostpandemia.services.impl;

import cl.praxis.proyectohospitalpostpandemia.entities.Patient;
import cl.praxis.proyectohospitalpostpandemia.repositories.IPatientRepository;
import cl.praxis.proyectohospitalpostpandemia.services.IBaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IBaseCrudService<Patient> {

    @Autowired
    private IPatientRepository patientRepo;

    @Override
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    @Override
    public Patient getById(int id) {
        return patientRepo.findById(id).orElse(null);
    }

    @Override
    public Patient create(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        if(patient != null) {
            return patientRepo.save(patient);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        patientRepo.deleteById(id);
    }
}
