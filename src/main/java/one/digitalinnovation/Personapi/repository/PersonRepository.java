package one.digitalinnovation.Personapi.repository;

import one.digitalinnovation.Personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
