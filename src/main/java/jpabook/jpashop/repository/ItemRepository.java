package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){    // 아이템은 JPA에 저장하기 전까지 id값이 없다
        if (item.getId() == null) { // 아이디 값이 없다면? 새로생성하는 객체!!
            em.persist(item);       // 신규 등록 .em.persist(item)
        } else {
            em.merge(item);         // 아이템 값이 있다? 디비에 등록된것을 가져온것 save || update같은 느낌으로 생각.
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
