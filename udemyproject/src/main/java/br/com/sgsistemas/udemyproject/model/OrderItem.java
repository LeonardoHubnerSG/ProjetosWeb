package br.com.sgsistemas.udemyproject.model;

import br.com.sgsistemas.udemyproject.model.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order_item")
@Data
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @JsonIgnore
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem() {
    }

    public Double getSubTotal(){
        return this.quantity * this.price;
    }

    @JsonIgnore
    public Order getOrder(){
        return this.id.getOrder();
    }

    public void setOrder(Order order){
        this.id.setOrder(order);
    }

    public Product getProduct(){
        return this.id.getProduct();
    }

    public void setProduct(Product product){
        this.id.setProduct(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
