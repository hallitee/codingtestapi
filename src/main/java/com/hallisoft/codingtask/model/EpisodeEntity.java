package com.hallisoft.codingtask.model;

import java.util.Set;
import javax.persistence.*;
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
            })
    @JoinTable(name = "character_episode",
            joinColumns = { @JoinColumn(name = "episode_id") },
            inverseJoinColumns = { @JoinColumn(name = "character_id") })
    private Set<CharacterEntity> characters;

    @OneToMany(mappedBy = "episode")
    private Set<CommentEntity> episodeComments;

    public Long getId(){
        return  id;
    }
    public String getName() {
        return name;
    }
    public String getReleaseDate() {
        return releaseDate.toString();
    }
    public String getEpisodeCode() {
        return episodeCode;
    }
    public int getComments() {
        return episodeComments.size();
    }
    public EpisodeEntity(){

    }
    public EpisodeEntity(Long id){
        this.id = id;
    }

}
