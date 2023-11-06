package com.B2B.EcommerceApp.ProductService.dto.paginated;

import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardProductsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedSupplierDashboardProductsDTO {
    private List<SupplierDashboardProductsDTO> list;
    private long dataCount;
}
