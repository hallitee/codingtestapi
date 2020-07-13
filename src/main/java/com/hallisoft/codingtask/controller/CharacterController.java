package com.hallisoft.codingtask.controller;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.hallisoft.codingtask.exception.ResourceNotFoundException;
import com.hallisoft.codingtask.model.CharacterEntity;
import java.util.List;

import com.hallisoft.codingtask.model.LocationEntity;
import com.hallisoft.codingtask.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

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

//    @PostMapping("/posts")
//    public Post createPost(@Valid @RequestBody Post post) {
//        return postRepository.save(post);
//    }
//
//    @PutMapping("/posts/{postId}")
//    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
//        return postRepository.findById(postId).map(post -> {
//            post.setTitle(postRequest.getTitle());
//            post.setDescription(postRequest.getDescription());
//            post.setContent(postRequest.getContent());
//            return postRepository.save(post);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }
//
//
//    @DeleteMapping("/posts/{postId}")
//    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
//        return postRepository.findById(postId).map(post -> {
//            postRepository.delete(post);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }

}