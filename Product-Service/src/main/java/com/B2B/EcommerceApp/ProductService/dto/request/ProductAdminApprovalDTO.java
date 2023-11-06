package com.B2B.EcommerceApp.ProductService.dto.request;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ProductAdminApprovalDTO {
    private String productSyscoID;
    private ProductApproval productApproval;
}
