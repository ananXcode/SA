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
@Table(name="Owner")
public class Owner {
    @Id 
    @SequenceGenerator(name = "owner_seq", sequenceName = "owner_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq")
    private @NonNull Long ow_id;
    private String owname;
    private String tel;

}