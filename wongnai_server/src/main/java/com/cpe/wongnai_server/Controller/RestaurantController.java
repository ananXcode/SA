package com.cpe.wongnai_server.Controller;

import com.cpe.wongnai_server.entity.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cpe.wongnai_server.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
class RestaurantController {
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PromoRepository promoRepository;

    public RestaurantController(RestaurantRepository restaurantRepository
                                ,CategoryRepository categoryRepository
                                ,PromoRepository promoRepository
                                ) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/Restaurant")
    public Collection<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll().stream()
            .collect(Collectors.toList());
    }
    @GetMapping("/Restaurant/{rid}")
    public Restaurant ShowRestaurantInfo(@PathVariable Long rid) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(rid);
        return restaurant.get();
    }
    @PostMapping("/restaurant/create/{rname}/{catego}/{menus}/{owa}/{rtel}/{promo}")
    public Restaurant createRestaurant(@PathVariable Long menus,
                                       @PathVariable Long owa,  
                                       @PathVariable String rname,
                                       @PathVariable Long catego,
                                       @PathVariable String rtel,
                                       @PathVariable Long promo,
                                       @RequestBody String packAddress)
    throws IOException,JsonParseException {
        final String decoded = URLDecoder.decode(packAddress, "UTF-8");
        packAddress = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(packAddress);
        JsonNode jsonTextad = actualObj.get("addressSelect");
        JsonNode jsonTexturl = actualObj.get("picurl");
        Restaurant restaurant = new Restaurant();
        restaurant.setRtel(rtel);
        restaurant.setRname(rname);
        restaurant.setFreme(menuRepository.getOne(menus));
        restaurant.setFreow(ownerRepository.getOne(owa));
        restaurant.setFrepo(promoRepository.getOne(promo));
        restaurant.setFcare(categoryRepository.getOne(catego));
        restaurant.setRaddress(jsonTextad.textValue());
        restaurant.setUrlpic(jsonTexturl.textValue());
            return restaurantRepository.save(restaurant);
    }
}    