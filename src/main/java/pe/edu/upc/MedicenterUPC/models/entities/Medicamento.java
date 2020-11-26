package pe.edu.upc.MedicenterUPC.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="medicamentos")
public class Medicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer Id;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	private Integer stock;

	@Column(name = "precio_compra", nullable = false)
	private Float precioCompra;
	
	@Column(name = "precio_venta", nullable = false)
	private Float precioVenta;
	
	@ManyToMany(mappedBy = "medicamentos")	
	private List<Clinica> clinicas;

	@OneToMany(mappedBy="medicamento")
	private List<DetalleReceta> detalleRecetas;
	
	public Medicamento() {
		clinicas= new ArrayList<>();
		detalleRecetas=new ArrayList<>();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public Float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public List<DetalleReceta> getDetalleRecetas() {
		return detalleRecetas;
	}

	public void setDetalleRecetas(List<DetalleReceta> detalleRecetas) {
		this.detalleRecetas = detalleRecetas;
	}


	
}
