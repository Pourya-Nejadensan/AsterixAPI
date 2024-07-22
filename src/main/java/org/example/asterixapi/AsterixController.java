package org.example.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService asterixService;

    /*    @GetMapping("/characters")
    public List<Character> getCharacters() {
        return List.of(
                new Character("1", "Asterix", 35, "Krieger"),
                new Character("2", "Obelix", 35, "Lieferant"),
                new Character("3", "Miraculix", 60, "Druide"),
                new Character("4", "Majestix", 60, "Häuptling"),
                new Character("5", "Troubadix", 25, "Barden"),
                new Character("6", "Gutemine", 35, "Häuptlingsfrau"),
                new Character("7", "Idefix", 5, "Hund"),
                new Character("8", "Geriatrix", 70, "Rentner"),
                new Character("9", "Automatix", 35, "Schmied"),
                new Character("10", "Grockelix", 35, "Fischer")
        );
    }*/

    @GetMapping("/characters")
    public List<Character> getCharacters() {
        return asterixService.findAllCharacter();
    }

    @PutMapping("/characters/{id}")
    public Character updateCharacters(@PathVariable String id, @RequestBody Character character) {
        return asterixService.updateCharacter(id, character);
    }

    @PostMapping("/characters")
    public Character addCharacters(@RequestBody Character character) {
        return asterixService.createCharacter(character);
    }
    @DeleteMapping("/characters/{id}")
    public void deleteCharacters(@PathVariable String id) {
        asterixService.deleteCharacter(id);
    }
}