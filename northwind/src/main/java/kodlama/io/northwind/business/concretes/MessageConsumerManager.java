package kodlama.io.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import kodlama.io.northwind.business.abstracts.MessageConsumerService;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Product;

@Component
public class MessageConsumerManager implements MessageConsumerService {

	private ProductDao productDao;
	@Autowired
	public MessageConsumerManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	@JmsListener(destination = "example-queue")
	public String listener(Product product) {
		this.productDao.getByProductName(product.getProductName());
		return null;
	}

}
