package com.hallisoft.codingtask.model;

import javax.persistence.*;
//import org.hibernate.annotations.*;

@Entity
@Table(name = "locations")

public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "comment", nullable = false, length = 250)
    private String comment;


    @Column(name = "ip_address_location", nullable = false)
    private String ipAddressLocation;
}
