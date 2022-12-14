import com.java.ecom.repo.ProductRepo;
import com.java.ecom.service.ProductService;
import com.java.ecom.service.ProductServiceImpl;

public class Application {
	public static void main(String args[]) throws Exception {
		ProductRepo repo = new ProductRepo();
		ProductService productService = new ProductServiceImpl(repo);
		productService.createProduct("1234", "Dell-Laptop", 10);
		System.out.print(productService.getInventory("1234"));
	}
}
