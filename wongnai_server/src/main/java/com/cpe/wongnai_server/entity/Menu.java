package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name ="Menu")
public class Menu {
    @Id 
    @SequenceGenerator(name = "menu_seq", sequenceName = "menu_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_seq")
    private Long mid;
    private String foodname;
    private int foodprice;

   
}