package com.B2B.EcommerceApp.ProductService.dto.paginated;

import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardApprovalPendingProductsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedSupplierDashboardApprovalPendingProductsDTO {
    private List<SupplierDashboardApprovalPendingProductsDTO> list;
    private long dataCount;
}
