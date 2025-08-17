package br.com.dev.osorio.full_curse_spring_boot.mapper;

import br.com.dev.osorio.full_curse_spring_boot.controllers.data.dto.v1.PersonDTO;
import br.com.dev.osorio.full_curse_spring_boot.model.PersonModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/*
unmappedTargetPolicy
- ReportingPolicy.IGNORE = Ignora campos não mapeados(default)

- ReportingPolicy.WARN = Compila mas mostra Warning

- ReportingPolicy.ERROR = Não compila se esquecer de mapear algum campo
 */

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    PersonDTO personToPersonDTO(PersonModel personModel);

    PersonModel personDTOToPerson(PersonDTO personDTO);

    List<PersonDTO> listPersonToPersonDTO(List<PersonModel> personModelList);
}
