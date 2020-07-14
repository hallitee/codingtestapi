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
    public Page<CharacterEntity> getAllCharacters(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(required = false) String filterBy, @RequestParam(required = false) String filter,
                                                  @RequestParam( defaultValue ="ASC") String dir ,  @RequestParam( defaultValue = "10") int size, @RequestParam( defaultValue = "1") int page, Pageable pageable) {
        if(sortBy.equalsIgnoreCase("firstName") || sortBy.equalsIgnoreCase("lastName") || sortBy.equalsIgnoreCase("gender")){

        }else{
                sortBy = "id";
        }
        Sort sort = dir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        pageable = PageRequest.of(page-1,size, sort);
        Page<CharacterEntity> result = null;
        if(filterBy == null) {
            result = characterRepository.findAll(pageable);
        }else if( filterBy.equalsIgnoreCase("gender")){
           result = characterRepository.findByGenderIsLike(CharacterEntity.Gender.valueOf(filter.toUpperCase()), pageable);
        }
        else if( filterBy.equalsIgnoreCase("status")){
            result = characterRepository.findByStatusIsLike(CharacterEntity.Status.valueOf(filter.toUpperCase()), pageable);
        }
        else if(filterBy.equalsIgnoreCase("location")){
            result = characterRepository.findByLocation_Name(filter, pageable);
        }
        return result;
    }

}