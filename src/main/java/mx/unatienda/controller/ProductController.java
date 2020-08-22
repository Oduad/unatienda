package mx.unatienda.controller;

import java.util.List;
import mx.unatienda.dto.ProductDTO;
import mx.unatienda.entity.Product;
 
public interface ProductController {

	ProductDTO getProductById(Long productId);
	
	List<ProductDTO> getAllProducts();
	
	ProductDTO createProduct(ProductDTO productDTO);
	
	ProductDTO updateProduct(ProductDTO productDTO);
	
	void deleteProduct(Long productId);
	
	List<ProductDTO> findByRangeOfPrice(double d1, double d2);
	
	List<ProductDTO> orderByPrice(double price);
	
	List<ProductDTO> findByMark(String marca);
}
