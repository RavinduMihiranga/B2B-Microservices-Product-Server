package com.B2B.EcommerceApp.ProductService.util.mappers;

import com.B2B.EcommerceApp.ProductService.dto.ProductDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductSaveDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.AdminDashboardApprovalPendingProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.CustomerDashboardProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardApprovalPendingProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardProductsDTO;
import com.B2B.EcommerceApp.ProductService.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-06T00:10:03+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product ProductSaveDTO_to_ProductEntity(ProductSaveDTO productSaveDTO) {
        if ( productSaveDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductName( productSaveDTO.getProductName() );
        product.setProductDescription( productSaveDTO.getProductDescription() );
        product.setProductPrice( productSaveDTO.getProductPrice() );
        product.setProductStatus( productSaveDTO.getProductStatus() );
        product.setProductImage( productSaveDTO.getProductImage() );
        product.setSupplierSyscoID( productSaveDTO.getSupplierSyscoID() );
        product.setProductMeasuringUnit( productSaveDTO.getProductMeasuringUnit() );
        product.setSupplierName( productSaveDTO.getSupplierName() );

        return product;
    }

    @Override
    public List<CustomerDashboardProductsDTO> ProductEntityList_to_PaginatedCustomerDashboardList(Page<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<CustomerDashboardProductsDTO> list = new ArrayList<CustomerDashboardProductsDTO>();
        for ( Product product : products ) {
            list.add( productToCustomerDashboardProductsDTO( product ) );
        }

        return list;
    }

    @Override
    public List<SupplierDashboardProductsDTO> ProductEntity_to_PaginatedSupplierDashboardList(Page<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<SupplierDashboardProductsDTO> list = new ArrayList<SupplierDashboardProductsDTO>();
        for ( Product product : products ) {
            list.add( productToSupplierDashboardProductsDTO( product ) );
        }

        return list;
    }

    @Override
    public List<SupplierDashboardApprovalPendingProductsDTO> productEntityList_to_paginatedSupplierProductsDTO(Page<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<SupplierDashboardApprovalPendingProductsDTO> list = new ArrayList<SupplierDashboardApprovalPendingProductsDTO>();
        for ( Product product : products ) {
            list.add( productToSupplierDashboardApprovalPendingProductsDTO( product ) );
        }

        return list;
    }

    @Override
    public List<AdminDashboardApprovalPendingProductsDTO> ProductEntityList_to_PaginatedAdminDashboardList(Page<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<AdminDashboardApprovalPendingProductsDTO> list = new ArrayList<AdminDashboardApprovalPendingProductsDTO>();
        for ( Product product : products ) {
            list.add( productToAdminDashboardApprovalPendingProductsDTO( product ) );
        }

        return list;
    }

    @Override
    public ProductDTO ProductEntity_to_ProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductID( product.getProductID() );
        productDTO.setProductSyscoID( product.getProductSyscoID() );
        productDTO.setProductName( product.getProductName() );
        productDTO.setProductDescription( product.getProductDescription() );
        productDTO.setProductPrice( product.getProductPrice() );
        productDTO.setProductStatus( product.getProductStatus() );
        productDTO.setProductImage( product.getProductImage() );
        productDTO.setSupplierSyscoID( product.getSupplierSyscoID() );
        productDTO.setProductMeasuringUnit( product.getProductMeasuringUnit() );
        productDTO.setProductApproval( product.getProductApproval() );
        productDTO.setSupplierName( product.getSupplierName() );

        return productDTO;
    }

    @Override
    public List<ProductDTO> ProductEntityList_to_PaginatedAllPoductsDTOList(Page<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>();
        for ( Product product : products ) {
            list.add( ProductEntity_to_ProductDTO( product ) );
        }

        return list;
    }

    protected CustomerDashboardProductsDTO productToCustomerDashboardProductsDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        CustomerDashboardProductsDTO customerDashboardProductsDTO = new CustomerDashboardProductsDTO();

        customerDashboardProductsDTO.setProductSyscoID( product.getProductSyscoID() );
        customerDashboardProductsDTO.setProductName( product.getProductName() );
        customerDashboardProductsDTO.setProductPrice( product.getProductPrice() );
        customerDashboardProductsDTO.setProductImage( product.getProductImage() );
        customerDashboardProductsDTO.setSupplierName( product.getSupplierName() );
        customerDashboardProductsDTO.setProductMeasuringUnit( product.getProductMeasuringUnit() );

        return customerDashboardProductsDTO;
    }

    protected SupplierDashboardProductsDTO productToSupplierDashboardProductsDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        SupplierDashboardProductsDTO supplierDashboardProductsDTO = new SupplierDashboardProductsDTO();

        supplierDashboardProductsDTO.setProductSyscoID( product.getProductSyscoID() );
        supplierDashboardProductsDTO.setProductName( product.getProductName() );
        supplierDashboardProductsDTO.setProductImage( product.getProductImage() );
        supplierDashboardProductsDTO.setProductStatus( product.getProductStatus() );
        supplierDashboardProductsDTO.setProductApproval( product.getProductApproval() );

        return supplierDashboardProductsDTO;
    }

    protected SupplierDashboardApprovalPendingProductsDTO productToSupplierDashboardApprovalPendingProductsDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        SupplierDashboardApprovalPendingProductsDTO supplierDashboardApprovalPendingProductsDTO = new SupplierDashboardApprovalPendingProductsDTO();

        supplierDashboardApprovalPendingProductsDTO.setProductID( product.getProductID() );
        supplierDashboardApprovalPendingProductsDTO.setProductName( product.getProductName() );
        supplierDashboardApprovalPendingProductsDTO.setProductApproval( product.getProductApproval() );
        supplierDashboardApprovalPendingProductsDTO.setProductImage( product.getProductImage() );

        return supplierDashboardApprovalPendingProductsDTO;
    }

    protected AdminDashboardApprovalPendingProductsDTO productToAdminDashboardApprovalPendingProductsDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        AdminDashboardApprovalPendingProductsDTO adminDashboardApprovalPendingProductsDTO = new AdminDashboardApprovalPendingProductsDTO();

        adminDashboardApprovalPendingProductsDTO.setProductID( product.getProductID() );
        adminDashboardApprovalPendingProductsDTO.setProductName( product.getProductName() );
        adminDashboardApprovalPendingProductsDTO.setProductImage( product.getProductImage() );
        adminDashboardApprovalPendingProductsDTO.setSupplierName( product.getSupplierName() );

        return adminDashboardApprovalPendingProductsDTO;
    }
}
