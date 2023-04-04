package com.fitmate.dto;

import com.fitmate.entity.ProfileImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter @Setter
public class ProfileImgDto {
    private Long id;

    private Long memberId;

    private String uriPath;

    private String status;

    private static ModelMapper modelMapper = new ModelMapper();

    public ProfileImg createProfileImg(ProfileImgDto profileImgDto) {
        return modelMapper.map(this, ProfileImg.class);
    }
}
