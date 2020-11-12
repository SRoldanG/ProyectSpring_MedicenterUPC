package pe.edu.upc.MedicenterUPC.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.MedicenterUPC.models.entities.Medicamento;
@Service
public interface MedicamentoRepository extends JpaRepository<Medicamento,Integer>{
	List<Medicamento> findByNombreStartingWith(String nombre) throws Exception;	
}
