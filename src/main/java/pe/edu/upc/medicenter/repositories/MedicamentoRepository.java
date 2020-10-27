package pe.edu.upc.medicenter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.medicenter.models.entities.Medicamento;
@Service
public interface MedicamentoRepository extends JpaRepository<Medicamento,Integer>{
	List<Medicamento> findByNombreContaining(String nombre) throws Exception;	
}
