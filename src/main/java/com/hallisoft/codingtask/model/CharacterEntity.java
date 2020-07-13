package com.hallisoft.codingtask.model;

import java.util.HashSet;
import java.util.Set;
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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "character_episode",
            joinColumns = { @JoinColumn(name = "character_id") },
            inverseJoinColumns = { @JoinColumn(name = "episode_id") })
    private Set<EpisodeEntity> episodes = new HashSet<>();

    public enum Status {
        ACTIVE, DEAD, UNKNOWN;
    }
    public enum Gender {
        MALE, FEMALE;
    }

    //All getters
    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStatus() {
        return status.toString();
    }
    public String getGender() {
        return gender.toString();
    }

    public String getOrigin(){
        return stateOfOrigin;
    }
}
