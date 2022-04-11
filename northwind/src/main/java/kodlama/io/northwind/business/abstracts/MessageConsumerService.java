package kodlama.io.northwind.business.abstracts;

import kodlama.io.northwind.entities.concretes.Product;

public interface MessageConsumerService {

	String listener(Product product);
	
}
