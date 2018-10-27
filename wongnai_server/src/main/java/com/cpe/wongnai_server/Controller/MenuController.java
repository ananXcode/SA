package com.cpe.wongnai_server.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import com.cpe.wongnai_server.Repository.MenuRepository;
import com.cpe.wongnai_server.entity.Menu;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class MenuController {
    private MenuRepository menurepository;
    public MenuController(MenuRepository menurepository) {
        this.menurepository = menurepository;
    }
    @GetMapping("/showmenu")
    public Collection<Menu> coolMenu() {
        return menurepository.findAll().stream()
            .collect(Collectors.toList());
    }
}