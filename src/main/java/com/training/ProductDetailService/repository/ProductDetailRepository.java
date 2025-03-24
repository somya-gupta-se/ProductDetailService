package com.training.ProductDetailService.repository;

import com.training.ProductDetailService.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
    Optional<ProductDetail> findByProductId(Long productId);
}
