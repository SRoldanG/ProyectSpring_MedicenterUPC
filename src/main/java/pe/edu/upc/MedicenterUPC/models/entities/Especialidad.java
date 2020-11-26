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
	private Integer id_Especialidad;
	
	@Column(name = "nombres", length = 20, nullable = false)
	private String nombres;
	 
	@OneToMany(mappedBy="especialidad")
	private List<Especialista> especialistas;
	
	public Especialidad() {
		especialistas= new ArrayList<>();
	}
	
	
	public void setId_Especialidad(Integer id_Especialidad) {
		this.id_Especialidad= id_Especialidad;
	}
	 public Integer getId_Especialidad() {
		return id_Especialidad;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public List<Especialista> getEspecialistas() {
		return especialistas;
	}


	public void setEspecialistas(List<Especialista> especialistas) {
		this.especialistas = especialistas;
	}
	 

}
