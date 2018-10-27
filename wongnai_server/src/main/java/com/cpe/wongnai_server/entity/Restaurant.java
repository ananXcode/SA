package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "Restaurants")
public class Restaurant {
    @Id 
    @SequenceGenerator(name = "res_seq", sequenceName = "res_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res_seq")
    private @NonNull Long rid;
    private  @NonNull String rname;
    private @NonNull String raddress;
    private  String rtel;
    private String urlpic;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reow_id", insertable = true)
    private  Owner freow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "care_ID", insertable = true)
    private  Category fcare;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reme_ID", insertable = true)
    private  Menu freme;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "repo_ID", insertable = true)
    private  Promo frepo;
}