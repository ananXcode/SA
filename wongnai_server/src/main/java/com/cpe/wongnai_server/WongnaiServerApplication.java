package com.cpe.wongnai_server;
import com.cpe.wongnai_server.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;
import lombok.*;
import com.cpe.wongnai_server.Repository.*;
@Getter@Setter
@SpringBootApplication
public class WongnaiServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(WongnaiServerApplication.class, args);}
		@Bean
    ApplicationRunner init(OwnerRepository ownerRepository
                          ,CategoryRepository categoryRepository
                           ,MenuRepository menuRepository
                           ,RestaurantRepository restaurantRepository
                           ,PromoRepository promoRepository
                            ) {
        return args -> {
            Stream.of("Anan", "Kathin", "Sathorn", "Garran" ).forEach(owname -> {
                Owner owner = new Owner();
                if(owname=="Anan"){
                    owner.setTel("0971957408");
                }
                else if(owname=="Kathin"){
                    owner.setTel("0977777777");
                }
                else if(owname=="Sathorn"){
                    owner.setTel("0988888888");
                }
                else if(owname=="Garran"){
                    owner.setTel("0966666666");
                }
                owner.setOwname(owname);
                ownerRepository.save(owner);

    });ownerRepository.findAll().forEach(System.out::println);
    Stream.of("Chinese", "Europe", "Thai", "Esan" ).forEach(catego -> {
        Category cater = new Category();
        cater.setCategory(catego);
        categoryRepository.save(cater);
        } );
    categoryRepository.findAll().forEach(System.out::println);
    Stream.of("kapao", "soup", "tomyumkung", "salad","Meat grill" , "Somtum" ).forEach(foodname -> {
        Menu menu = new Menu();
        if(foodname == "kapao"){
            menu.setFoodprice(50);
        }else if(foodname == "soup"){
            menu.setFoodprice(60);
        }
        else if(foodname == "tomyumkung"){
            menu.setFoodprice(80);
        }
        else if(foodname == "salad"){
            menu.setFoodprice(40);
        }
        else if(foodname == "Meat grill"){
            menu.setFoodprice(150);
        }
        else if(foodname == "Somtum"){
            menu.setFoodprice(35);
        }
        menu.setFoodname(foodname);
        menuRepository.save(menu);
        } );
    menuRepository.findAll().forEach(System.out::println);
    
    Stream.of("4paid3", "1 Free 1", "Free 50%", "Free 30%" ).forEach(promot -> {
        Promo promo = new Promo();
        promo.setProname(promot);
        promoRepository.save(promo);
        } );
    promoRepository.findAll().forEach(System.out::println);

    Restaurant restaurant1 = new Restaurant();
    restaurant1.setRname("Korkok");
    restaurant1.setRaddress("SUT Gate 1");
    restaurant1.setRtel("095422547");
    restaurant1.setUrlpic("https://image.ibb.co/n1LOMV/korkok.jpg");
    restaurant1.setFreow(ownerRepository.getOne(2L));
    restaurant1.setFreme(menuRepository.getOne(3L));
    restaurant1.setFcare(categoryRepository.getOne(1L));
    restaurant1.setFrepo(promoRepository.getOne(2L));   
               restaurantRepository.save(restaurant1);
                 
    Restaurant restaurant2 = new Restaurant();
            
    restaurant2.setRname("เปา");
    restaurant2.setRaddress("SUT Gate 1");
    restaurant2.setRtel("085441225");
    restaurant2.setUrlpic("https://image.ibb.co/jOPToA/PAO-3.jpg");
    restaurant2.setFreow(ownerRepository.getOne(1L));
    restaurant2.setFreme(menuRepository.getOne(2L));
    restaurant2.setFcare(categoryRepository.getOne(3L));
    restaurant2.setFrepo(promoRepository.getOne(3L));   
            restaurantRepository.save(restaurant2);
            
;};}}

     

