package com.B2B.EcommerceApp.ProductService.service;

import com.B2B.EcommerceApp.ProductService.util.StandardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8080", value = "User-Microservice")
public interface APIClient {

    @GetMapping(
            path = "/api/v1/users/get-user-by-sysco-id",
            params = "sysco_id"
    )
    StandardResponse getUserBySyscoId(@RequestParam(value = "sysco_id") String userSyscoID);

}
