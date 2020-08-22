package mx.unatienda.validator;

import mx.unatienda.dto.ProductDTO;
import mx.unatienda.entity.Product;
import mx.unatienda.exception.ValidateServiceException;

public class ProductValidator {
	
	public static void save(ProductDTO product) {
		if (product.getNombre() == null || product.getNombre().trim().isEmpty()) {
			throw new ValidateServiceException ("Necesitas escribir el nombre.");
		}
		 if (product.getPrecio()<0) {
			throw new ValidateServiceException ("El precion no puede ser negativo.");
		}
		
		 if (product.getNombre()== null) {
			throw new ValidateServiceException ("El precio es requerido.");
		}
		// 
		 if (product.getNombre().length()>50) {
			throw new ValidateServiceException ("El nombre es muy largo.");
		}
	}  
}
 