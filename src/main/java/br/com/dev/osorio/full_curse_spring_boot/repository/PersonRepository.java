package br.com.dev.osorio.full_curse_spring_boot.repository;

import br.com.dev.osorio.full_curse_spring_boot.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, Long> {
}
