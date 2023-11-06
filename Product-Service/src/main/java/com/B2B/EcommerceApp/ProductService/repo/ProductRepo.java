package com.B2B.EcommerceApp.ProductService.repo;

import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductApproval;
import com.B2B.EcommerceApp.ProductService.entity.Enum.ProductStatus;
import com.B2B.EcommerceApp.ProductService.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, Integer> {

    boolean existsByProductSyscoIDEquals(String productSyscoID);

    Product findByProductSyscoIDEquals(String productSyscoID);

//    List<Product> findAllByProductStatusEqualsOrderByProductIDDesc(ProductStatus productStatus1);

//    Page<Product> findAllBySupplierSyscoIDEqualsAndProductStatusEqualsOrderByProductIDDesc(String supplierSyscoID, ProductStatus productStatus1, Pageable pageable);

    Page<Product> findAllByProductStatusEqualsAndProductApprovalEqualsOrderByProductIDDesc(ProductStatus productStatus1, ProductApproval productApproval, Pageable pageable);

    Page<Product> findAllByProductApprovalEqualsOrderByProductIDDesc(ProductApproval productApproval, Pageable pageable);

    Product findByProductID(int productID);

    long countAllByProductApprovalEquals(ProductApproval productApproval);

    long countAllByProductStatusEqualsAndProductApprovalEquals(ProductStatus productStatus1, ProductApproval productApproval);

    Page<Product> findAllBySupplierSyscoIDEqualsAndProductStatusEqualsAndProductApprovalEqualsOrderByProductIDDesc(String supplierSyscoID, ProductStatus productStatus1, ProductApproval productApproval, Pageable pageable);

    long countAllBySupplierSyscoIDEqualsAndProductStatusEqualsAndProductApprovalEquals(String supplierSyscoID, ProductStatus productStatus1, ProductApproval productApproval);

    Page<Product> findAllBySupplierSyscoIDEqualsAndProductApprovalEqualsOrderByProductIDDesc(String supplierSyscoID, ProductApproval productApproval1, Pageable pageable);

    long countAllBySupplierSyscoIDEqualsAndProductApprovalEquals(String supplierSyscoID, ProductApproval productApproval1);

    Page<Product> findAllByProductStatusEqualsOrderByProductIDDesc(ProductStatus productStatus1, Pageable pageable);

    long countAllByProductStatusEquals(ProductStatus productStatus1);

    Page<Product> findAllBySupplierSyscoIDEqualsAndProductStatusEqualsOrderByProductIDDesc(String supplierSyscoID, ProductStatus productStatus1, PageRequest of);

    long countAllBySupplierSyscoIDEqualsAndProductStatusEquals(String supplierSyscoID, ProductStatus productStatus1);

    Page<Product> findAllBySupplierSyscoIDEqualsOrderByProductIDDesc(String supplierSyscoID, PageRequest of);

    long countAllBySupplierSyscoIDEquals(String supplierSyscoID);
}
