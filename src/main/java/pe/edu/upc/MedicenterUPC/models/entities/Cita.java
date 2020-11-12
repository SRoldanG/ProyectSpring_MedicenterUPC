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

@Entity
@Table(name = "citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCita;

	@ManyToOne
	@JoinColumn(name="especialista_id")
	private Especialista especialista;
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@Column(name = "tipo_cita", nullable = false, length = 50)
	private String tipo_cita;
	
	@Column(name = "duracion", nullable = false, length = 40)
	private String duracion;
	
	@Column(name = "hora", nullable = false, length = 10)
	private String hora;
	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date fecha;
	
	@Column(name = "precio", nullable = false)
	private Float precio;
	
	@OneToMany(mappedBy="cita")
	private List<Receta> recetas;
	
	public Cita() {
		recetas= new ArrayList<>();
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Especialista getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Especialista especialista) {
		this.especialista = especialista;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getTipo_cita() {
		return tipo_cita;
	}

	public void setTipo_cita(String tipo_cita) {
		this.tipo_cita = tipo_cita;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public List<Receta> getRecetas() {
		return recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	
	
}
