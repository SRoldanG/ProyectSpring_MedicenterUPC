package pe.edu.upc.MedicenterUPC.models.entities;


import java.util.ArrayList;
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

@Entity
@Table(name = "especialistas")
public class Especialista
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_especialista;
	
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@Column(name = "nombres", length = 40, nullable = false)
	private String nombres;
	
	@Column(name = "foto", nullable = false, length = 80)
	private String foto;
	
	@ManyToOne			
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@Column(name = "celular", length = 9, nullable = false)
	private String celular;
	
	@Column(name = "direccion", length = 50, nullable = false)
	private String direccion;
	
    @Column(name ="tiempo_experiencia", length = 2, nullable = false )
	private String tiempo_experiencia;// snake
    
    @Column(name ="email", length = 30, nullable = false )
	private String email;// snake
   
    @ManyToOne
    @JoinColumn(name="clinica_id")
	private Clinica clinica;
    
    @ManyToOne
    @JoinColumn(name="especialidad_id")
	private Especialidad especialidad;
    
    @OneToMany(mappedBy="especialista")
    private List<Cita> citas;
    
    @OneToMany(mappedBy="especialista")
    private List<Receta> recetas;
    
	public Especialista() {
		citas= new ArrayList<>();
		recetas= new ArrayList<>();
	}

	public Integer getId_especialista() {
		return id_especialista;
	}

	public void setId_especialista(Integer id_especialista) {
		this.id_especialista = id_especialista;
	}

	public String getTiempo_experiencia() {
		return tiempo_experiencia;
	}

	public void setTiempo_experiencia(String tiempo_experiencia) {
		this.tiempo_experiencia = tiempo_experiencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

}
