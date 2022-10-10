package br.com.sgsistemas.udemyproject.service;

import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.Product;
import br.com.sgsistemas.udemyproject.model.User;
import br.com.sgsistemas.udemyproject.repository.OrderRepository;
import br.com.sgsistemas.udemyproject.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> optionalUser =  orderRepository.findById(id);
        return optionalUser.get();
    }

    public Order insert(Order order){
        return orderRepository.save(order);
    }

    public void delete(Long id){
        orderRepository.deleteById(id);
    }

    public Order update(Long id, Order order){
        Order entity = orderRepository.getReferenceById(id);
        updateData(entity, order);
        return orderRepository.save(entity);
    }

    private void updateData(Order entity, Order order) {
        entity.setMoment(order.getMoment());
        entity.setOrderStatus(order.getOrderStatus());
        entity.setUser(order.getUser());
        entity.setItems(order.getItems());
    }
}
