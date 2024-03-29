package codingJava.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import codingJava.northwind.business.abstracts.ProductService;
import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;
import codingJava.northwind.core.utilities.results.SuccessDataResult;
import codingJava.northwind.core.utilities.results.SuccessResult;
import codingJava.northwind.dataAccess.abstracts.ProductDao;
import codingJava.northwind.entities.concretes.Product;
import codingJava.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager  implements ProductService {
	
	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}


	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.findAll(), "Products are listed");
	}

	@Override
	public Result add(Product product) {
		
		this.productDao.save(product);
		
		return new SuccessResult("Product is added successfully");
	}


	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName), "Product is listed");
	}


	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Product is listed");
	}


	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Products are listed");
	}


	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>(
				this.productDao.getByCategory_CategoryIdIn(categories), "Categories are listed");
	}


	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameContains(productName), "Products are listed");
	}


	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		
		return new SuccessDataResult<List<Product>>(
				this.productDao.getByProductNameStartsWith(productName),"Products are listed");
	}


	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(
				this.productDao.getByNameAndCategory(productName, categoryId),"Products are listed");
	}


	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageAble = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>(
				this.productDao.findAll(pageAble).getContent());
	}


	@Override
	public DataResult<List<Product>> getAllSortedDesc() {
		
		Sort sort  = Sort.by(Sort.Direction.DESC, "productName");
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Successfully");
	}
	
	@Override
    public DataResult<List<Product>> getAllSortedAsc() {
		
		Sort sort  = Sort.by(Sort.Direction.ASC, "productName");
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Successfully");
	}



	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(
				this.productDao.getProductWithCategoryDetails(),"Products detail is listed");
	}

}
