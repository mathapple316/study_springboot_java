package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    @Autowired
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member found = em.find(Member.class, id);
        return Optional.ofNullable(found);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> found = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return found.stream().findAny();

    }

    @Override
    public List<Member> findAll() {
        // jpql이라는 객체지향 쿼리사용함
        List<Member> found = em.createQuery("select m from Member m", Member.class).getResultList();
        return found;
    }
}
