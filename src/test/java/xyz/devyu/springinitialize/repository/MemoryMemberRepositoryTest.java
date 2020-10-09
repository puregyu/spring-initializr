package xyz.devyu.springinitialize.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import xyz.devyu.springinitialize.domain.Member;
import xyz.devyu.springinitialize.ropository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // TestCase Method가 끝날 때 마다 동작하는 코드
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("devyu");
        repository.save(member);

        Optional<Member> getMember = repository.findById(member.getId());

        Assertions.assertEquals(member, getMember.get());
        assertThat(member).isEqualTo(getMember.get());
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("devyu");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("puregyu");
        repository.save(member2);

        Optional<Member> getMember = repository.findByName("devyu");
        assertThat(getMember.get().getName()).isEqualTo(member1.getName());
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("devyu");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("puregyu");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("min");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("gyu");
        repository.save(member4);

        List<Member> memList= new ArrayList<>();
        memList.add(member1);
        memList.add(member2);
        memList.add(member3);
        memList.add(member4);

        List<Member> getAll = repository.findAll();
        assertThat(getAll).isEqualTo(memList);

    }
}
