package org.example.asterixapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsterixService {

    private final AsterixRepo asterixRepo;

    public List<Character> findAllProduct(){
        return asterixRepo.findAll();
    }
}
