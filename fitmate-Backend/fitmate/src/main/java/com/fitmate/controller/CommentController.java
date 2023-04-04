package com.fitmate.controller;

import com.fitmate.dto.CommentDto;
import com.fitmate.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value="/comment")
    public void saveComment(@RequestBody CommentDto commentDto) {
        commentService.saveComment(commentDto);
    }
}
