package com.cpe.wongnai_server.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import com.cpe.wongnai_server.Repository.PromoRepository;
import com.cpe.wongnai_server.entity.Promo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class PromoController {
    private PromoRepository promorepository;

    public PromoController(PromoRepository promorepository) {
        this.promorepository = promorepository;
    }
    @GetMapping("/showPromo")
    public Collection<Promo> getAllPromo() {
        return promorepository.findAll().stream()
            .collect(Collectors.toList());
    }
}