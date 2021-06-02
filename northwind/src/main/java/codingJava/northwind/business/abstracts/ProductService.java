package codingJava.northwind.business.abstracts;

import java.util.List;

import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;
import codingJava.northwind.entities.concretes.Product;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	
	Result add(Product product);
	
    DataResult<Product> getByProductName(String productName);
	
    DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

}
