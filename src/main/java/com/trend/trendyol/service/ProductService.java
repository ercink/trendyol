package com.trend.trendyol.service;

import java.util.List;

import com.trend.trendyol.model.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product save(Product product);

	public Product getProduct(Long id);

	public String updateProduct(Product product);

	public String deleteProduct(Long id);

	public String updateProductCategory(Long productId, Long categoryId);

}
