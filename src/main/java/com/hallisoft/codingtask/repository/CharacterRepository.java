package com.hallisoft.codingtask.repository;

import com.hallisoft.codingtask.model.EpisodeEntity;
import com.hallisoft.codingtask.model.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.hallisoft.codingtask.model.CharacterEntity;
import com.hallisoft.codingtask.model.CharacterEntity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long>{

    Page<CharacterEntity> findByGenderIsLike(Gender gender, Pageable pageable);
    Page<CharacterEntity> findByLocation_Name(String location, Pageable pageable);
    Page<CharacterEntity> findByStatusIsLike(CharacterEntity.Status status, Pageable pageable);
}
