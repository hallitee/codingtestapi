package com.hallisoft.codingtask.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
//import org.hibernate.annotations.*;
import java.util.Date;

@Entity
@Table(name = "episodes")

public class EpisodeEntity extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "name", nullable = false)
    private String name;

    
    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @Column(name = "episode_code", nullable = false)
    private String episodeCode;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "episodes")
    private Set<CharacterEntity> characters = new HashSet<>();

 /*   @OneToMany(mappedBy = "episodes")
    private Set<CommentEntity> episodeComments;*/

}
