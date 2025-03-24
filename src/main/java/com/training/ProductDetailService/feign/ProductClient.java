package com.training.ProductDetailService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductService", path = "/products")
public interface ProductClient {

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id);


}
