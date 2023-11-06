package com.B2B.EcommerceApp.ProductService.dto.paginated;

import com.B2B.EcommerceApp.ProductService.dto.response.CustomerDashboardProductsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedCustomerDashboardProductsDTO {
    private List<CustomerDashboardProductsDTO> list;
    private long dataCount;
}
