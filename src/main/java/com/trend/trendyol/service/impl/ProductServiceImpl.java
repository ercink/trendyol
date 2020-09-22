package com.trend.trendyol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trend.trendyol.model.Category;
import com.trend.trendyol.model.Product;
import com.trend.trendyol.repository.CategoryRepository;
import com.trend.trendyol.repository.ProductRepository;
import com.trend.trendyol.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public String updateProduct(Product product) {
		Product productOld = productRepository.findById(product.getId()).orElse(null);

		if (productOld != null) {
			if (product.getTitle() != null) {
				productOld.setTitle(product.getTitle());
			}
			productRepository.save(productOld);
			return "OK";
		} else {
			return "ERROR! ID NOT FOUND ON DATABASE.";
		}
	}

	@Override
	public String deleteProduct(Long id) {
		// categoryRepository.deleteById(id)
		Product category = productRepository.findById(id).orElse(null);
		if (category != null) {
			productRepository.delete(category);
			return "OK";

		} else {
			return "ERROR! ID NOT FOUND.";
		}
	}

	@Override
	public String updateProductCategory(Long productId, Long categoryId) {
		Product product = productRepository.findById(productId).orElse(null);
		Category category = categoryRepository.findById(categoryId).orElse(null);
		
		if(category == null || product == null) {
			return "ERROR! ID NOT FOUND.";
		}
		
		product.setCategoryRefId(category.getId());
		productRepository.save(product);
		return "OK";
	}
}
