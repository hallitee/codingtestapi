package com.hallisoft.codingtask.controller;

import com.hallisoft.codingtask.model.CharacterEntity;

import com.hallisoft.codingtask.repository.CharacterRepository;
import com.hallisoft.codingtask.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private EpisodeRepository  episodeRepository;

    @GetMapping
    public Page<CharacterEntity> getAllCharacters(@RequestParam(defaultValue = "id") String sortField, @RequestParam(required = false) String filter, @RequestParam(required = false) String filterBy,
                                                  @RequestParam( defaultValue ="ASC") String dir ,  @RequestParam( defaultValue = "10") int size, @RequestParam( defaultValue = "1") int page, Pageable pageable) {
        if(sortField.equalsIgnoreCase("firstName") || sortField.equalsIgnoreCase("lastName") || sortField.equalsIgnoreCase("gender")){

        }else{
                sortField = "id";
        }
        Sort sort = dir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        pageable = PageRequest.of(page-1,size, sort);
        Page<CharacterEntity> result = null;
        if(filter == null) {
            result = characterRepository.findAll(pageable);
        }else if( filter.equalsIgnoreCase("gender")){
           result = characterRepository.findByGenderIsLike(CharacterEntity.Gender.valueOf(filterBy.toUpperCase()), pageable);
        }
        else if( filter.equalsIgnoreCase("status")){
            result = characterRepository.findByStatusIsLike(CharacterEntity.Status.valueOf(filterBy.toUpperCase()), pageable);
        }
        else if(filter.equalsIgnoreCase("location")){
            result = characterRepository.findByLocation_Name(filterBy, pageable);
        }
        return result;
    }

}