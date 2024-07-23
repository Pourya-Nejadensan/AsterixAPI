package org.example.asterixapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AsterixIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    AsterixRepo asterixRepo;

    @Test
    @DirtiesContext
    void getAllCharacters() throws Exception {
        //GIVEN
        asterixRepo.save(new Character("1", "Name", 20, "Profession"));

        //WHEN
        mockMvc.perform(get("/asterix/characters"))

        //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                             {
                             "id": "1",
                             "name": "Name",
                             "age": 20,
                             "profession": "Profession"
                             }
                         ]
                        """));
    }

    @Test
    @DirtiesContext
    void addCharacters() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(post("/asterix/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                               {
                               "name": "Name",
                               "age": 20,
                               "profession": "Profession"
                               }
                              """))

                //THEN
                .andExpect(status().isOk())
                .andExpect(content().json("""
                             {
                             "name": "Name",
                             "age": 20,
                             "profession": "Profession"
                             }
                        """))
                .andExpect(jsonPath("$.id").exists());

    }
}