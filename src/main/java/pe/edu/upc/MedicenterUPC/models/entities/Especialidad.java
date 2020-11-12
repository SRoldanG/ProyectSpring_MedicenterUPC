package pe.edu.upc.MedicenterUPC.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "especialidades")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id_Especialidad;
	
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	 
	@OneToMany(mappedBy="especialidad")
	private List<Especialista> especialistas;
	
	public Especialidad() {
		especialistas= new ArrayList<>();
	}
	
	
	public void setId_Especialidad(Integer id_Especialidad) {
		Id_Especialidad = id_Especialidad;
	}
	 public Integer getId_Especialidad() {
		return Id_Especialidad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Especialista> getEspecialistas() {
		return especialistas;
	}


	public void setEspecialistas(List<Especialista> especialistas) {
		this.especialistas = especialistas;
	}
	 

}
