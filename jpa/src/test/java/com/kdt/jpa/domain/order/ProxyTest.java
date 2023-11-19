package com.kdt.jpa.domain.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@SpringBootTest
public class ProxyTest {

    @Autowired
    EntityManagerFactory emf;

    @BeforeEach
    void setUp() {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Order order = new Order();
        order.setUuid(UUID.randomUUID().toString());
        order.setMemo("부재시 전화주세요.");
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.OPENED);

        entityManager.persist(order);

        Member member = new Member();
        member.setName("kanghonggu");
        member.setNickName("guppy.kang");
        member.setAge(33);
        member.setAddress("서울시 동작구만 움직이면 쏜다.");
        member.setDescription("KDT 화이팅");

        member.addOrder(order);
        entityManager.persist(member);
        transaction.commit();
    }

    @Test
    void proxy() {
        EntityManager entityManager = emf.createEntityManager();

        Member findMember = entityManager.find(Member.class, 1L);

        log.info("orders is loaded : {}", entityManager.getEntityManagerFactory()
                .getPersistenceUnitUtil().isLoaded(findMember.getOrders()));

        log.info("-------");
        log.info("{}", findMember.getOrders().get(0).getMemo());
        log.info("orders is loaded : {}", entityManager.getEntityManagerFactory()
                .getPersistenceUnitUtil().isLoaded(findMember.getOrders()));
    }

    @Test
    void orphan() {
        EntityManager entityManager = emf.createEntityManager();

        Member findMember = entityManager.find(Member.class, 1L);
        findMember.getOrders().remove(0);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        transaction.commit();
    }
}
