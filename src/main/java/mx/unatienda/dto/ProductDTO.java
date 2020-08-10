package mx.unatienda.dto;

public class ProductDTO {

	private Long id;
	private String nombre;
	private Double precio;
	private String tipo;
	private String marca;
	private String descripcion;
	
	public ProductDTO(String nombre, Double precio, Long id, String tipo, String marca, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public String getTipo() {
		return tipo;
	}

	public String getMarca() {
		return marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
