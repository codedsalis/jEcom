package com.codedsalis.ecom.product;

import com.codedsalis.ecom.category.Category;
import com.codedsalis.ecom.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String currency;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Integer getPrice() {
        return price / 100;
    }
}
