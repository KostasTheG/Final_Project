package com.techpro.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailsID")
    private int orderDetailsId;
//    @Column(name = "OrderID")
//    private int orderId;
//    @Column(name = "ItemID")
//    private int itemId;
    @Column(name = "Quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ItemID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Items items;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OrderId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Orders orders;

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

//    public int getItemId() {
//        return itemId;
//    }
//
//    public void setItemId(int itemId) {
//        this.itemId = itemId;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
