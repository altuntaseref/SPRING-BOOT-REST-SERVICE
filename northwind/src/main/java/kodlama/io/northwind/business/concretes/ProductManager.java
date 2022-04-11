package kodlama.io.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.core.utilities.results.SuccsessDataResult;
import kodlama.io.northwind.core.utilities.results.SuccsessResult;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	
	@Autowired //product daoyu enjekte etmek için kullandık.

	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccsessDataResult<List<Product>>
		(this.productDao.findAll(),"Data Listelendi");
				
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccsessResult("Ürün eklenndi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccsessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		return new SuccsessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		return new SuccsessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccsessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccsessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccsessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccsessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable= PageRequest.of(pageNo-1, pageSize);
		
		return  new SuccsessDataResult<List<Product>>( this.productDao.findAll(pageable).getContent() );
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		
		return  new SuccsessDataResult<List<Product>>( this.productDao.findAll(sort),"BAŞARILI" );
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		 return new SuccsessDataResult<List<ProductWithCategoryDto>>
			(this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
	}

	/*@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDtos() {
		
		 return new SuccsessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDtos(),"Data Listelendi");
	}*/

}
