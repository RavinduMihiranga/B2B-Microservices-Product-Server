package com.B2B.EcommerceApp.ProductService.service.impl;

import com.B2B.EcommerceApp.ProductService.dto.ProductDTO;
import com.B2B.EcommerceApp.ProductService.dto.paginated.*;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductAdminApprovalDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductSaveDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductUpdateDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.AdminDashboardApprovalPendingProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.CustomerDashboardProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardApprovalPendingProductsDTO;
import com.B2B.EcommerceApp.ProductService.dto.response.SupplierDashboardProductsDTO;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductStatus;
import com.B2B.EcommerceApp.ProductService.entity.Product;
import com.B2B.EcommerceApp.ProductService.exception.NotFoundException;
import com.B2B.EcommerceApp.ProductService.repo.ProductRepo;
import com.B2B.EcommerceApp.ProductService.service.ProductService;
import com.B2B.EcommerceApp.ProductService.util.mappers.ProductMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductMapper productMapper;

//    @Autowired
//    private APIClient apiClient;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductSaveDTO saveProduct(ProductSaveDTO productSaveDTO) {
        Product product = productMapper.ProductSaveDTO_to_ProductEntity(productSaveDTO);
        if (!productRepo.existsById(product.getProductID())) {
            productRepo.save(product);
            return productSaveDTO;
        } else {
            throw new DuplicateKeyException("Existing product");
        }
    }

    @Override
    public PaginatedCustomerDashboardProductsDTO getAllAvailableApprovedProducts(String productStatus, ProductApproval productApproval, int page, int size) {
        ProductStatus productStatus1 = ProductStatus.valueOf(productStatus);
        Page<Product> products = productRepo.findAllByProductStatusEqualsAndProductApprovalEqualsOrderByProductIDDesc(productStatus1, productApproval, PageRequest.of(page, size));
        if (!products.isEmpty()) {
            List<CustomerDashboardProductsDTO> list = productMapper.ProductEntityList_to_PaginatedCustomerDashboardList(products);

            return new PaginatedCustomerDashboardProductsDTO(
                    list,
                    productRepo.countAllByProductStatusEqualsAndProductApprovalEquals(productStatus1, productApproval)
            );

        } else {
            throw new NotFoundException("Products Not Found");
        }
    }

    @Override
    public ProductDTO getProductBySyscoID(String productSyscoID) {
        if (productRepo.existsByProductSyscoIDEquals(productSyscoID)) {
            Product product = productRepo.findByProductSyscoIDEquals(productSyscoID);
            return modelMapper.map(product, ProductDTO.class);
        } else {
            throw new NotFoundException("Product Not Found");
        }
    }

    @Override
    public ProductUpdateDTO updateProduct(int productID, ProductUpdateDTO productUpdateDTO) {
        if (productRepo.existsById(productID)) {
            Product product = productRepo.getReferenceById(productID);
            product.setProductDescription(productUpdateDTO.getProductDescription());
            product.setProductPrice(productUpdateDTO.getProductPrice());
            product.setProductStatus(productUpdateDTO.getProductStatus());
            product.setProductApproval(productUpdateDTO.getProductApproval());
            product.setProductSyscoID(productUpdateDTO.getProductSyscoID());
//          product.setProductImage(productUpdateDTO.getProductStatus());

            productRepo.save(product);
            return productUpdateDTO;
        } else {
            throw new NotFoundException("Product Not Found");
        }
    }

    @Override
    public String deleteProduct(int productID) {
        if (productRepo.existsById(productID)) {
            Product product = productRepo.findByProductID(productID);
            productRepo.delete(product);
            return "Deleted Successfully";
        } else {
            throw new NotFoundException("Product Not Found");
        }
    }

    @Override
    public PaginatedSupplierDashboardProductsDTO getAllProductsBySupplierIDByProductStatus(String supplierSyscoID, String productStatus, int page, int size) {
        ProductStatus productStatus1 = ProductStatus.valueOf(productStatus);
        ProductApproval productApproval = ProductApproval.valueOf("approved");
        Page<Product> products = productRepo.findAllBySupplierSyscoIDEqualsAndProductStatusEqualsAndProductApprovalEqualsOrderByProductIDDesc(supplierSyscoID, productStatus1, productApproval, PageRequest.of(page, size));
        if (!products.isEmpty()) {
            List<SupplierDashboardProductsDTO> list = productMapper.ProductEntity_to_PaginatedSupplierDashboardList(products);
            return new PaginatedSupplierDashboardProductsDTO(
                    list,
                    productRepo.countAllBySupplierSyscoIDEqualsAndProductStatusEqualsAndProductApprovalEquals(supplierSyscoID, productStatus1, productApproval)
            );
        } else {
            throw new NotFoundException("Products Not Found");
        }
    }

    @Override
    public PaginatedSupplierDashboardApprovalPendingProductsDTO getAllProductsBySupplierIDByProductApproval(String supplierSyscoID, String productApproval, int page, int size) {
        ProductApproval productApproval1 = ProductApproval.valueOf(productApproval);
        Page<Product> products = productRepo.findAllBySupplierSyscoIDEqualsAndProductApprovalEqualsOrderByProductIDDesc(supplierSyscoID, productApproval1, PageRequest.of(page, size));
        if (!products.isEmpty()) {
            List<SupplierDashboardApprovalPendingProductsDTO> list = productMapper.productEntityList_to_paginatedSupplierProductsDTO(products);
            return new PaginatedSupplierDashboardApprovalPendingProductsDTO(
                    list,
                    productRepo.countAllBySupplierSyscoIDEqualsAndProductApprovalEquals(supplierSyscoID, productApproval1)
            );
        } else {
            throw new NotFoundException("Products Not Found");
        }
    }

    @Override
    public PaginatedAdminDashboardProductsDTO getAllApprovalPendingProducts(ProductApproval productApproval, int page, int size) {
        Page<Product> products = productRepo.findAllByProductApprovalEqualsOrderByProductIDDesc(productApproval, PageRequest.of(page, size));
        if (!products.isEmpty()) {
            List<AdminDashboardApprovalPendingProductsDTO> list = productMapper.ProductEntityList_to_PaginatedAdminDashboardList(products);
            return new PaginatedAdminDashboardProductsDTO(
                    list,
                    productRepo.countAllByProductApprovalEquals(productApproval)
            );
//
        } else {
            throw new NotFoundException("Products Not Found");
        }
    }

    @Override
    public ProductDTO updateProductApproval(int productID, ProductAdminApprovalDTO productAdminApprovalDTO) {
        if (productRepo.existsById(productID)) {
            Product product = productRepo.findByProductID(productID);
            String approval = productAdminApprovalDTO.getProductApproval().toString();
            product.setProductApproval(productAdminApprovalDTO.getProductApproval());
            if (approval.equalsIgnoreCase("approved")) {
                product.setProductSyscoID(productAdminApprovalDTO.getProductSyscoID());
            }
            productRepo.save(product);
            return productMapper.ProductEntity_to_ProductDTO(product);
        } else {
            throw new NotFoundException("Product Not Found");
        }
    }

    @Override
    public ProductDTO getProductByID(int productID) {
        if (productRepo.existsById(productID)) {
            Product product = productRepo.findByProductID(productID);
            return productMapper.ProductEntity_to_ProductDTO(product);
        } else {
            throw new NotFoundException("Product Not Found");
        }
    }

    @Override
    public PaginatedAllProductsDTO getAllProductsByFilters(String supplierSyscoID, String productStatus, String approvalStatus, int page, int size) {
        ProductStatus productStatus1 = ProductStatus.valueOf(productStatus);
//        Admin & Customer Dashboards
        if(supplierSyscoID.equalsIgnoreCase("")){
            if(productStatus.equalsIgnoreCase("all") && (!approvalStatus.equalsIgnoreCase("all"))){
                ProductApproval productApproval = ProductApproval.valueOf(approvalStatus);
                Page<Product> products = productRepo.findAllByProductApprovalEqualsOrderByProductIDDesc(productApproval,PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.countAllByProductApprovalEquals(productApproval)
                    );
                } else{
                    throw new NotFoundException("Products Not Found");
                }
            } else if (!productStatus.equalsIgnoreCase("all") && (approvalStatus.equalsIgnoreCase("all"))){
                Page<Product> products = productRepo.findAllByProductStatusEqualsOrderByProductIDDesc(productStatus1, PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.countAllByProductStatusEquals(productStatus1)
                    );
                } else{
                    throw new NotFoundException("Products Not Found");
                }

            } else if(productStatus.equalsIgnoreCase("all") && (approvalStatus.equalsIgnoreCase("all"))){
                Page<Product> products = productRepo.findAll(PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.count()
                    );
                } else{
                    throw new NotFoundException("Products Not Found");
                }
            } else {
                ProductApproval productApproval = ProductApproval.valueOf(approvalStatus);
                Page<Product> products = productRepo.findAllByProductStatusEqualsAndProductApprovalEqualsOrderByProductIDDesc(productStatus1, productApproval, PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.countAllByProductStatusEqualsAndProductApprovalEquals(productStatus1, productApproval)
                    );
                } else{
                    throw new NotFoundException("Products Not Found");
                }
            }

