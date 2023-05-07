package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Cliente;
import pe.com.midocvirtual.backend.entities.Consulta;
import pe.com.midocvirtual.backend.repositories.ConsultaRepository;
import pe.com.midocvirtual.backend.services.ConsultaServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class ConsultaController {
    @Autowired
    private ConsultaServices repo;
    @GetMapping("/consultas")
    public ResponseEntity<List<Consulta>> getConsultas(){
        List<Consulta> consultas= repo.getConsultas();
        if (consultas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
    }
    @PostMapping("/consultas")
    public ResponseEntity <Consulta> addConsulta(@RequestBody Consulta consulta){
        Consulta newConsulta = repo.addConsulta(consulta);
        return new ResponseEntity<Consulta>(newConsulta,HttpStatus.CREATED);
    }
}
