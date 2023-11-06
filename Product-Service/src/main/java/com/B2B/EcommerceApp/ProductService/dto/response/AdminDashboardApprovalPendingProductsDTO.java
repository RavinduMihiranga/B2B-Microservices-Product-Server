package com.B2B.EcommerceApp.ProductService.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data

public class AdminDashboardApprovalPendingProductsDTO {
    private int productID;

    private String productName;

    private String productImage;

    private String supplierName;

}
