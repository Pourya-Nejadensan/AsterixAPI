package org.example.asterixapi;

import lombok.RequiredArgsConstructor;
import org.example.asterixapi.Util.IdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AsterixService {

    private final AsterixRepo asterixRepo;
    private final IdService idService;

    public List<Character> findAllCharacter(){
        return asterixRepo.findAll();
    }

    public Optional<Character> findCharacterById(String id){
        return asterixRepo.findById(id);
    }

    public void deleteCharacter(String Id){
        asterixRepo.deleteById(Id);
    }

    public Character createCharacter(CharacterDTO characterDTO){
        return asterixRepo.save(new Character(
                idService.generateId(),
                characterDTO.name(),
                characterDTO.age(),
                characterDTO.profession()
        ));
    }

    public Character updateCharacter(String id ,Character character){
        return asterixRepo.findById(id).map(existingCharacter -> {
            existingCharacter.withName(character.name());
            existingCharacter.withAge(character.age());
            existingCharacter.withProfession(character.profession());
            return asterixRepo.save(existingCharacter);
        }).orElseGet(() -> {
            character.withId(id);
            return asterixRepo.save(character);
        });
    }
}
