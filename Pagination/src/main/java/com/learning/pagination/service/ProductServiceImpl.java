package com.learning.pagination.service;

import com.learning.pagination.entity.Product;
import com.learning.pagination.model.ProductDTO;
import com.learning.pagination.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        return modelMapper.map(products, listType);
    }

    @Override
    public Page<ProductDTO> getAllProductsByPagination(int pageNo, int pageSize) {
        // create pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> page = productRepository.findAll(pageable);
        Type listType = new TypeToken<Page<ProductDTO>>(){}.getType();
        return modelMapper.map(page, listType);
    }

    @Override
    public List<ProductDTO> getAllProductsSortedByPriceAscDesc(String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortField).ascending(): Sort.by(sortField).descending();
        List<Product> products = productRepository.findAll(sort);
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        return modelMapper.map(products, listType);
    }

    @Override
    public List<ProductDTO> getAllProductsSortedByMultipleFields(String sortByPrice, String sortByRating,  String sortDirection) {
        Sort sortPrice = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortByPrice).ascending(): Sort.by(sortByPrice).descending();
        Sort sortRating = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortByRating).ascending(): Sort.by(sortByRating).descending();
        Sort groupBySort = sortPrice.and(sortRating);
        List<Product> products = productRepository.findAll(groupBySort);
        Type listType = new TypeToken<List<ProductDTO>>(){}.getType();
        return modelMapper.map(products, listType);
    }

    @Override
    public Page<ProductDTO> getAllProductsByPaginationSorting(int pageNo, int pageSize, String[] sortingParams) {
        String field = sortingParams[0];
        String sortingDirection = sortingParams[1];
        Sort.Direction direction = sortingDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(direction, field));
        Page<Product> page = productRepository.findAll(pageable);
        Type listType = new TypeToken<Page<ProductDTO>>(){}.getType();
        return modelMapper.map(page, listType);
    }


}
