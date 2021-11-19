package by.crims.mystore.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private CategoryOfProduct category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Seller seller;

    @Column(nullable = false)
    private String picture;

    @Column(nullable = false)
    private double price;

    private boolean reservedStatus;
    private boolean saleStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", seller=" + seller +
                ", reservedStatus=" + reservedStatus +
                ", saleStatus=" + saleStatus +
                '}';
    }
}
