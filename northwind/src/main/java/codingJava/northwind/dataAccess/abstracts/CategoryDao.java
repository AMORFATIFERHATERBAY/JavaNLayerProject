package codingJava.northwind.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import codingJava.northwind.entities.concretes.Category;



public interface CategoryDao extends JpaRepository<Category, Integer> {

	Category getByCategoryName(String categoryName);
	
    List<Category> getByCategoryIdIn(List<Integer> categories);
	
	List<Category> getByCategoryNameContains(String productName);
	
	List<Category> getByCategoryNameStartsWith(String productName);

}
