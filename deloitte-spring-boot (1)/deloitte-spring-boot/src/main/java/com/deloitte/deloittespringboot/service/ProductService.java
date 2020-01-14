package com.deloitte.deloittespringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.deloittespringboot.model.Product;
import com.deloitte.deloittespringboot.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public List<Product> getAllProduct(){
		return repo.findAll();
	}
	
	public Product getProduct(int pid) {
		return repo.getOne(pid);
	}
	
	public void deleteProductById(int pid) {
		repo.deleteById(pid);
	}
	
	public boolean checkIfExist(int pid) {
		return repo.existsById(pid);
	}
	
	public Product findByproductProdName(String prodName) {
		return repo.findByprodName(prodName);
	}
	
	public Product findByproductProdNameAndPrice(String prodName,float price) {
		return repo.findByprodNameAndPrice(prodName, price);
	}
	
	public List<Product> findProductsInRange(float from,float to){
		return repo.findProductsInRange(from, to);
	}

}
