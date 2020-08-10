package mx.unatienda.controller.Imp;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerImp {
	
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDTO> findById(){
		
		return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.OK);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<ProductDTO> getAllProducts(){
		
		return new ResponseEntity<List<ProductDTO>>(dtoProducts,HttpStatus.OK);
	}
	
	@PostMapping(value = "/products")
	public ResponseEntity<ProductDTO> create(){
		
		return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/products")
	public ResponseEntity<ProductDTO> update(){
		
		return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<Void> delete(){
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<ProductDTO> findByRangeOfPrice(){
		
		return new ResponseEntity<ProductDTO>(range,HttpStatus.OK);
	}
	
	@PutMapping(value = "/products")
	public ResponseEntity<ProductDTO> orderByPrice(){
		
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<ProductDTO> findByMark(){
		
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
	}
}
