package jpabook.jpashop.domain.repository;


import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        em.persist(member);
    } // persist로 영속성 컨텍스트에 멤버엔티티를 넣으면 트랜잭션이 커밋 되는 시점에
    // 디비에 반영 ( 디비에 insert 쿼리가 날라가는 거임 )

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }
    // jpa의 find 메소드 사용 단권 조회? ( 첫번째(타입), PK )

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
    //JPQL 사용 SQL이랑 거의 비슷한데 from의 대상이 테이블이아니라 엔티티이다 Member m

    public List<Member> findbyName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
    //파라미터 바인딩으로 특정 회원이름만 찾는로직

}
