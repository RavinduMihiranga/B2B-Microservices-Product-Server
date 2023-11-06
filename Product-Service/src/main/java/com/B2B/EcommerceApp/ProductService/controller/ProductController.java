package com.B2B.EcommerceApp.ProductService.controller;

import com.B2B.EcommerceApp.ProductService.dto.ProductDTO;
import com.B2B.EcommerceApp.ProductService.dto.paginated.*;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductAdminApprovalDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductSaveDTO;
import com.B2B.EcommerceApp.ProductService.dto.request.ProductUpdateDTO;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import com.B2B.EcommerceApp.ProductService.service.ProductService;
import com.B2B.EcommerceApp.ProductService.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<StandardResponse> saveProduct(@RequestBody ProductSaveDTO productSaveDTO) {
        ProductSaveDTO productSaveDTO1 = productService.saveProduct(productSaveDTO);
        return new ResponseEntity<>(
                new StandardResponse(201, "saved successfully", productSaveDTO1), HttpStatus.CREATED
        );
    }

    //    Admin Dashboard
    @PutMapping(
            path = "/update-approval",
            params = "id"
    )
    public ResponseEntity<StandardResponse> updateProductApproval(@RequestParam(value = "id") int productID, @RequestBody ProductAdminApprovalDTO productAdminApprovalDTO) {
        ProductDTO productDTO = productService.updateProductApproval(productID, productAdminApprovalDTO);
        return new ResponseEntity<>(
                new StandardResponse(204, "updated successfully", productDTO), HttpStatus.OK);
    }

    //    Supplier Dashboard
    @PutMapping(
            params = "id"
    )
    public ResponseEntity<StandardResponse> updateProduct(@RequestParam(value = "id") int productID, @RequestBody ProductUpdateDTO productUpdateDTO) {
        ProductUpdateDTO productUpdateDTO1 = productService.updateProduct(productID, productUpdateDTO);
        return new ResponseEntity<>(
                new StandardResponse(204, "updated successfully", productUpdateDTO1), HttpStatus.OK);
    }


    @DeleteMapping(
            params = "id"
    )
    public ResponseEntity<StandardResponse> deleteProduct(@RequestParam(value = "id") int productID) {
        return new ResponseEntity<>(
                new StandardResponse(204, "deleted successfully", productService.deleteProduct(productID)), HttpStatus.OK);
    }

    @GetMapping(
            path = "/get-products-by-supplier",
            params = {
                    "supplier_sysco_id",
                    "product_status",
                    "page",
                    "size"
            }

    )
    public ResponseEntity<StandardResponse> getAllProductsBySupplierByProductStatus(
            @RequestParam(value = "supplier_sysco_id") String supplierSyscoID,
            @RequestParam(value = "product_status") String productStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        PaginatedSupplierDashboardProductsDTO products = productService.getAllProductsBySupplierIDByProductStatus(supplierSyscoID, productStatus, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "found successfully", products), HttpStatus.OK);
    }

    @GetMapping(
            path = "/get-approved-products-by-supplier",
            params = {
                    "supplier_sysco_id",
                    "product_approval",
                    "page",
                    "size"
            }

    )
    public ResponseEntity<StandardResponse> getAllProductsBySupplierByProductApproval(
            @RequestParam(value = "supplier_sysco_id") String supplierSyscoID,
            @RequestParam(value = "product_approval") String productApproval,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        PaginatedSupplierDashboardApprovalPendingProductsDTO productDTOS = productService.getAllProductsBySupplierIDByProductApproval(supplierSyscoID, productApproval, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "found successfully", productDTOS), HttpStatus.OK);
    }

    //    Customer Dashboard
    @GetMapping(
            params = {
                    "page",
                    "size"
            }
    )
    public ResponseEntity<StandardResponse> getAllAvailableApprovedProducts(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        ProductApproval productApproval = ProductApproval.valueOf("approved");
        PaginatedCustomerDashboardProductsDTO products = productService.getAllAvailableApprovedProducts("available", productApproval, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "found successfully", products), HttpStatus.OK);
    }

    // get product details for customer/supplier dashboard
    @GetMapping(
            path = "/get-product-by-sysco-id",
            params = "sysco_id"
    )
    public ResponseEntity<StandardResponse> getProductBySyscoId(@RequestParam(value = "sysco_id") String productSyscoID) {
        return new ResponseEntity<>(
                new StandardResponse(200, "found successfully", productService.getProductBySyscoID(productSyscoID)), HttpStatus.OK);
    }


    //    Admin Dashboard
    @GetMapping(
            path = "get-product-for-admin-dashboard",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getProductById(@RequestParam(value = "id") int productID) {
        return new ResponseEntity<>(
                new StandardResponse(200, "found successfully", productService.getProductByID(productID)), HttpStatus.OK);
    }

    // get approval pending product details for admin dashboard
    @GetMapping(
            path = "/get-approval-pending-products",
            params = {
                    "approval_status",
                    "page",
                    "size"
            }

    )
    public ResponseEntity<StandardResponse> getApprovalPendingProducts(
            @RequestParam(value = "approval_status") String approvalStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        ProductApproval productApproval = ProductApproval.valueOf(approvalStatus);
        PaginatedAdminDashboardProductsDTO products = productService.getAllApprovalPendingProducts(productApproval, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "found successfully", products), HttpStatus.OK);
    }

    @GetMapping(
            path = "/get-all-products",
            params = {
                    "supplier_sysco_id",
                    "product_status",
                    "approval_status",
                    "page",
                    "size"
            }

    )
    public ResponseEntity<StandardResponse> getAllProducts(
            @RequestParam(value = "supplier_sysco_id") String supplierSyscoID,
            @RequestParam(value = "product_status") String productStatus,
            @RequestParam(value = "approval_status") String approvalStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        System.out.println(supplierSyscoID);
        PaginatedAllProductsDTO products = productService.getAllProductsByFilters(supplierSyscoID, productStatus, approvalStatus,page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "found successfully", products), HttpStatus.OK);
    }

}
