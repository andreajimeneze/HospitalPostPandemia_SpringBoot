package cl.praxis.proyectohospitalpostpandemia.controllers;

import cl.praxis.proyectohospitalpostpandemia.App;
import cl.praxis.proyectohospitalpostpandemia.entities.Diagnoses;
import cl.praxis.proyectohospitalpostpandemia.entities.Patient;
import cl.praxis.proyectohospitalpostpandemia.services.IBaseCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PatientController {
    @Autowired
    private IBaseCrudService<Patient> patientService;

    @Autowired
    private IBaseCrudService<Diagnoses> diagnosesService;

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    // CRUD ver listado pacientes
    @GetMapping("/all")
    public String getAllPatients(Model model) {
        LOG.info("Mostrando lista de pacientes");
        model.addAttribute("pacientes", patientService.getAll());
        return "patient_list";
    }

    // CRUD crear paciente
    @PostMapping
    public String createPatient(@ModelAttribute Patient patient) {
        LOG.info("Añadiendo nuevo paciente");
        patientService.create(patient);
        LOG.info("Se creó correctamente al paciente: " + patient.getName() + " " + patient.getSurname());
        return "redirect:/pacientes/all";
    }

    // CRUD editar paciente
    @PutMapping
    public String editPatient(@RequestParam int id, Patient patient) {
        Patient searchPatient = patientService.getById(id);

        if(searchPatient != null) {
            LOG.info("Paciente encontrado: " + searchPatient.getName() + " " + searchPatient.getSurname());
            patientService.update(patient);
            LOG.info("Paciente editado correctamente" + searchPatient.getName() + " " + searchPatient.getSurname());
            return "redirect:/pacientes/all";
        } else {
            LOG.warn("Paciente no encontrado");
            return "patient_form";
        }
    }

    // CRUD eliminar paciente
    @DeleteMapping("/eliminar")
    public String deletePatient(@RequestParam int id, @ModelAttribute Patient patient) {
        LOG.warn("Eliminará paciente");
        patientService.delete(id);
        LOG.info("Paciente eliminado correctamente");
        return "redirect:/pacientes/all";
    }

    // Enrutamiento crear paciente
    @GetMapping("/nuevo")
    public String showCreateForm() {
        return "patient_form";
    }

    // Enrutamiento editar paciente
    @GetMapping("/editar")
    public String showEditForm(@RequestParam int id, Model model) {
        Patient searchPatient = patientService.getById(id);

        if(searchPatient != null) {
            model.addAttribute("paciente", searchPatient);
            return "patient_form";
        }
        return "patient_list";
    }
}
