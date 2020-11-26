package pe.edu.upc.MedicenterUPC.models.entities;



import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "hora", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date hora;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Transient
	private String fecha_texto;
	
	@Transient
	private String hora_texto;
	
	@Column(name = "precio", nullable = false)
	private Float precio;

	public Cita() {
		
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


	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
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

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getFecha_texto() {
		return fecha_texto;
	}

	public void setFecha_texto(String fecha_texto) {
		this.fecha_texto = fecha_texto;
	}

	public String getHora_texto() {
		return hora_texto;
	}

	public void setHora_texto(String hora_texto) {
		this.hora_texto = hora_texto;
	}

	
	
}
