package mx.unatienda.service;

import java.util.List;
import mx.unatienda.dto.ProductDTO;
import mx.unatienda.entity.Product;

public interface ProductService {
 
	List<ProductDTO> getAllProducts();
	
	ProductDTO getProductById(Long productId);
	
	ProductDTO saveProduct(ProductDTO productDTO);
	
	void deleteProduct(Long productId);
	
	List<ProductDTO> findByRangeOfPrice(Double menor, Double mayor);
	
	//List<Double> orderByPrice();
	List<ProductDTO> orderByPrice();
	
	List<ProductDTO> findByMark(String mark);
	
}
