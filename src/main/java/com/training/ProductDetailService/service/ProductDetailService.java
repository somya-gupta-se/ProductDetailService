package com.training.ProductDetailService.service;

import com.training.ProductDetailService.entity.ProductDetail;
import com.training.ProductDetailService.exception.ProductDetailNotFoundException;
import com.training.ProductDetailService.feign.ProductClient;
import com.training.ProductDetailService.repository.ProductDetailRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailRepository repository;


    @Autowired
    private ProductClient productClient;

    Logger LOGGER = LoggerFactory.getLogger(ProductDetailService.class);


    public ProductDetail addProductDetail(ProductDetail productDetail) {
        LOGGER.info("Product saved with details {}", productDetail);
        return repository.save(productDetail);
    }

    public ProductDetail getProductDetailByProductId(Long productId) {
        return repository.findByProductId(productId).orElseThrow(() -> new ProductDetailNotFoundException("Product with ID " + productId + " not found"));
    }

    public List<ProductDetail> getAllProductDetails() {
        return repository.findAll();
    }

    public void deleteProduct(Long id) {
        productClient.deleteProduct(id);
        repository.deleteById(id);
    }
}
