package com.fitmate.dto;

import com.fitmate.entity.Comment;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class CommentDto {
    private Long id;

    private Long planId;

    private Long memberId;

    private String content;

    private String status;

    private Long writer;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private static ModelMapper modelMapper = new ModelMapper();

    public Comment createComment() {
        Comment comment = new Comment();
        comment.setPlanId(getPlanId());
        comment.setMemberId(getMemberId());
        comment.setContent(getContent());
        comment.setStatus(getStatus());
        return comment;
    }

    public static CommentDto of(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }
}
