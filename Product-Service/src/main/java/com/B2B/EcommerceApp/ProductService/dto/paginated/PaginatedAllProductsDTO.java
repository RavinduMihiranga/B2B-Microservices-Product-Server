package com.B2B.EcommerceApp.ProductService.dto.paginated;

import com.B2B.EcommerceApp.ProductService.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedAllProductsDTO {
    private List<ProductDTO> list;
    private long dataCount;
}
