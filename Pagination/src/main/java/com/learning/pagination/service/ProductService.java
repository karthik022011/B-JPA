package com.learning.pagination.service;



import com.learning.pagination.model.ProductDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    Page<ProductDTO> getAllProductsByPagination(int pageNo, int pageSize);

    List<ProductDTO> getAllProductsSortedByPriceAscDesc(String sortByPrice,  String sortDirection);
    List<ProductDTO> getAllProductsSortedByMultipleFields(String sortByPrice, String sortByRating,  String sortDirection);

    Page<ProductDTO> getAllProductsByPaginationSorting(int pageNo, int pageSize, String[] sortingParams);
}
