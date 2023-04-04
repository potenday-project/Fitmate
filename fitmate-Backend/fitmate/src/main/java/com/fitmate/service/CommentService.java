package com.fitmate.service;

import com.fitmate.dto.CommentDto;
import com.fitmate.entity.Comment;
import com.fitmate.repository.CommentRepository;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void saveComment(CommentDto commentDto) {
        Long id = commentDto.getId();
        Optional<Comment> oComment = this.commentRepository.findById(id);
        if (oComment.isPresent()) {
            Comment comment = oComment.get();
            comment.updateComment(commentDto);
        } else {
            this.commentRepository.save(commentDto.createComment());
        }
    }
}
