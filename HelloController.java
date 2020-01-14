package com.deloitte.deloittespringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.deloittespringboot.model.Product;
import com.deloitte.deloittespringboot.service.ProductService;

@RestController
public class HelloController {
	
//	@GetMapping("/hello")
//	public String sayHello(Model m) {
//		
//		m.addAttribute("msg", "How are you?");
//		return "show";
//	}
	
	@Autowired
	ProductService service;
	
	@PostMapping("/products")                //used to add something
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		ResponseEntity<Product> productResponse=new ResponseEntity<Product>(service.saveProduct(product),HttpStatus.CREATED);
		return productResponse;
	}
 	
	@GetMapping("/products")                  //used to fetch something
	public List<Product> getAllProducts(){
		return service.getAllProduct();
	}
	
	@GetMapping("/products/{pid}")                  //used to fetch something
	public Product getProductById(@PathVariable("pid")int pid){
		return service.getProduct(pid);
	}
	
	@GetMapping("/products/name/{prodName}")                  //used to fetch something
	public Product findByProductName(@PathVariable("prodName")String pName){
		return service.findByproductProdName(pName);
	}
	
	@GetMapping("/products/name/{prodName}/price/{price}")                  //used to fetch something
	public Product findByProductNameAndPrice(@PathVariable("prodName") String prodName, @PathVariable("price")float price){
		return service.findByproductProdNameAndPrice(prodName, price);
	}
	
	@GetMapping("/products/from/{from}/to/{to}")
	public List<Product> findProductInRange(@PathVariable("from") float fromRange,@PathVariable("to") float toRange){
	   return service.findProductsInRange(fromRange, toRange);
    }
	
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int pid){
		ResponseEntity<Product> deletedProduct;   
		if(service.checkIfExist(pid)) { 
		service.deleteProductById(pid);
	    deletedProduct=new ResponseEntity<Product> (HttpStatus.OK);
		
		}
		else
			deletedProduct=new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		
		return deletedProduct;
	
	}
	

}
