package vn.jv.demo.dao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import vn.jv.demo.entities.Product;

@FeignClient("demo")
public interface ShopClient {
	 @GetMapping("/product")
	    public List<Product> getProducts();

}
