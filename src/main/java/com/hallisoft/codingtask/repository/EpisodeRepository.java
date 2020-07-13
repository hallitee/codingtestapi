package com.hallisoft.codingtask.repository;

import com.hallisoft.codingtask.model.EpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<EpisodeEntity, Long>{
}
