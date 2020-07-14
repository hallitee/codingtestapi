package com.hallisoft.codingtask.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.hallisoft.codingtask.exception.ResourceNotFoundException;
import com.hallisoft.codingtask.model.EpisodeEntity;
import java.util.List;

import com.hallisoft.codingtask.model.LocationEntity;
import com.hallisoft.codingtask.repository.CharacterRepository;
import com.hallisoft.codingtask.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController  {

    @Autowired
    private EpisodeRepository episodeRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @GetMapping
    public Page<EpisodeEntity> listEpisodes( @RequestParam( defaultValue = "50") int size, @RequestParam( defaultValue = "1") int page,Pageable pageable){
        Sort sort =  Sort.by("releaseDate").ascending();
        pageable = PageRequest.of(page-1,size, sort);
        return episodeRepository.findAll(pageable);
    }
    @GetMapping("/character/{Id}")
    public Page<EpisodeEntity> getEpisodesByCharacterId( @PathVariable (value = "Id") Long Id,Pageable pageable)  throws ResourceNotFoundException{
        if(Id!=null) {
        return episodeRepository.findAllByCharacters_Id(Id, pageable);

        }
        throw new ResourceNotFoundException("character not found");
    }
}