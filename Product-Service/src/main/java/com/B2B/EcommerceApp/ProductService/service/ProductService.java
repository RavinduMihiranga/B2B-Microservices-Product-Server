package com.B2B.EcommerceApp.ProductService.service;

import com.B2B.EcommerceApp.ProductService.dto.ProductDTO;
import com.B2B.EcommerceApp.ProductService.dto.paginated.*;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductAdminApprovalDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductSaveDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductUpdateDTO;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;

public interface ProductService {
    ProductSaveDTO saveProduct(ProductSaveDTO productSaveDTO);

    PaginatedCustomerDashboardProductsDTO getAllAvailableApprovedProducts(String productStatus, ProductApproval productApproval, int page, int size);

    ProductDTO getProductBySyscoID(String productSyscoID);

    ProductUpdateDTO updateProduct(int productID, ProductUpdateDTO productUpdateDTO);

    String deleteProduct(int productID);

    PaginatedSupplierDashboardProductsDTO getAllProductsBySupplierIDByProductStatus(String supplierSyscoID, String productStatus, int page, int size);

    PaginatedSupplierDashboardApprovalPendingProductsDTO getAllProductsBySupplierIDByProductApproval(String supplierSyscoID, String productApproval, int page, int size);

    PaginatedAdminDashboardProductsDTO getAllApprovalPendingProducts(ProductApproval productApproval, int page, int size);

    ProductDTO updateProductApproval(int productID, ProductAdminApprovalDTO productAdminApprovalDTO);

    ProductDTO getProductByID(int productID);

    PaginatedAllProductsDTO getAllProductsByFilters(String supplierSyscoID, String productStatus, String approvalStatus, int page, int size);


//    PaginatedCustomerDashboardProductsDTO getAllAvailableProductsWithPaginated(String productStatus, int page, int size);
//
//    ProductDetailsDTO getProductBySyscoID(String productSyscoID);

}
