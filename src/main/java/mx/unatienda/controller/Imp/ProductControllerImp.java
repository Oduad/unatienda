package mx.unatienda.controller.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unatienda.controller.ProductController;
import mx.unatienda.dto.ProductDTO;
import mx.unatienda.service.ProductService;

/*
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
*/

@RestController
@RequestMapping(path = "products")
public class ProductControllerImp implements ProductController {
	
	private ProductService productService;
	
	@Autowired
    public ProductControllerImp(ProductService productService) {
        this.productService = productService;

    }
	
	//private ProductConverter converter = new PathConverter();
	
	@Override
	@GetMapping(value = "/{productId}")//-->{Esto es pathParameter}
	//public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") Long productId){
		//Product product = productService.getProductById(productId);
		//return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.OK);
	public ProductDTO getProductById(@PathVariable("productId") Long productId) {
		return productService.getProductById(productId);
	}
	
	@Override
	@GetMapping(value = "")						//--> URL en la cual responde
	//public ResponseEntity<ProductDTO> getAllProducts(){
		//return new ResponseEntity<List<ProductDTO>>(dtoProducts,HttpStatus.OK);
	public List<ProductDTO> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@Override
	@PostMapping(value = "")
	/*public ResponseEntity<ProductDTO> createProduct(){
		return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.CREATED);*/
	public ProductDTO createProduct(@RequestBody ProductDTO product){
		return productService.saveProduct(product);  
	}
	
	@Override
	@PutMapping(value = "")
	/*public ResponseEntity<ProductDTO> updateProduct(){
		return new ResponseEntity<ProductDTO>(productDTO,HttpStatus.CREATED);*/
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productService.saveProduct(productDTO);
	}
	
	@Override
	@DeleteMapping(value = "/{productId}")
	public void deleteProduct(@PathVariable("productId") Long productId){
		productService.deleteProduct(productId); 
	}
	
	@Override
	@GetMapping(value = "/{p1}/{p2}")
	public List<ProductDTO> findByRangeOfPrice(@PathVariable("p1") double d1, @PathVariable("p2") double d2){
		return productService.findByRangeOfPrice(d1,d2);
	}

	@Override
	@GetMapping(value = "/orderByPrice/{sortByPrice}")
	public List<ProductDTO> orderByPrice(@PathVariable("sortByPrice") double price) {
		return productService.orderByPrice();
	}
	 
	/*@PutMapping(value = "/products")
	public ResponseEntity<ProductDTO> orderByPrice(){
		
		return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.CREATED);
	}*/

	@Override
	@GetMapping(value = "/findByMark/{marca}")
	public List<ProductDTO> findByMark(@PathVariable("marca") String marca) {
		return productService.findByMark(marca);
	}
}
