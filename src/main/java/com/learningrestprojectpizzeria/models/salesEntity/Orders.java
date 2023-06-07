package com.learningrestprojectpizzeria.models.salesEntity;
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
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Quantity")
    private Integer quantity;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "OrdersId")
    private List<OrderDetails> orderDetails;

    @Column(name = "OrderTime")
    private Timestamp orderTime;

    public Orders(Integer quantity) {
        this.quantity = quantity;
    }
}