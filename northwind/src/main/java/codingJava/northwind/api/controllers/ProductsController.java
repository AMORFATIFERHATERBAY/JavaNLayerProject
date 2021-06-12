package codingJava.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import codingJava.northwind.business.abstracts.ProductService;
import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;
import codingJava.northwind.core.utilities.results.SuccessDataResult;
import codingJava.northwind.entities.concretes.Product;
import codingJava.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping(value="/api/products")
@CrossOrigin
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		
		return this.productService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product ) {
		
		return this.productService.add(product);
		
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId( @RequestParam("productName") String productName, @RequestParam int categoryId){
		
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains( @RequestParam("productName") String productName){
		
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName, int categoryId){
		
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByNameAndCategoryId")
	public DataResult<List<Product>> getByNameAndCategoryId(@RequestParam("productName") String productName, int categoryId){
		
		return this.productService.getByNameAndCategory(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(String productName){
		
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getAllByPage")
	DataResult<List<Product>> getAll(int pageNo, int pageSize){
		
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllSortDesc")
    DataResult<List<Product>> getAllSortedDesc() {
	
		return this.productService.getAllSortedDesc();
    }
	
	@GetMapping("/getAllSortAsc")
    DataResult<List<Product>> getAllSortedAsc() {
	
		return this.productService.getAllSortedAsc();
    }
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		
		return this.productService.getProductWithCategoryDetails();
	}
}
