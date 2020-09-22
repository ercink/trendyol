package com.trend.trendyol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trend.trendyol.model.Product;
import com.trend.trendyol.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// Get ALL Product
	@ApiOperation(value = "Get ALL Product")
	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public List<Product> all() {
		return productService.findAll();
	}

	// Get SINGLE Product
	@ApiOperation(value = "Get SINGLE Product")
	@RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
	public Product getProduct(@ApiParam(value = "Id of Product", required = true,example = "123") @PathVariable Long id) {
		return productService.getProduct(id);
	}

	// POST for JSON ARRAY of Product
	@ApiOperation(value = "POST for JSON ARRAY of Product")
	@RequestMapping(method = RequestMethod.POST, value = "/product/bulk")
	public Product newProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	// UPDATE Product
	@ApiOperation(value = "UPDATE Product")
	@RequestMapping(method = RequestMethod.PUT, value = "/product")
	public String updateProduct(@ApiParam(value = "Two rules apply here:\n\n1.) You have to enter Product id\n2.) Enter the title property with its updated value", required = true, example = "123") 
	@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	// DELETE Product
	@ApiOperation(value = "DELETE Product")
	@RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
	public String deleteProduct(@ApiParam(value = "Enter Product id to delete", required = true,example = "123") @PathVariable Long id) {
		return productService.deleteProduct(id);
	}
	
	// UPDATE Product Category
	@ApiOperation(value = "UPDATE Product Category")
	@RequestMapping(method = RequestMethod.PUT, value = "/product/updatecategory")
	public String updateProduct(@RequestParam("productid") Long productId, 
			@RequestParam("categoryid") Long categoryId)  {
		
		return productService.updateProductCategory(productId, categoryId);
	}
}
