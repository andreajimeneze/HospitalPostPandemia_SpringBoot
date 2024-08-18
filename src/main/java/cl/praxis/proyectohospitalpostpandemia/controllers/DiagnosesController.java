package cl.praxis.proyectohospitalpostpandemia.controllers;

import cl.praxis.proyectohospitalpostpandemia.entities.Diagnoses;
import cl.praxis.proyectohospitalpostpandemia.entities.Patient;
import cl.praxis.proyectohospitalpostpandemia.repositories.IDiagnosesRepository;
import cl.praxis.proyectohospitalpostpandemia.services.IBaseCrudService;
import cl.praxis.proyectohospitalpostpandemia.services.IDiagnosesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diagnosticos")
public class DiagnosesController {
    @Autowired
    private IBaseCrudService<Diagnoses> diagnosesCrudService;

    @Autowired
    private IBaseCrudService<Patient> patientService;

    @Autowired
    private IDiagnosesService diagnosesService;



    @GetMapping("/{id}")
    public String getAllDiagnosesByPatient(@PathVariable int id, Model model) {
        Patient patient = patientService.getById(id);
        if(patient != null) {
            List<Diagnoses> diagnosesList = diagnosesService.getDiagnosesByPatient(patient);
            model.addAttribute("paciente", patient);
            model.addAttribute("diagnosticos", diagnosesList);
            return "diagnoses_list";
        }
        return "redirect:/pacientes/all";
    }


}
