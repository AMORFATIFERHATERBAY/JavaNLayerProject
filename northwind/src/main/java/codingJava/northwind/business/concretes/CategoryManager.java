package codingJava.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import codingJava.northwind.business.abstracts.CategoryService;
import codingJava.northwind.core.utilities.results.DataResult;
import codingJava.northwind.core.utilities.results.Result;
import codingJava.northwind.core.utilities.results.SuccessDataResult;
import codingJava.northwind.core.utilities.results.SuccessResult;
import codingJava.northwind.dataAccess.abstracts.CategoryDao;
import codingJava.northwind.entities.concretes.Category;

@Service
public class CategoryManager implements CategoryService {
	
	private CategoryDao categoryDao;
	
	
	@Autowired
	public CategoryManager(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public DataResult<List<Category>> getAll() {
		
		return new SuccessDataResult<List<Category>>(
				this.categoryDao.findAll(),"Categories are listed");
	}

	@Override
	public DataResult<List<Category>> getAllSortedAsc() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "categoryName");
		
		return new SuccessDataResult<List<Category>>(
				this.categoryDao.findAll(sort), "Successfully");
	}

	@Override
	public DataResult<List<Category>> getAllSortedDesc() {
		
        Sort sort = Sort.by(Sort.Direction.DESC, "categoryName");
		
		return new SuccessDataResult<List<Category>>(
				this.categoryDao.findAll(sort), "Successfully");
		
	}

	@Override
	public DataResult<List<Category>> getAll(int pageNo, int pageSize) {
		
		Pageable pageAble = PageRequest.of(pageNo, pageSize);
		
		return new SuccessDataResult<List<Category>>(
				this.categoryDao.findAll(pageAble).getContent(), "Successfully");
	}

	@Override
	public Result add(Category category) {
		
		this.categoryDao.save(category);
		
		return new SuccessResult("The category is added successfully");
	}

	@Override
	public DataResult<Category> getByCategoryName(String categoryName) {
		
		return new SuccessDataResult<Category>(
				this.categoryDao.getByCategoryName(categoryName),"The category is listed successfully");
	}

	@Override
	public DataResult<List<Category>> getByCategoryIdIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Category>>(
				this.categoryDao.getByCategoryIdIn(categories), "Categories are listed");
	}

	@Override
	public DataResult<List<Category>> getByCategoryNameContains(String productName) {
		
		return new SuccessDataResult<List<Category>>(
				this.categoryDao.getByCategoryNameContains(productName));
	}

	@Override
	public DataResult<List<Category>> getByCategoryNameStartsWith(String productName) {
		
		return new SuccessDataResult<List<Category>>(
				this.categoryDao.getByCategoryNameStartsWith(productName));
	}

}