//          Supplier Dashboard
        } else {
            if(productStatus.equalsIgnoreCase("all") && (!approvalStatus.equalsIgnoreCase("all"))){
                ProductApproval productApproval = ProductApproval.valueOf(approvalStatus);
                Page<Product> products = productRepo.findAllBySupplierSyscoIDEqualsAndProductApprovalEqualsOrderByProductIDDesc(supplierSyscoID, productApproval,PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.countAllBySupplierSyscoIDEqualsAndProductApprovalEquals(supplierSyscoID, productApproval)
                    );
                } else{
                    throw new NotFoundException("Products Not Found");
                }
            } else if (!productStatus.equalsIgnoreCase("all") && (approvalStatus.equalsIgnoreCase("all"))){
                Page<Product> products = productRepo.findAllBySupplierSyscoIDEqualsAndProductStatusEqualsOrderByProductIDDesc(supplierSyscoID, productStatus1, PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.countAllBySupplierSyscoIDEqualsAndProductStatusEquals(supplierSyscoID, productStatus1)
                    );
                } else{
                    throw new NotFoundException("Products Not Found");
                }

            } else if(productStatus.equalsIgnoreCase("all") && (approvalStatus.equalsIgnoreCase("all"))){
                Page<Product> products = productRepo.findAllBySupplierSyscoIDEqualsOrderByProductIDDesc(supplierSyscoID, PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.countAllBySupplierSyscoIDEquals(supplierSyscoID)
                    );
                } else{
                    throw new NotFoundException("Products Not Found");
                }
            } else {
                ProductApproval productApproval = ProductApproval.valueOf(approvalStatus);
                Page<Product> products = productRepo.findAllBySupplierSyscoIDEqualsAndProductStatusEqualsAndProductApprovalEqualsOrderByProductIDDesc(supplierSyscoID, productStatus1, productApproval, PageRequest.of(page, size));
                if (!products.isEmpty()) {
                    List<ProductDTO> list = productMapper.ProductEntityList_to_PaginatedAllPoductsDTOList(products);
                    return new PaginatedAllProductsDTO(
                            list,
                            productRepo.countAllBySupplierSyscoIDEqualsAndProductStatusEqualsAndProductApprovalEquals(supplierSyscoID, productStatus1, productApproval)
                    );
                } else {
                    throw new NotFoundException("Products Not Found");
                }
            }
        }
    }


}
