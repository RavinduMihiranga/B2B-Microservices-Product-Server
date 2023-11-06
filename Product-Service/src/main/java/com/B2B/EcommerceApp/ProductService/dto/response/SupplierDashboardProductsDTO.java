package com.B2B.EcommerceApp.ProductService.dto.response;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class SupplierDashboardProductsDTO {
    private String productSyscoID;
    private String productName;
    private String productImage;
    private ProductStatus productStatus;
    private ProductApproval productApproval;
}
