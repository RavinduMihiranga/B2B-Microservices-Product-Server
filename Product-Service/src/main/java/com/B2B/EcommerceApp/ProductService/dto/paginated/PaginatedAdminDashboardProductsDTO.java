package com.B2B.EcommerceApp.ProductService.dto.paginated;

import com.B2B.EcommerceApp.ProductService.dto.response.AdminDashboardApprovalPendingProductsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedAdminDashboardProductsDTO {
    private List<AdminDashboardApprovalPendingProductsDTO> list;
    private long dataCount;
}
