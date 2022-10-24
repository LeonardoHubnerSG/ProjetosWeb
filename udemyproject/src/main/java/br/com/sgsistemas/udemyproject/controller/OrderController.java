package br.com.sgsistemas.udemyproject.controller;

import br.com.sgsistemas.udemyproject.model.Order;
import br.com.sgsistemas.udemyproject.model.Product;
import br.com.sgsistemas.udemyproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order order){
        order = orderService.insert(order);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity.created(uri).body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody Order order){
        order = orderService.update(id, order);
        return ResponseEntity.ok().body(order);
    }
}
