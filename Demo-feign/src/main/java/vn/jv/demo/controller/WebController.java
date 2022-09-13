package vn.jv.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.jv.demo.dao.ShopClient;
import vn.jv.demo.entities.Product;

@RestController
public class WebController {
	@Autowired
	private ShopClient shopClient;

	@GetMapping("/client")
	public String demo() {
		List<Product> obj = this.shopClient.getProducts();
		return  obj.toString();
	}
}
