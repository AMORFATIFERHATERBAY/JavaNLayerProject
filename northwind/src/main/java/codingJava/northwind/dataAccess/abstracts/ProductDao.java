package codingJava.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import codingJava.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory(String productName, int categoryId);

}    

