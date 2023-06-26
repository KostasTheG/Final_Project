package com.techpro.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "orders")
public class Orders {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderId;

    @Column(name = "PersonID")
    private int personId;
    @Column(name = "OrderDate")
    private LocalDateTime orderDate;


    public int getOrderId() {

        return orderId;
    }

    public void setOrderId(int orderId) {

        this.orderId = orderId;
    }

    public int getPersonId() {

        return personId;
    }

    public void setPersonId(int personId) {

        this.personId = personId;
    }

    public LocalDateTime getOrderDate() {

        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {

        this.orderDate = orderDate;
    }
}
