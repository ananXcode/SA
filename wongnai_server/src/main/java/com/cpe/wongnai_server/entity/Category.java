package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name ="Type")
public class Category {
    @Id 
    @SequenceGenerator(name = "rtype_seq", sequenceName = "rtype_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rtype_seq")
    private @NonNull Long cid;
    private String category;

}