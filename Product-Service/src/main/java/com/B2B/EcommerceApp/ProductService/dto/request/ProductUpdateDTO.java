package com.B2B.EcommerceApp.ProductService.dto.request;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ProductUpdateDTO {
    private String productSyscoID;

    private ProductApproval productApproval;

    private String productDescription;

    private float productPrice;

    private ProductStatus productStatus;

//    private String productImage;
}
