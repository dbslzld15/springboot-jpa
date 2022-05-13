package org.prgrms.springjpa.domain.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;


    @Test
    void test() throws Exception {
        //given
        orderRepository.deleteAll();
        Order order = new Order();
        order.setUuid(UUID.randomUUID().toString());
        order.setOrderStatus(OrderStatus.OPENED);
        order.setOrderDatetime(LocalDateTime.now());
        order.setMemo("~~~");
        order.setCreatedBy("woojin");
        order.setCreatedAt(LocalDateTime.now());
        //when
        orderRepository.save(order);
        //then
        Order findOrder = orderRepository.findByMemo("~~~").get();
    }
}