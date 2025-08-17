package br.com.dev.osorio.full_curse_spring_boot.service;

import br.com.dev.osorio.full_curse_spring_boot.controllers.data.dto.v1.PersonDTO;
import br.com.dev.osorio.full_curse_spring_boot.exceptions.ResourceNotFoundException;
import br.com.dev.osorio.full_curse_spring_boot.mapper.PersonMapper;
import br.com.dev.osorio.full_curse_spring_boot.model.PersonModel;
import br.com.dev.osorio.full_curse_spring_boot.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServices(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding One Person!!");

        if (personRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("No records this for ID!!");
        }

        return personMapper.personToPersonDTO(personRepository.findById(id).get());
    }

    public List<PersonDTO> getAll() {
        List<PersonModel> personList = personRepository.findAll();

        return personList.stream()
                .map(personMapper::personToPersonDTO)
                .toList();
    }

    public PersonDTO create(PersonDTO personDTO) {
        personRepository.save(personMapper.personDTOToPerson(personDTO));

        return personDTO;
    }

//    public PersonDTOV2 createV2(PersonDTOV2 personDTOV2) {
//        personRepository.save(personMapper.personDTOToPerson(personDTOV2));
//
//        return personDTOV2;
//    }

    public PersonDTO update(PersonDTO personDTO) {
        this.findById(personDTO.getId());

        return this.create(personDTO);
    }

    public void delete(Long id) {
        PersonDTO personDTO = this.findById(id);

        personRepository.deleteById(personDTO.getId());
    }
}
