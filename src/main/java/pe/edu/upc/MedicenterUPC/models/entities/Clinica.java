package pe.edu.upc.MedicenterUPC.models.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clinicas")
public class Clinica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idC;
	@Column(name = "nombrec", nullable = false, length = 40)
	private String nombrec;
	@Column(name = "ubicacion", nullable = false, length = 40)
	private String ubicacion;
	
	@Column(name = "imagen", nullable = false, length = 50)
	private String imagen;
	
	@ManyToOne
	@JoinColumn(name="distrito_id")
	private Distrito distrito;
	
	@Column(name = "horario", nullable = false, length = 40)
	private String horario;

	@OneToMany(mappedBy="clinica")
	private List<Especialista> especialistas;
	
	@ManyToMany
	@JoinTable(name = "clinica_medicamento", 
		joinColumns = { @JoinColumn(name = "clinica_id", referencedColumnName = "idC") },
		inverseJoinColumns = { @JoinColumn(name = "medicamento_id", referencedColumnName = "Id") })
	private List<Medicamento> medicamentos;
	

	public Clinica() {
		especialistas= new ArrayList<>();
		medicamentos= new ArrayList<>();
		distrito= new Distrito();
	}

	public Integer getIdC() {
		return idC;
	}

	public void setIdC(Integer idC) {
		this.idC = idC;
	}

	public String getNombrec() {
		return nombrec;
	}

	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Especialista> getEspecialistas() {
		return especialistas;
	}

	public void setEspecialistas(List<Especialista> especialistas) {
		this.especialistas = especialistas;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	
}
