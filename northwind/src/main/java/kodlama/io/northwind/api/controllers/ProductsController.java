package kodlama.io.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.core.utilities.results.DataResult;
import kodlama.io.northwind.core.utilities.results.Result;
import kodlama.io.northwind.entities.concretes.Product;
import kodlama.io.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products") //dışarıdan istek geldiğinde controller karşılayacak
public class ProductsController {
	
	private ProductService productService; //API ile business arası iletişim için buraya çağırdık
	
	@Autowired //Projeyi tarayıp serisi buraya enjekte ediyor 
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") //kodlama.io/api/products/getall isteği gelirse burası çalışacak demek
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
		 
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		
		return this.productService.add(product);
		
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		
		return this.productService.getByProductName(productName);
		
	}

	@GetMapping("/getByProductNameAndCategory_CategoryId")
	public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
		return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
		
	}
		
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
		
		
	}
	
	@GetMapping("/getAllByPage")
	 public DataResult<List<Product>>  getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
		
	}
	
	@GetMapping("/getProductWithCategoryDetails") 
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
		 
	}
	
}
