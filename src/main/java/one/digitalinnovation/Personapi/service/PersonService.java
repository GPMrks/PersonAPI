package one.digitalinnovation.Personapi.service;

import one.digitalinnovation.Personapi.dto.request.PersonDTO;
import one.digitalinnovation.Personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.Personapi.entity.Person;
import one.digitalinnovation.Personapi.mapper.PersonMapper;
import one.digitalinnovation.Personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

}
