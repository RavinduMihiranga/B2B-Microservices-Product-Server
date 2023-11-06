package com.B2B.EcommerceApp.ProductService.dto.response;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class SupplierDashboardApprovalPendingProductsDTO {
    private int productID;
    private String productName;
    private ProductApproval productApproval;
    private String productImage;
}