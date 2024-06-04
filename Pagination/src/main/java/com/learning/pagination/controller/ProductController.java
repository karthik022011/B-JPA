package com.learning.pagination.controller;


import com.learning.pagination.model.ProductDTO;
import com.learning.pagination.service.ProductService;
import com.learning.pagination.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/admin/product/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
        ProductDTO savedProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(products);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
