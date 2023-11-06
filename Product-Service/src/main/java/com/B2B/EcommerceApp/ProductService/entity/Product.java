package com.B2B.EcommerceApp.ProductService.entity;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_ID", length = 10, updatable = false)
    private int productID;

    @Column(name = "product_sysco_ID", length = 100, unique = true)
    private String productSyscoID;

    @Column(name = "product_name", length = 50, nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false, length = 1000)
    private String productDescription;

    @Column(name = "product_price", length = 10, nullable = false)
    private float productPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_status", length = 20, nullable = false)
    private ProductStatus productStatus;

    @Column(name = "product_image", length = 1000)
    private String productImage;

    @Column(name = "supplier_sysco_ID", length = 50, nullable = false)
    private String supplierSyscoID;

    @Column(name = "product_measuring_unit", length = 10, nullable = false)
    private String productMeasuringUnit;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_approval", length = 10, nullable = false)
    private ProductApproval productApproval = ProductApproval.valueOf("pending");

    @Column(name = "supplier_name", length = 50, nullable = false)
    private String supplierName;
}
