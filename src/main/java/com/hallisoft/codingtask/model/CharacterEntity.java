package com.hallisoft.codingtask.model;


import javax.persistence.*;
//import org.hibernate.annotations.*;


@Entity
@Table(name = "characters")

public class CharacterEntity extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



 
    @Column(name = "first_name", nullable = false)
    private String firstName;

 
    @Column(name = "last_name", nullable = false)
    private String lastName;

 
    @Enumerated(EnumType.STRING)
    @Column(length = 8, nullable = false)
    private Status status;

    @Column(name = "origin")
    private String stateOfOrigin;

 
    @Enumerated(EnumType.STRING)
    @Column(length = 8, nullable = false)
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private LocationEntity location;



    public enum Status{
        ACTIVE, DEAD, UNKNOWN;
    }
    public enum Gender{
        MALE, FEMALE;
    }

}
