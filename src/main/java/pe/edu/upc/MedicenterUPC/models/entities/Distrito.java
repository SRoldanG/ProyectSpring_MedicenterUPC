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
@Table(name = "distritos")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "provincia", length = 30, nullable = false)
	private String provincia;
	
	@OneToMany(mappedBy = "distrito")		// 1(@OneToMany), 4(mappedBy)
	private List<Paciente> pacientes;
	
	@OneToMany(mappedBy="distrito")
	private List<Clinica> clinicas;
	
	@OneToMany(mappedBy="distrito")
	private List<Especialista> especialistas;

	public Distrito() {
		pacientes = new ArrayList<>();
		especialistas= new ArrayList<>();
		clinicas= new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Especialista> getEspecialistas() {
		return especialistas;
	}

	public void setEspecialistas(List<Especialista> especialistas) {
		this.especialistas = especialistas;
	}

	
}
