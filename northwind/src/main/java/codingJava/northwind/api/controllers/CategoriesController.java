package codingJava.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import codingJava.northwind.business.abstracts.CategoryService;
import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;
import codingJava.northwind.entities.concretes.Category;


@RequestMapping("/api/categories")
@RestController 
@CrossOrigin
public class CategoriesController {
	
	private CategoryService categoryService;

	@Autowired
	public CategoriesController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Category>> getAll(){
		
		return this.categoryService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Category category){
		
		return this.categoryService.add(category);
		 
	}
	
	@GetMapping("/getByCategoryName")
	public DataResult<Category> getByCategoryName(@RequestParam String categoryName){
		
		return this.categoryService.getByCategoryName(categoryName);
	}
	
	
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Category>> getByCategoryIdIn(List<Integer> categories){
		
		return this.categoryService.getByCategoryIdIn(categories);
	}
	
	@GetMapping("/getByCategoryNameStartsWith")
	public DataResult<List<Category>> getByCategoryNameStartsWith(String categoryName){
		
		return this.categoryService.getByCategoryNameStartsWith(categoryName);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Category>> getAll(int pageNo, int pageSize){
		
		return this.categoryService.getAll(pageNo, pageSize);
	}
	
	
	@GetMapping("/getAllSortDesc")
    DataResult<List<Category>> getAllSortedDesc() {
	
		return this.categoryService.getAllSortedDesc();
    }
	
	@GetMapping("/getAllSortAsc")
    DataResult<List<Category>> getAllSortedAsc() {
	
		return this.categoryService.getAllSortedAsc();
    }
	

}
