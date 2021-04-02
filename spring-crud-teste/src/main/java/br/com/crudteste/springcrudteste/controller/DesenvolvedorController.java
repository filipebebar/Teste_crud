package br.com.crudteste.springcrudteste.controller;

import br.com.crudteste.springcrudteste.dto.DesenvolvedorDTO;
import br.com.crudteste.springcrudteste.entity.Desenvolvedor;
import br.com.crudteste.springcrudteste.repository.DesenvolvedorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/developers")
@CrossOrigin("*")
public class DesenvolvedorController {

    private DesenvolvedorRepository repository;

    public DesenvolvedorController(DesenvolvedorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Desenvolvedor>> listarTodos() {
        List<Desenvolvedor> devs = repository.findAll();
        return new ResponseEntity<>(devs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesenvolvedorDTO> findDesenvolvedorById(@PathVariable("id") Long id) {
        var dev = repository.getOne(id);
        var d = DesenvolvedorDTO.converter(dev);

        if (d == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(d);
    }

    @PostMapping("/")
    public ResponseEntity salvarDesenvolvedor(@RequestBody Desenvolvedor d) {
        Date data = new Date();

        if (!d.getDataNascimento().after(data)) {
            repository.save(d);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(d.getNome() + " error ao salvar");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Desenvolvedor> atualizarDesenvolvedor(@PathVariable("id") Long id, @RequestBody Desenvolvedor d) {
        var dev = repository.findById(id);
        if (dev.isPresent()) {
            try {
                var devSave = dev.get();
                devSave.setNome(d.getNome());
                devSave.setSexo(d.getSexo());
                devSave.setIdade(d.getIdade());
                devSave.setHobby(d.getHobby());
                devSave.setDataNascimento(d.getDataNascimento());

                return ResponseEntity.ok((repository.save(devSave)));
            } catch (Error e) {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerDesenvolvedor(@PathVariable(name = "id") Long id) {
        Desenvolvedor d = repository.getOne(id);

        if (d == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            repository.delete(d);
            return ResponseEntity.noContent().build();
        } catch (Error e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
