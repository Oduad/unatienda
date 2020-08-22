package mx.unatienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.unatienda.dto.ProductDTO;
import mx.unatienda.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{ //<Son genéricos>
	//<1,2>: 1 debe ser una clase que esté anotado con @Entity
	//<1,2>: 2 Corresponde al tipo de dato de llave primaria del primer argumento

}
