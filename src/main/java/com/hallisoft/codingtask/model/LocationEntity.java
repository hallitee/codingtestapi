package com.hallisoft.codingtask.model;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class LocationEntity extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "name", nullable = false)
    private String name;

    
    @Column(name = "latitude", nullable = false)
    private double latitude;

    
    @Column(name = "longitude", nullable = false)
    private double longitude;

    @OneToOne(mappedBy = "location")
    private CharacterEntity character;

}
