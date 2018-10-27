package com.cpe.wongnai_server.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;
import com.cpe.wongnai_server.Repository.OwnerRepository;
import com.cpe.wongnai_server.entity.Owner;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class OwnerController {
    @Autowired
    private OwnerRepository OwnerRepository;
    
    public OwnerController(OwnerRepository repository) {
        this.OwnerRepository = repository;
    }
    @GetMapping("/showowner")
    public Collection<Owner> Ownerinfo() {
        return OwnerRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    
}