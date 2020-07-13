package com.hallisoft.codingtask.repository;

import com.hallisoft.codingtask.model.CharacterEntity;
import com.hallisoft.codingtask.model.EpisodeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EpisodeRepository extends JpaRepository<EpisodeEntity, Long>{
 Page<EpisodeEntity> findAllByCharacters_Id(Long Id, Pageable pageable);
}
