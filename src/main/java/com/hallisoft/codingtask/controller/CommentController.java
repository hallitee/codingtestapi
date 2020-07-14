package com.hallisoft.codingtask.controller;

import com.hallisoft.codingtask.exception.ResourceNotFoundException;
import com.hallisoft.codingtask.model.CommentEntity;
import com.hallisoft.codingtask.repository.CommentRepository;
import com.hallisoft.codingtask.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @GetMapping
    public Page<CommentEntity> listComments( @RequestParam( defaultValue = "50") int size, @RequestParam( defaultValue = "1") int page,Pageable pageable){
        Sort sort =  Sort.by("created").descending();
        pageable = PageRequest.of(page-1,size, sort);
        return commentRepository.findAll(pageable);
    }

    @PostMapping("/{postId}/episode")
    public CommentEntity createComment(@PathVariable (value = "postId") Long postId,
                                @RequestBody CommentEntity comment)  throws ResourceNotFoundException{
        return episodeRepository.findById(postId).map(episode -> {
            comment.setEpisode(episode);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Record not found"));
    }

}