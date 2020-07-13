package com.hallisoft.codingtask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"created", "updated"},
        allowGetters = true

)
public abstract class AuditModel implements Serializable {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false, insertable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated", nullable = false, insertable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Date updated;

    public Date getcreated() {
        return created;
    }

    public void setcreated(Date created) {
        this.created = created;
    }

    public Date getupdated() {
        return updated;
    }

    public void setupdated(Date updated) {
        this.updated = updated;
    }
}