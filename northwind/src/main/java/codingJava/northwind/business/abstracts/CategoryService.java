package codingJava.northwind.business.abstracts;

import java.util.List;

import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;
import codingJava.northwind.entities.concretes.Category;

public interface CategoryService {
	
    DataResult<List<Category>> getAll();
	
	DataResult<List<Category>> getAllSortedAsc();
	
	DataResult<List<Category>> getAllSortedDesc();
	
	DataResult<List<Category>> getAll(int pageNo, int pageSize);
	
	Result add(Category category);
	
    DataResult<Category> getByCategoryName(String categoryName);

	
    DataResult<List<Category>> getByCategoryIdIn(List<Integer> categories);
	
    DataResult<List<Category>> getByCategoryNameContains(String productName);
	
    DataResult<List<Category>> getByCategoryNameStartsWith(String productName);
}
