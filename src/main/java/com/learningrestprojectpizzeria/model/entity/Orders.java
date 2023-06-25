package com.learningrestprojectpizzeria.model.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<MenuPositions> menuPosition;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private List<OrderDetailsEntity> orderDetails;

    @Column(name = "order_time")
    private Timestamp orderTime;

    public Orders(Integer quantity) {
        this.quantity = quantity;
    }
}