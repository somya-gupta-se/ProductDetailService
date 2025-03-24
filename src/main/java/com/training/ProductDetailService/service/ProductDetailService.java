package com.training.ProductDetailService.service;

import com.training.ProductDetailService.entity.ProductDetail;
import com.training.ProductDetailService.feign.ProductClient;
import com.training.ProductDetailService.repository.ProductDetailRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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

    @KafkaListener(topics = "productTopic", groupId = "productGroup")
    public void listenProduct(ConsumerRecord<String, String> record)

    {
        System.out.println(" Received Order Notification: Key: " + record.key() +
                ", Value: " + record.value());
    }


    public ProductDetail addProductDetail(ProductDetail productDetail) {
        return repository.save(productDetail);
    }

    public Optional<ProductDetail> getProductDetailByProductId(Long productId) {
        return repository.findByProductId(productId);
    }

    public List<ProductDetail> getAllProductDetails() {
        return repository.findAll();
    }

    public void deleteProduct(Long id) {
        productClient.deleteProduct(id);
        repository.deleteById(id);
    }
}
