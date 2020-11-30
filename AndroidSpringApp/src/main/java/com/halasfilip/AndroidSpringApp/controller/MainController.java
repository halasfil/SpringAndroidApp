package com.halasfilip.AndroidSpringApp.controller;

import com.halasfilip.AndroidSpringApp.dto.CreateInformationToBeSentDTO;
import com.halasfilip.AndroidSpringApp.model.InformationSended;
import com.halasfilip.AndroidSpringApp.repo.InMemoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/information")

public class MainController {

    @Autowired
    private InMemoryRepo inMemoryRepo;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateInformationToBeSentDTO createInformationToBeSentDTO) {
        inMemoryRepo.addInformation(createInformationToBeSentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List> findAll() {
        List<InformationSended> informationSendedList = inMemoryRepo.fetchThemAll();
        return ResponseEntity.ok(informationSendedList);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteItemById(@RequestParam Integer id) {
        return inMemoryRepo.deleteById(id) ? ResponseEntity.ok(HttpStatus.valueOf(202)) : ResponseEntity.ok(HttpStatus.valueOf(202));
    }

}
