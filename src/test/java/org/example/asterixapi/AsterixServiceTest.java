package org.example.asterixapi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {

    AsterixRepo asterixRepo = mock(AsterixRepo.class);
    AsterixService asterixService = new AsterixService(asterixRepo);

    @Test
    void findAllCharacterTest_EmptyList() {
        //GIVEN

        //WHEN
        List<Character> actual = asterixService.findAllCharacter();

        //THEN
        List<Character> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    void findAllCharacterTest_NoEmptyList() {
        //GIVEN
        Character character1 = new Character("1", "Test", 30, "Test");
        List<Character> characters = List.of(character1);

        when(asterixRepo.findAll()).thenReturn(characters);

        //WHEN
        List<Character> actual = asterixService.findAllCharacter();

        //THEN
        List<Character> expected = new ArrayList<>();
        expected.add(character1);

        verify(asterixRepo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void findCharacterByIdTest() {
        //GIVEN
        Character character1 = new Character("1", "Test", 30, "Test");

        when(asterixRepo.findById("1")).thenReturn(Optional.of(character1));

        //WHEN
        Optional<Character> actual = asterixService.findCharacterById("1");

        //THEN
        Optional<Character> expected = Optional.of(character1);

        verify(asterixRepo).findById("1");
        assertEquals(expected, actual);
    }

    @Test
    void deleteCharacterTest() {
    }

    @Test
    void updateCharacterTest() {
    }
}