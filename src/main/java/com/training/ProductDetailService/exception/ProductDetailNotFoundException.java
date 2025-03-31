package com.training.ProductDetailService.exception;

public class ProductDetailNotFoundException extends RuntimeException{
    public ProductDetailNotFoundException(String msg){
        super(msg);
    }
}
