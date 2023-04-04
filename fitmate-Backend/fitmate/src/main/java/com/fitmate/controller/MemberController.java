package com.fitmate.controller;

import com.fitmate.dto.MemberDto;
import com.fitmate.dto.MemberFormDto;
import com.fitmate.dto.ProfileImgDto;
import com.fitmate.entity.Member;
import com.fitmate.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"/members"})
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value="/signUp")
    public String signUp(MemberFormDto memberFormDto) {
        Member member = Member.createMember(memberFormDto, this.passwordEncoder);
        this.memberService.saveMember(member);
        return "redirect:/loginForm";
    }

    @GetMapping(value="/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping(value="/signUpForm")
    public String signUpForm() {
        return "signUpForm";
    }

    @GetMapping(value="/my")
    public MemberDto getMemberInfo(String email) {
        return this.memberService.getMemberInfo(email);
    }

    @PostMapping(value="/img")
    public void saveProfileImg(ProfileImgDto profileImgDto, @RequestPart MultipartFile file) {
        this.memberService.saveProfileImg(profileImgDto, file);
    }
}
