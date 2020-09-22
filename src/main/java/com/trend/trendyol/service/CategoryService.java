package com.trend.trendyol.service;

import java.util.List;

import com.trend.trendyol.model.Category;

public interface CategoryService {

	public List<Category> findAll();

	public Category save(Category category);

	public Category getCateogry(Long id);

	public String updateCategory(Category category);

	public String deleteCategory(Long id);

	public String addChildCategory(Long parentCategoryId, Long childCategoryId);

}
