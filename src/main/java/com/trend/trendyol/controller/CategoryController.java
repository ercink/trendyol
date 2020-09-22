package com.trend.trendyol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trend.trendyol.model.Category;
import com.trend.trendyol.service.CategoryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Get ALL Category
	@ApiOperation(value = "Get ALL Category")
//	@GetMapping("categories")
	@RequestMapping(method = RequestMethod.GET, value = "/categories")
	public List<Category> all() {
		return categoryService.findAll();
	}

	// Get SINGLE Category
	@ApiOperation(value = "Get SINGLE Category")
	@RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
	public Category getCateogry(@ApiParam(value = "Id of Category", required = true,example = "123") @PathVariable Long id) {
		return categoryService.getCateogry(id);
	}

	// POST for JSON ARRAY of Category
//	@PostMapping("/categories")
	@ApiOperation(value = "POST for JSON ARRAY of Category")
	@RequestMapping(method = RequestMethod.POST, value = "/category/bulk")
	public Category newCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}

	// UPDATE Category
	@ApiOperation(value = "UPDATE Category")
	@RequestMapping(method = RequestMethod.PUT, value = "/category")
	public String updateCategory(@ApiParam(value = "Two rules apply here:\n\n1.) You have to enter Category id\n2.) Enter the title property with its updated value", required = true,example = "123") 
	@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}

	// DELETE Category
	@ApiOperation(value = "DELETE Category")
	@RequestMapping(method = RequestMethod.DELETE, value = "/category/{id}")
	public String addChildCategory(@ApiParam(value = "Enter Category id to delete", required = true,example = "123") @PathVariable Long id) {
		return categoryService.deleteCategory(id);
	}
	
	// ADD Child Category
	@ApiOperation(value = "ADD Child Category")
	@RequestMapping(method = RequestMethod.PUT, value = "/category/addchildcategory")
	public String addChildCategory(@RequestParam("parentcategoryid") Long parentCategoryId, @RequestParam("childcategoryid") Long childCategoryId) {
		return categoryService.addChildCategory(parentCategoryId, childCategoryId);
	}
}
