package com.codedsalis.ecom.category;

import com.codedsalis.ecom.common.BaseEntity;
import com.codedsalis.ecom.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}
