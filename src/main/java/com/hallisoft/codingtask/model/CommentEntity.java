package com.hallisoft.codingtask.model;

import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "comments")

public class CommentEntity extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "comment", nullable = false, length = 250)
    private String comment;


    @Column(name = "ip_address_location", nullable = false)
    private String ipAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "episodeComments", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private EpisodeEntity episode;

    public String getIpAddress(){
        return ipAddress;
    }
    public String getComment(){
        return comment;
    }
    public void setEpisode(EpisodeEntity episode) {
        this.episode = episode;
    }

}
