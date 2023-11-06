package com.B2B.EcommerceApp.ProductService.util.mappers;

import com.B2B.EcommerceApp.ProductService.dto.ProductDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductSaveDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.AdminDashboardApprovalPendingProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.CustomerDashboardProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardApprovalPendingProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardProductsDTO;
import com.B2B.EcommerceApp.ProductService.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product ProductSaveDTO_to_ProductEntity(ProductSaveDTO productSaveDTO);

    List<CustomerDashboardProductsDTO> ProductEntityList_to_PaginatedCustomerDashboardList(Page<Product> products);

    List<SupplierDashboardProductsDTO> ProductEntity_to_PaginatedSupplierDashboardList(Page<Product> products);

    List<SupplierDashboardApprovalPendingProductsDTO> productEntityList_to_paginatedSupplierProductsDTO(Page<Product> products);

    List<AdminDashboardApprovalPendingProductsDTO> ProductEntityList_to_PaginatedAdminDashboardList(Page<Product> products);

    ProductDTO ProductEntity_to_ProductDTO(Product product);

    List<ProductDTO> ProductEntityList_to_PaginatedAllPoductsDTOList(Page<Product> products);
}
