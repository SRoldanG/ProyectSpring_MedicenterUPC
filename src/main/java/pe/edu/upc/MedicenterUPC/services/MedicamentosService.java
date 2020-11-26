package pe.edu.upc.MedicenterUPC.services;

import java.util.List;

import pe.edu.upc.MedicenterUPC.models.entities.Medicamento;

public interface MedicamentosService extends CrudService<Medicamento, Integer>{
	List<Medicamento> findByNombre(String nombre) throws Exception;
}
