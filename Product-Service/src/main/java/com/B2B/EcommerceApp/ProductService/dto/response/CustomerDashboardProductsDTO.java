package com.B2B.EcommerceApp.ProductService.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data

public class CustomerDashboardProductsDTO {
    private String productSyscoID;
    private String productName;
    private float productPrice;
    private String productImage;
    private String supplierName;
    private String productMeasuringUnit;
}
