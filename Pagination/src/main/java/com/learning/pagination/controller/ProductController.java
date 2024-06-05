package com.learning.pagination.controller;


import com.learning.pagination.model.ProductDTO;
import com.learning.pagination.service.ProductService;
import com.learning.pagination.util.ApiResponse;
import com.learning.pagination.util.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/product-with-pagination")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProductsWithPagination(@RequestParam(value = "pageNumber",defaultValue = "0", required = true) int pageNo,
                                                                        @RequestParam(value = "pageSize", defaultValue = "2", required = true) int sizePerPage) {
        Page<ProductDTO>  page = productService.getAllProductsByPagination(pageNo, sizePerPage);
        List<ProductDTO> products = page.getContent();

        PaginationResponse<List<ProductDTO>> pageResponse = new PaginationResponse<>();
        pageResponse.setStatus(HttpStatus.OK.value());
        pageResponse.setSuccess(true);
        pageResponse.setMessage("Succeeded");
        pageResponse.setData(products);
        //page info
        pageResponse.setPageNumber(page.getNumber()+1);
        pageResponse.setPageSize(page.getSize());
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setLast(page.isLast());
        pageResponse.setTotalPages(page.getTotalPages());
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
    }

    @GetMapping("/product-sorted-by-price-asc-desc")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProductsSortedByPriceAscDesc(@RequestParam(value = "sortBy",defaultValue = "ID") String sortField,
                                                                                   @RequestParam(value = "sortDir", defaultValue = "DESC") String sortDirection) {
        List<ProductDTO> products = productService.getAllProductsSortedByPriceAscDesc(sortField, sortDirection);
        ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(products);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/product-sorted-by-price-multiple-fields")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProductsSortedByMultipleFields(@RequestParam(value = "sortByPrice",defaultValue = "ID") String sortByPrice,
                                                                                              @RequestParam(value = "sortByRating",defaultValue = "ID") String sortByRating,
                                                                                            @RequestParam(value = "sortDir", defaultValue = "DESC") String sortDirection) {
        List<ProductDTO> products = productService.getAllProductsSortedByMultipleFields(sortByPrice, sortByRating, sortDirection);
        ApiResponse<List<ProductDTO>> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setSuccess(true);
        response.setMessage("Succeeded");
        response.setData(products);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/product-pagination-sorting")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProductsPaginationSorting(@RequestParam(value = "pageNumber",defaultValue = "0", required = true) int pageNo,
                                                                                         @RequestParam(value = "pageSize", defaultValue = "2", required = true) int pageSize,
                                                                                         @RequestParam(value = "sort", defaultValue = "id, asc", required = true) String[] sortingParams) {
        Page<ProductDTO>  page = productService.getAllProductsByPaginationSorting(pageNo, pageSize, sortingParams);
        List<ProductDTO> products = page.getContent();

        PaginationResponse<List<ProductDTO>> pageResponse = new PaginationResponse<>();
        pageResponse.setStatus(HttpStatus.OK.value());
        pageResponse.setSuccess(true);
        pageResponse.setMessage("Succeeded");
        pageResponse.setData(products);
        //page info
        pageResponse.setPageNumber(page.getNumber()+1);
        pageResponse.setPageSize(page.getSize());
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setLast(page.isLast());
        pageResponse.setTotalPages(page.getTotalPages());
        return ResponseEntity.status(HttpStatus.OK).body(pageResponse);
    }
}
