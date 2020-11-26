package pe.edu.upc.MedicenterUPC.models.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pacientes")
public class Paciente
{	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_paciente;
	
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@Column(name = "nombres", length = 40, nullable = false)
	private String nombres;
	
	@ManyToOne			
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@Column(name = "distrito", length = 50, nullable = false)
	private String distritos;
	
	@Column(name = "celular", length = 9, nullable = false)
	private String celular;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "nacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date nacimiento;	
    
    @OneToMany(mappedBy="paciente")
    private List<Cita> citas;
    
	@OneToMany(mappedBy="paciente")
    private List<Receta> recetas;
    
	public Paciente() {
		citas= new ArrayList<>(); recetas= new ArrayList<>();}

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public String getDistritos() {
		return distritos;
	}

	public void setDistritos(String distritos) {
		this.distritos = distritos;
	}
    
	

    
}
