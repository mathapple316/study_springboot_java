package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.ClearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("hyeonsu");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("ttt");
        Member member2 = new Member();
        member.setName("ttt2");
        repository.save(member);
        repository.save(member2);
        Member result = repository.findByName((member.getName())).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("hs");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("hs2");
        repository.save(member2);

        List<Member> res = repository.findAll();
        assertThat(res.size()).isEqualTo(2);
    }



}
