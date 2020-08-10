package mx.unatienda.service;

import java.util.List;
import mx.unatienda.dto.ProductDTO;

public interface ProductService {
 
	List<ProductDTO> getAllProducts();
	
	ProductDTO getProductById();
	
	ProductDTO updateProduct();
	
	ProductDTO deleteProduct();
	
	List<ProductDTO> findByRangeOfPrice();
	
	List<ProductDTO> orderByPrice();
	
	ProductDTO findByMark();
	
}
