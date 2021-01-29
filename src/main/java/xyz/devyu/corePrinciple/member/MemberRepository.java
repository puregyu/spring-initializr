package xyz.devyu.corePrinciple.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
