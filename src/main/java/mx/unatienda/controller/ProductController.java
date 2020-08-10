package mx.unatienda.controller;

import java.util.List;
import mx.unatienda.dto.ProductDTO;
 
public interface ProductController {

	ProductDTO findById();
	
	List<ProductDTO> getAllProducts();
	
	ProductDTO create();
	
	ProductDTO update();
	
	ProductDTO delete();
	
	List<ProductDTO> findByRangeOfPrice();
	
	List<ProductDTO> orderByPrice();
	
	ProductDTO findByMark();
}
