package xyz.devyu.springinitialize.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import xyz.devyu.springinitialize.domain.Member;
import xyz.devyu.springinitialize.ropository.MemberRepository;
import xyz.devyu.springinitialize.ropository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * 서버스 단에서 메서드 name은 비지니스 로직에 가깝게 설계하는 것이 좋다.
 */
@Service
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        vaildateDuplicateMember(member);
        return memberRepository.save(member).getId();
    }

    private void vaildateDuplicateMember(Member member) {
        // 같은 이름의 중복 회원 허용X
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원명 입니다.");
            });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 ID를 통한 회원 조회
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
