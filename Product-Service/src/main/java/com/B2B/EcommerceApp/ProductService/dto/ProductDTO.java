package com.B2B.EcommerceApp.ProductService.dto;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ProductDTO {

    private int productID;

    private String productSyscoID;

    private String productName;

    private String productDescription;

    private float productPrice;

    private ProductStatus productStatus;

    private String productImage;

    private String supplierSyscoID;

    private String productMeasuringUnit;

    private ProductApproval productApproval;

    private String supplierName;
}
