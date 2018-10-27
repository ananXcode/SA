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
@Table(name="Promo")
public class Promo {
    @Id 
    @SequenceGenerator(name = "promo_seq", sequenceName = "promo_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promo_seq")
    private @NonNull Long pid;
    private String proname;
}
    
    