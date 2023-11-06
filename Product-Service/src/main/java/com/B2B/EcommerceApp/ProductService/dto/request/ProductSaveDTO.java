package com.B2B.EcommerceApp.ProductService.dto.request;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ProductSaveDTO {
    private String productName;

    private String productDescription;

    private float productPrice;

    private ProductStatus productStatus;

    private String productImage;

    private String supplierSyscoID;

    private String productMeasuringUnit;

    private String supplierName;
}
