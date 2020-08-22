package mx.unatienda.serviceImp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.unatienda.dto.ProductDTO;
import mx.unatienda.entity.Product;
import mx.unatienda.exception.NoDataFoundException;
import mx.unatienda.mapper.Mapper;
import mx.unatienda.repository.ProductRepository;
import mx.unatienda.service.ProductService;
import mx.unatienda.validator.ProductValidator;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	private Mapper mapper;
	
	    public ProductServiceImp(ProductRepository productRepo, Mapper mapper) {
	        this.productRepo = productRepo;
	        this.mapper = mapper;
	    }
	
	@Override
	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> products = new ArrayList<>();
		for (Product product : productRepo.findAll()) {
			products.add(mapper.fromEntity(product));
		}
		return products;
	}
	
	@Override 
	public ProductDTO getProductById(Long productId) {
		Optional<Product> product = productRepo.findById(productId);
		if (product.isPresent()) {
			return mapper.fromEntity(product.get());
		}
		throw new NoDataFoundException("Producto no encontrado.");
	}
	
	/*public void delete(Long productId) {
		Optional<Product> product = productRepo.findById(productId);
		productRepo.delete(product);
	}*/

	
	//Crear y actualizar
	@Override
	public ProductDTO saveProduct(ProductDTO productDTO) {
		//ProductValidator.save(producDTO);									//CREATE
		if(productDTO.getId() == null){
			ProductValidator.save(productDTO);
			Product newProduct = productRepo.save(mapper.fromProductDTO(productDTO));
			return mapper.fromEntity(newProduct);
		}	
			Product existProduct = productRepo.getOne(mapper.fromProductDTO(productDTO).getId());//UPDATE
			if(existProduct.getTipo()!=null) {
			existProduct.setNombre(productDTO.getNombre());
			existProduct.setPrecio(productDTO.getPrecio());
			existProduct.setMarca(productDTO.getMarca());
			existProduct.setTipo(productDTO.getTipo());
			existProduct.setDescripcion(productDTO.getDescripcion());
			return mapper.fromEntity(existProduct);
			}
			else {
				throw new NoDataFoundException("El producto no existe.");
			}
	}

	@Override
	public void deleteProduct(Long productId) { 
		try {
			productRepo.delete(productRepo.getOne(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//¿Cómo lo traduzco a NoData?
	} 
	
	public List<ProductDTO> findByRangeOfPrice(Double menor, Double mayor){
		List<ProductDTO> listaRango = new ArrayList<ProductDTO>();
		List<Product> lista = productRepo.findAll();
		for (Product product : lista) {
			if (product.getPrecio()>=menor && product.getPrecio()<=mayor) {
				listaRango.add(mapper.fromEntity(product));
			}
		}
		return listaRango;
	}
	
	/*public List<Double> orderByPrice(){
		List<Double> lista1 = new ArrayList<Double>();
		List<Product> lista = productRepo.findAll();
		
		for (Product product : lista) {
			lista1.add(product.getPrecio());
		}
		
		Collections.sort(lista1, (Double p1, Double p2)->p1.compareTo(p2));
		return lista1;
	}*/

	public List<ProductDTO> orderByPrice(){
	
		List<Product> lista = productRepo.findAll();
		List<ProductDTO> lista2 = new ArrayList<ProductDTO>();
		
		for (Product product : lista) {
			lista2.add(mapper.fromEntity(product));
		}

		//List<ProductDTO> listaOrd = lista2.stream().sorted((o1,o2)-> o1.getPrecio()-o2.getPrecio()).collect(Collectors.toList());
		List<ProductDTO> listaOrd2 = lista2.stream().sorted(Comparator.
				comparingDouble(ProductDTO::getPrecio)).collect(Collectors.toList());

		return listaOrd2;
	}

	@Override
	public List<ProductDTO> findByMark(String mark) {
		List<ProductDTO> listaMarca = new ArrayList<ProductDTO>();
		List<Product> lista = productRepo.findAll();
		for (Product product : lista) {
			if (product.getMarca().equals(mark)) {
				listaMarca.add(mapper.fromEntity(product));
			}
		}
		return listaMarca;
	}

}
