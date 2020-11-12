package pe.edu.upc.MedicenterUPC.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReceta;
	@ManyToOne
	@JoinColumn(name="cita_id")
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name="med_clinica_ID")
	private MedicamentosXClinica medicamentos;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	
	
	public Integer getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(Integer idReceta) {
		this.idReceta = idReceta;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public MedicamentosXClinica getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(MedicamentosXClinica medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
