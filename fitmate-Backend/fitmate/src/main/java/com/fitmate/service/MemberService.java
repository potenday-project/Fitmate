package com.fitmate.service;

import com.fitmate.dto.MemberDto;
import com.fitmate.dto.ProfileImgDto;
import com.fitmate.entity.Member;
import com.fitmate.entity.ProfileImg;
import com.fitmate.repository.MemberRepository;
import com.fitmate.repository.ProfileImgRepository;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final ProfileImgRepository profileImgRepository;

    public Member saveMember(Member member) {
        validationDuplicateMember(member);
        return (Member)this.memberRepository.save(member);
    }

    public MemberDto getMemberInfo(String email) {
        Member member = this.memberRepository.findByEmail(email);
        return MemberDto.of(member);
    }

    public void saveProfileImg(ProfileImgDto profileImgDto, MultipartFile file) {
        Optional<ProfileImg> oImg = this.profileImgRepository.findById(profileImgDto.getId());
        if (oImg.isPresent()) {
            ProfileImg profileImg = oImg.get();
            profileImg.setMemberId(profileImgDto.getMemberId());
            profileImg.setStatus(profileImgDto.getStatus());
            profileImg.setUriPath("");
        } else {
            profileImgDto.setUriPath("");
            this.profileImgRepository.save(profileImgDto.createProfileImg(profileImgDto));
        }
    }

    private void validationDuplicateMember(Member member) {
        Member findMember = this.memberRepository.findByEmail(member.getEmail());
        if (findMember != null)
            throw new IllegalStateException("이미 가입된 회원입니다.");
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = this.memberRepository.findByEmail(email);

        if (member == null)
            throw new UsernameNotFoundException(email);

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
