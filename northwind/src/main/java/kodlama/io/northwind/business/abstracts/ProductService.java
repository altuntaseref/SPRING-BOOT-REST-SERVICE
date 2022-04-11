package kodlama.io.northwind.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>>  getAll(); //tüm ürünleri döndürüyor
	
	DataResult<List<Product>>  getAll(int pageNo, int pageSize);
	
	DataResult<List<Product>>  getAllSorted();
	
	Result add(Product product);
	
	//JPA Reository vasıtasyıla hangi verilerin kullınalacağını söylüyoruz

	DataResult<Product> getByProductName(String productName);
		
	DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
		
	DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
		
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
		
	DataResult<List<Product>> getByProductNameContains(String productName);
		
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	 
	@Query("From Product where productName=:productName and categoryId=:categoryId")
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
		
	DataResult<List<ProductWithCategoryDto>>getProductWithCategoryDetails();
}
