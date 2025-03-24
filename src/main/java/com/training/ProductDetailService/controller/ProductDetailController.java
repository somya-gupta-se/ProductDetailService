package com.training.ProductDetailService.controller;

import com.training.ProductDetailService.entity.ProductDetail;
import com.training.ProductDetailService.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/product-details")
    public class ProductDetailController {

        @Autowired
        private ProductDetailService service;

        @PostMapping("/add")
        public ProductDetail addProductDetail(@RequestBody ProductDetail productDetail) {
            return service.addProductDetail(productDetail);
        }

        @GetMapping("/get/{productId}")
        public Optional<ProductDetail> getProductDetail(@PathVariable Long productId) {
            return service.getProductDetailByProductId(productId);
        }

        @GetMapping("/get/all")
        public List<ProductDetail> getAllProductDetails() {
            return service.getAllProductDetails();
        }

    @DeleteMapping("/{id}")
    public String deleteProductDetails(@PathVariable Long id) {
        service.deleteProduct(id);
        return "Product deleted successfully!";
    }
}
