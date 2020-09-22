package com.trend.trendyol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trend.trendyol.model.Cart;
import com.trend.trendyol.service.CartService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	// Get ALL Cart
	@ApiOperation(value = "Get ALL Cart")
	@RequestMapping(method = RequestMethod.GET, value = "/carts")
	public List<Cart> all() {
		return cartService.findAll();
	}

	// Get SINGLE Cart
	@ApiOperation(value = "Get SINGLE Cart")
	@RequestMapping(method = RequestMethod.GET, value = "/cart/{id}")
	public Cart getCart(@ApiParam(value = "Id of Carts", required = true,example = "123") @PathVariable Long id) {
		return cartService.getCart(id);
	}

	// POST for JSON ARRAY of Cart
	@ApiOperation(value = "POST for JSON ARRAY of Cart")
	@RequestMapping(method = RequestMethod.POST, value = "/cart/bulk")
	public Cart newCart(@RequestBody Cart cart) {
		return cartService.save(cart);
	}

	// UPDATE Cart
	@ApiOperation(value = "UPDATE Cart")
	@RequestMapping(method = RequestMethod.PUT, value = "/cart")
	public String updateCart(@ApiParam(value = "Two rules apply here:\n\n1.) You have to enter Cart id\n2.) Enter the code property with its updated value", required = true, example = "123") 
	@RequestBody Cart cart) {
		return cartService.updateCart(cart);
	}

	// DELETE Cart
	@ApiOperation(value = "DELETE Cart")
	@RequestMapping(method = RequestMethod.DELETE, value = "/cart/{id}")
	public String deleteCart(@ApiParam(value = "Enter Cart id to delete", required = true,example = "123") @PathVariable Long id) {
		return cartService.deleteCart(id);
	}
}
