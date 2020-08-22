package mx.unatienda.mapper;

import org.springframework.stereotype.Component;

import mx.unatienda.dto.ProductDTO;
import mx.unatienda.entity.Product;

@Component
public class Mapper {

	public ProductDTO fromEntity(Product entity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(entity.getId());
		productDTO.setNombre(entity.getNombre());
		productDTO.setPrecio(entity.getPrecio());
		productDTO.setTipo(entity.getTipo());
		productDTO.setMarca(entity.getMarca());
		productDTO.setDescripcion(entity.getDescripcion());
		return productDTO;
	}
	
	public Product fromProductDTO(ProductDTO productDTO) {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setNombre(productDTO.getNombre());
		product.setPrecio(productDTO.getPrecio());
		product.setTipo(productDTO.getTipo());
		product.setMarca(productDTO.getMarca());
		product.setDescripcion(productDTO.getDescripcion());
		return product;
	}
	
}
