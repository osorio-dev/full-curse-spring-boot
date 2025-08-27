package br.com.dev.osorio.full_curse_spring_boot.controllers;

import br.com.dev.osorio.full_curse_spring_boot.controllers.data.dto.v1.PersonDTO;
import br.com.dev.osorio.full_curse_spring_boot.service.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping(value = "/findPerson/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PersonDTO findById(@PathVariable("id") Long id) {
        var person = personServices.findById(id);
        person.setBirthday(new Date());
        return person;
    }

    @GetMapping(value = "/findPerson", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<PersonDTO> getAllPerson() {
        return personServices.getAll();
    }

    @PostMapping(value = "/createPerson", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PersonDTO createPerson(@RequestBody PersonDTO personDTO) {return personServices.create(personDTO);}

//    @PostMapping("/createPersonv2")
//    public PersonDTOV2 createPerson(@RequestBody PersonDTOV2 personDTOV2) {return personServices.createV2(personDTOV2);}

    @PutMapping(value = "/updatePerson", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public PersonDTO updatePerson(@RequestBody PersonDTO personDTO) {
        return personServices.update(personDTO);
    }

    @DeleteMapping(value = "/deletePerson", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> deletePerson(@RequestParam(name = "id") Long id) {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
