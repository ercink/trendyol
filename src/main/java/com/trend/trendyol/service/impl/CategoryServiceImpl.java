package com.trend.trendyol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trend.trendyol.constant.DataUtil;
import com.trend.trendyol.model.Category;
import com.trend.trendyol.repository.CategoryRepository;
import com.trend.trendyol.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category getCateogry(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public String updateCategory(Category category) {
		Category categoryOld = categoryRepository.findById(category.getId()).orElse(null);

		if (categoryOld != null) {
			if (!DataUtil.isNullOrEmpty(category.getTitle())) {
				categoryOld.setTitle(category.getTitle());
			}
			categoryRepository.save(categoryOld);
			return "OK";
		} else {
			return "ERROR! ID NOT FOUND ON DATABASE.";
		}
	}

	@Override
	public String deleteCategory(Long id) {
		// categoryRepository.deleteById(id)
		Category category = categoryRepository.findById(id).orElse(null);
		if (category != null) {
			if(category.getChildren() != null) {
				return "ERROR! CATEGORY HAS CHILD";
			}
			categoryRepository.delete(category);
			return "OK";

		} else {
			return "ERROR! ID NOT FOUND.";
		}
	}

	@Override
	public String addChildCategory(Long parentCategoryId, Long childCategoryId) {
		Category parentCategory = categoryRepository.findById(parentCategoryId).orElse(null);
		Category childCategory = categoryRepository.findById(childCategoryId).orElse(null);
		if (childCategory != null || parentCategory != null) {
			parentCategory.getChildren().add(childCategory);
			categoryRepository.save(parentCategory);
			return "OK";
		}else {
			return "ERROR! ID NOT FOUND.";
		}
	}
}
