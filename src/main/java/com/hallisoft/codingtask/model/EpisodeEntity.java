package com.hallisoft.codingtask.model;

import javax.persistence.*;
//import org.hibernate.annotations.*;
import java.util.Date;

@Entity
@Table(name = "characters")

public class EpisodeEntity extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "name", nullable = false)
    private String mame;

    
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;



}
